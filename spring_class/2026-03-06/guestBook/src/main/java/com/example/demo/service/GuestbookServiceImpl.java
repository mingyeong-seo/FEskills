package com.example.demo.service;

import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.GuestbookRepository;
import com.example.demo.dtos.GuestbookDTO;
import com.example.demo.dtos.PageRequestDTO;
import com.example.demo.dtos.PageResultDTO;
import com.example.demo.entity.Guestbook;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor  // final로 선언된 필드의 초기화 작업을 수행해주는 역할을 한다.
public class GuestbookServiceImpl implements GuestbookService{
	 
	private final GuestbookRepository guestbookReopository;
	@Override
	    public Long register(GuestbookDTO guestbookDTO) {
			log.info("DTO--------------------------------------");
			log.info(guestbookDTO);
			
			// 상속된 default 메서드를 이용해서 DTO -> Entity변환한다
			Guestbook entity = dtoToEntity(guestbookDTO);
			
			log.info(entity);
			
			guestbookReopository.save(entity);
			return entity.getBno();
	    }
	@Override
	public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO){
		// 이 메서드에서는 요청된 DTO에서 Pageable 객체를 얻어내고, 필요에 따라서 Sorting 객체도 조정
		// 얻어낸 객체에서 전달될 목록을 담고있는 Page 객체를 얻어낸다
		// 이 얻어낸 Entity 목록들을 DTO 로 변환해주는 함수 객체를 만들어서
		// PageResult 객체에 넘긴다
		Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
		Page<Guestbook> result = guestbookReopository.findAll(pageable);
		
		Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDto(entity));
		return new PageResultDTO<>(result, fn);
	}

	@Override
	public GuestbookDTO read(Long bno) {
		Optional<Guestbook> result = guestbookReopository.findById(bno);
		
		return result.isPresent()?entityToDto(result.get()):null;
	}
	
	@Override
	public void modify(GuestbookDTO dto) {
		// 글 번호에 해당하는 글이 존재하는지 확인 후, 변경될 내용을 entity 에 넣고,
		// save 한다. 
		Optional<Guestbook> result = guestbookReopository.findById(dto.getBno());
		
		if(result.isPresent()) {
			Guestbook  entity = result.get();
			
			entity.changeTitle(dto.getTitle());
			entity.changeContent(dto.getContent());
			
			guestbookReopository.save(entity);
			
		}
	}
	
	@Override
	public void remove(Long bno) {
		guestbookReopository.deleteById(bno);
		
	}
	
	
}
