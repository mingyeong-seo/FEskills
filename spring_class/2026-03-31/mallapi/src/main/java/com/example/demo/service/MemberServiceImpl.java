package com.example.demo.service;

import java.util.LinkedHashMap;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.mallapi.domain.Member;
import com.example.demo.mallapi.domain.MemberRole;
import com.example.demo.mallapi.dto.MemberDTO;
import com.example.demo.mallapi.repository.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    private Member makeSocialMember(String email, String nickname) {
        String tempPassword = makeTempPassword();

        Member member = Member.builder()
                .email(email)
                .pw(passwordEncoder.encode(tempPassword))
                .nickname(nickname)
                .social(true)
                .build();

        member.addRole(MemberRole.USER);
        return member;
    }

    private String makeTempPassword() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            sb.append((char) ((int) (Math.random() * 26) + 65));
        }

        return sb.toString();
    }

    @Override
    public MemberDTO getKakaoMember(String accessToken) {

        LinkedHashMap<String, Object> kakaoInfo = getKakaoInfo(accessToken);

        String email = (String) kakaoInfo.get("email");
        String nickname = (String) kakaoInfo.get("nickname");

        log.info("소셜 로그인 email ------> " + email);
        log.info("소셜 로그인 nickname ---> " + nickname);

        Optional<Member> result = memberRepository.findById(email);

        if (result.isPresent()) {
            return entityDTO(result.get());
        }

        Member socialMember = makeSocialMember(email, nickname);
        memberRepository.save(socialMember);

        return entityDTO(socialMember);
    }

    private LinkedHashMap<String, Object> getKakaoInfo(String accessToken) {

        String kakaoGetUserURL = "https://kapi.kakao.com/v2/user/me";

        if (accessToken == null) {
            throw new RuntimeException("Access Token is null");
        }

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + accessToken);
        httpHeaders.add("Content-Type", "application/x-www-form-urlencoded");

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        UriComponents uriBuilder = UriComponentsBuilder
                .fromUriString(kakaoGetUserURL)
                .build();

        ResponseEntity<LinkedHashMap> response = restTemplate.exchange(
                uriBuilder.toUri(),
                HttpMethod.GET,
                entity,
                LinkedHashMap.class
        );

        log.info(response);

        LinkedHashMap<String, Object> bodyMap = response.getBody();

        log.info("================");
        log.info(bodyMap);

        Long id = ((Number) bodyMap.get("id")).longValue();

        LinkedHashMap<String, Object> properties =
                (LinkedHashMap<String, Object>) bodyMap.get("properties");

        String nickname = (String) properties.get("nickname");
        String email = id + "@kakao.com";

        LinkedHashMap<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("email", email);
        resultMap.put("nickname", nickname);

        return resultMap;
    }
}