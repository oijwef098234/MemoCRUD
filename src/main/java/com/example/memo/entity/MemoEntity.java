package com.example.memo.entity;

import com.example.memo.dto.request.MemoRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)

public class MemoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @CreatedDate
    @Column(name = "date", updatable = false)
    private LocalDateTime date;

    @LastModifiedDate
    @Column(name = "lastdate")
    private LocalDateTime lastdate;

    public MemoEntity(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = LocalDateTime.now();
        this.lastdate = LocalDateTime.now();
    }

    public void updateMemo(String title, String content) {
        this.title = title;
        this.content = content;
        this.lastdate = LocalDateTime.now();
    }
}
