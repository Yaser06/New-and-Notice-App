package com.yaser.service;

import com.yaser.dto.NewDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Yaser
 */
public interface NewService {

    NewDto save(NewDto newDto);

    void delete(Long id);

    NewDto update(NewDto newDto,Long id);

    List<NewDto> getAll();

    Page<NewDto> getAll(Pageable pageable);
}
