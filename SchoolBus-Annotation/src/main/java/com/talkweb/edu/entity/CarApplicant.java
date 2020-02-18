package com.talkweb.edu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author SKyOne
 * @create 2020-02-12 9:08
 */

@Data
//@TableName("car_applicant")
public class CarApplicant implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private long id;
    private long cslId;
    private String gradeId;
    private String gradeName;
    private String classId;
    private String className;
    private String studentName;
    private String ridePlace;
    private int status;
    private Date createTime;
}
