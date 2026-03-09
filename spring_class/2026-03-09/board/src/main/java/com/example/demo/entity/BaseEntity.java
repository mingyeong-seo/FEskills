package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass // Super 클래스로만 존재한다는 의미임.. 테이블 만들지 않음
// Entity 리스너란넘에게 엔티티 객체가 in/update 시에 이 엔티티를 참조해서 날짜값을 가져오도록 등록해야한다
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
public abstract class BaseEntity {
	@CreatedDate
	// 테이블의 regdate 컬럼은 이 속성의 값을 가져다 사용하고
	// 엔티티가 Update 되어도, 이 날짜는 update 금지하라는 의미
	@Column(name = "regdate", updatable = false)
	private LocalDateTime regDate;
	
	@LastModifiedDate // 수정된 날짜를 생성하도록 하는 어노테이션,, 엔티티가 변경되면 이 값도 자동으로 수정됨
	@Column(name = "moddate")
	private LocalDateTime modDate;
}
