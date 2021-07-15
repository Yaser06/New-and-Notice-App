package com.yaser.dto;

import lombok.Data;
import java.util.Date;
import java.util.List;

/**
 * @author Yaser
 */
@Data
public class NewDto {

    private Long id;
    private String topic;
    private String content;
    private Boolean status;
    private Date date;
    private String haberLink;

}
