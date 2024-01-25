package insta.hyunstagram.domain;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(value = AuditingEntityListener.class)
@Getter
@MappedSuperclass   // test 에서  상속받은 createdDate를 화면에 보이게 하기 위함
public class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @PrePersist
    public void onPrePersist() {
        this.createdDate=LocalDateTime.now();
    }
}
