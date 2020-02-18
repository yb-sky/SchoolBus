package com.talkweb.edu.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author SKyOne
 * @create 2020-02-12 12:23
 */
@Data
@TableName("car_statistical_list")
public class CarStatisticalList {
    @TableId(value = "id",type = IdType.AUTO)
    private long id;
    private String statisticName;
//    @Temporal(TemporalType.DATE)
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date rideTime;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applyTime;
    @JSONField(format = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;
    private String rideGrade;
    private String applicant;
    private String role;
    private int status;
    private Date createTime;
}
