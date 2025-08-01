package com.example.memo.service;

import com.example.memo.dto.response.MemoResponse;
import com.example.memo.entity.MemoEntity;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReadMemo {
    private final MemoRepository memoRepository;

    @Transactional(readOnly = true)
    public List<MemoResponse> ReadAllMemo() {
        List<MemoEntity> memoEntities = memoRepository.findAll();

        List<MemoResponse> memoResponses = new ArrayList<>();

        for (MemoEntity memoEntity : memoEntities) {
            memoResponses.add(new MemoResponse(memoEntity));
        }
        return memoResponses;
    }

    @Transactional(readOnly = true)
    public MemoResponse ReadMemoById(Long id) {
        MemoEntity memoEntity = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 id에 맞는 메모가 없습니다")
        );
        return new MemoResponse(memoEntity);
    }
}
