package com.talkweb.edu.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.talkweb.edu.entity.CarApplicant;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-12 9:25
 */
@Mapper
public interface CarApplicantMapper extends BaseMapper<CarApplicant> {
    @Results(id="BaseMap",value = {
            @Result(property = "id", column = "id"),
            @Result(property = "cslId", column = "csl_id"),
            @Result(property = "gradeId", column = "grade_id"),
            @Result(property = "gradeName", column = "grade_name"),
            @Result(property = "classId", column = "class_id"),
            @Result(property = "className", column = "class_name"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "ridePlace", column = "ride_place"),
            @Result(property = "status", column = "status"),
            @Result(property = "createTime", column = "create_time"),
    })

//    @ResultMap(value = "BaseMap")
    @Select("select * from car_applicant where 1=1 and ${ew.sqlSegment}")
    List<CarApplicant> findByParam(@Param("ew") QueryWrapper<CarApplicant> wrapper);

    @Select("select * from car_applicant where id = #{id}")
    CarApplicant findById(@Param("id") long id);

    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Select("insert into car_applicant(csl_id,grade_id,grade_name,class_id,class_name,student_name,ride_place)" +
            "values(#{cslId},#{gradeId},#{gradeName},#{classId},#{className},#{studentName},#{ridePlace})")
    /*void save(@Param("cslId")String cslId,@Param("gradeId") String gradeId,@Param("gradeName") String gradeName
            ,@Param("classId") String classId,@Param("studentName") String studentName
            ,@Param("ridePlace") String ridePlace);*/
    int save(CarApplicant carApplicant);

    void update(CarApplicant carApplicant);

    @Delete("delete from car_applicant where id=#{id}")
    void deleteById(long id);
}
