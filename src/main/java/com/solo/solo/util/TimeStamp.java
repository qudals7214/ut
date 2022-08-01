package com.solo.solo.util;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 나 (부모)를 상속받은 자식 클래스에게 멤버 변수들을 > 컬럼으로 부여함
@EntityListeners(AuditingEntityListener.class) // <-실시간으로 엔터티의 변화 상황을 지켜보게 <- 됨테이블 변화를 캐치하고 반영
public class TimeStamp {

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}
