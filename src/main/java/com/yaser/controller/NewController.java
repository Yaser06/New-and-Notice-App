package com.yaser.controller;

import com.yaser.dto.NewDto;
import com.yaser.service.NewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yaser
 */

@RestController
@RequestMapping("/news")
@RequiredArgsConstructor
@CrossOrigin
public class NewController {

    private final NewService newService;

    @PostMapping
    public ResponseEntity<NewDto> save (@RequestBody NewDto newDto) {
        return ResponseEntity.ok(newService.save(newDto));
    }

    @GetMapping
    public ResponseEntity<List<NewDto>> getAll(){
        return ResponseEntity.ok(newService.getAll());
    }

    @PutMapping({ "/{id}"})
    public ResponseEntity<NewDto> update (@RequestBody NewDto newDto,@PathVariable Long id) {
        return ResponseEntity.ok(newService.update(newDto,id));
    }

}
