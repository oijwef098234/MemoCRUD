package com.example.memo.service;

import com.example.memo.dto.request.MemoRequest;
import com.example.memo.dto.response.MemoResponse;
import com.example.memo.entity.MemoEntity;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateMemo {
    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponse createMemo(MemoRequest memoRequest) {
        MemoEntity memoEntity = new MemoEntity(memoRequest.getTitle(), memoRequest.getContent());
        MemoEntity savedMemoEntity = memoRepository.save(memoEntity);
        return new MemoResponse(savedMemoEntity);
    }
}
