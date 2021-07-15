package com.yaser.service.impl;

import com.yaser.dto.NewDto;
import com.yaser.dto.NoticeDto;
import com.yaser.entity.New;
import com.yaser.entity.Notice;
import com.yaser.repo.NewRepository;
import com.yaser.repo.NoticeRepository;
import com.yaser.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yaser
 */
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

    private final NewRepository newRepository;
    private final NoticeRepository noticeRepository;

    @Override
    public NoticeDto save(NoticeDto noticeDto) {
        Notice notice=new Notice();
        notice.setContent(noticeDto.getContent());
        notice.setTopic(noticeDto.getTopic());
        notice.setDate(new Date());
        notice.setNewsId(noticeDto.getNewsId());
        notice.setStatus(noticeDto.isStatus());
        noticeRepository.save(notice);

        noticeDto.setId(noticeDto.getId());
        return noticeDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public NoticeDto update(NoticeDto noticeDto, Long id) {
        Notice notices = noticeRepository.findById(id).get();
        notices.setContent(noticeDto.getContent());
        notices.setTopic(noticeDto.getTopic());
        notices.setDate(new Date());
        notices.setStatus(noticeDto.isStatus());
        notices.setNewsId(noticeDto.getNewsId());
        final Notice noticeDb =noticeRepository.save(notices);
        noticeDto.setId(noticeDb.getNewsId());
        return noticeDto;
    }

    @Override
    public List<NoticeDto> getAll() {
        List <Notice> notices = noticeRepository.findAll();
        List <NoticeDto> noticeDtos =new ArrayList<>();

        notices.forEach(it->{
            NoticeDto noticeDto = new NoticeDto();
            noticeDto.setId(it.getId());
            noticeDto.setTopic(it.getTopic());
            noticeDto.setContent(it.getContent());
            noticeDto.setDate(it.getDate());
            noticeDto.setStatus(it.isStatus());
            noticeDtos.add(noticeDto);
        });
        return noticeDtos;
    }

    @Override
    public Page<NoticeDto> getAll(Pageable pageable) {
        return null;
    }
}
