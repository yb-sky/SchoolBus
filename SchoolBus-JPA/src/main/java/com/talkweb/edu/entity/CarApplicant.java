package com.talkweb.edu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.hibernate.annotations.GenerationTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SKyOne
 * @create 2020-02-12 9:08
 */

@Entity
@Data
//@EntityListeners(AuditingEntityListener.class)
public class CarApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private long cslId;
    @Column(nullable = false)
    private String gradeId;
    @Column(nullable = false)
    private String gradeName;
    @Column(nullable = false)
    private String classId;
    @Column(nullable = false)
    private String className;
//    @Column(columnDefinition = "varchar(50) not null")
    private String studentName;
//    @Column(columnDefinition = "varchar(500)")
    private String ridePlace;
    private int status;

    @CreatedDate
    private Date createTime;
}
