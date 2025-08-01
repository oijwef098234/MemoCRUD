package com.example.memo.dto.response;

import com.example.memo.entity.MemoEntity;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoResponse {
    private Long id;
    private String title;
    private String content;

    private LocalDateTime date;
    private LocalDateTime lastdate;

    public MemoResponse(MemoEntity memoEntity) {
        this.id = memoEntity.getId();
        this.title = memoEntity.getTitle();
        this.content = memoEntity.getContent();
        this.date = memoEntity.getDate();
        this.lastdate = memoEntity.getLastdate();
    }


}
