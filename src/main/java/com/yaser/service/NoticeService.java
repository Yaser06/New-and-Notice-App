package com.yaser.service;


import com.yaser.dto.NoticeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Yaser
 */
public interface NoticeService {

    NoticeDto save(NoticeDto noticeDto);

    void delete(Long id);

    NoticeDto update(NoticeDto noticeDto, Long id);

    List<NoticeDto> getAll();

    Page<NoticeDto> getAll(Pageable pageable);
}
