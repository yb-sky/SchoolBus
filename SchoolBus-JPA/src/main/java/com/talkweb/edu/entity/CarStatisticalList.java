package com.talkweb.edu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @author SKyOne
 * @create 2020-02-12 12:23
 */
@Entity
@Data
//@EntityListeners(AuditingEntityListener.class)
public class CarStatisticalList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String statisticName;

    @Column(nullable = false)
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date rideTime;

    @Column(nullable = false)
    @JSONField(format = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;

    @Column(nullable = false)
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date endTime;

    private String rideGrade;
    @Column(nullable = false)
    private String applicant;
    private String role;
    private int status;

    @CreatedDate
    private Date createTime;
}
