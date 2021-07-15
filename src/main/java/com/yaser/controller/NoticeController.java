package com.yaser.controller;

import com.yaser.dto.NewDto;
import com.yaser.dto.NoticeDto;
import com.yaser.service.NewService;
import com.yaser.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yaser
 */
@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
@CrossOrigin
public class NoticeController {


    private final NoticeService noticeService;

    @PostMapping
    public ResponseEntity<NoticeDto> save (@RequestBody NoticeDto noticeDto) {
        return ResponseEntity.ok(noticeService.save(noticeDto));
    }

    @GetMapping
    public ResponseEntity<List<NoticeDto>> getAll(){
        return ResponseEntity.ok(noticeService.getAll());
    }

    @PutMapping({ "/{id}"})
    public ResponseEntity<NoticeDto> update (@RequestBody NoticeDto noticeDto,@PathVariable Long id) {
        return ResponseEntity.ok(noticeService.update(noticeDto,id));
    }
}
