package com.yaser.dto;

import com.yaser.entity.New;
import lombok.Data;

import java.util.Date;

/**
 * @author Yaser
 */
@Data
public class NoticeDto {

    private Long id;
    private String topic;
    private String content;
    private Date date;
    private boolean status;
    private Long newsId;

}
