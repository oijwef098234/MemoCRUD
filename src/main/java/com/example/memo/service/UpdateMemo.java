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
public class UpdateMemo {
    private final MemoRepository memoRepository;

    @Transactional
    public MemoResponse updateMemo(Long id, MemoRequest dto) {
        MemoEntity memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 메모가 없습니다")
        );

        memo.updateMemo(dto.getTitle(), dto.getContent());

        return new MemoResponse(memo);
    }
}
