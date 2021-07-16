package com.yaser.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Yaser
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Event implements Serializable {
    @Id
    @SequenceGenerator(name ="seq_event",allocationSize = 1)
    @GeneratedValue(generator = "seq_event",strategy = GenerationType.AUTO)
    private Long id;

    @Column(length =10000 ,name ="new_topic")
    private String topic;

    @Column(length = 1000,name ="new_content")
    private String content;

    @Column
    private Date date;

    @Column
    private boolean status;


}
