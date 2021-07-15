package com.yaser.service.impl;

import com.yaser.dto.NewDto;
import com.yaser.entity.New;
import com.yaser.entity.Notice;
import com.yaser.repo.NewRepository;
import com.yaser.repo.NoticeRepository;
import com.yaser.service.NewService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yaser
 */

@Service
@RequiredArgsConstructor
public class NewServiceImpl implements NewService {

    private final NewRepository newRepository;
    private final NoticeRepository noticeRepository;

    @Override
    @Transactional
    public NewDto save(NewDto newDto) {
        New news=new New();
        news.setContent(newDto.getContent());
        news.setTopic(newDto.getTopic());
        news.setDate(new Date());
        news.setStatus(newDto.getStatus());
        news.setHaberLink(newDto.getHaberLink());

        final New newDb =newRepository.save(news);
        newDto.setId(newDb.getId());
        return newDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public NewDto update(NewDto newDto, Long id) {

        New news = newRepository.findById(id).get();
        news.setContent(newDto.getContent());
        news.setTopic(newDto.getTopic());
        news.setDate(new Date());
        news.setStatus(newDto.getStatus());
        news.setHaberLink(newDto.getHaberLink());
        final New newDb =newRepository.save(news);
        newDto.setId(newDb.getId());
        return newDto;
    }

    @Override
    public List<NewDto> getAll() {
        List <New> news = newRepository.findAll();
        List <NewDto> newDtos =new ArrayList<>();

        news.forEach(it->{
            NewDto newDto = new NewDto();
            newDto.setId(it.getId());
            newDto.setTopic(it.getTopic());
            newDto.setContent(it.getContent());
            newDto.setDate(it.getDate());
            newDto.setStatus(it.isStatus());
            newDto.setHaberLink(it.getHaberLink());
            newDtos.add(newDto);
        });
        return newDtos;
    }


    @Override
    public Page<NewDto> getAll(Pageable pageable) {
        return null;
    }
}
