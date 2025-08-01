package com.example.memo.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemoRequest {
    private String title;
    private String content;
}
