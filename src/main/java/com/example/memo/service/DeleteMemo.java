package com.example.memo.service;

import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteMemo {
    private final MemoRepository memoRepository;

    @Transactional
    public void deleteMemo(Long id) {
        if(!memoRepository.existsById(id)){
            throw new IllegalArgumentException("해당 아이디에 맞는 메모 없음");
        }
        memoRepository.deleteById(id);
    }
}
