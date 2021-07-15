package com.yaser.repo;

import com.yaser.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Yaser
 */
public interface NoticeRepository extends JpaRepository <Notice ,Long> {
}
