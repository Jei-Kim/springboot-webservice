package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/* 모든 Entity의 상위 클래스가 되어 Entity들의 createdDate, modifiedDate를 자동으로 관리 */
@Getter
@MappedSuperclass // JPA Entity 클래스들이 해당 클래스를 상속할 경우, 아래 필드들도 컬럼으로 인식함
@EntityListeners(AuditingEntityListener.class) // Auditing기능 포함시킴
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate; // Entity가 생성되어 저장될 때 시간 자동 저장

    @LastModifiedDate
    private LocalDateTime modifiedDate;  // 조회한 Entity의 값을 변경할 때 시간 자동 저장
}
