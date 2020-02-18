package com.talkweb.edu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.talkweb.edu.entity.CarStatisticalList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-12 12:32
 */
@Mapper
public interface CarStatisticListMapper extends BaseMapper<CarStatisticalList> {
    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Select("insert into car_statistical_list(statistic_name,ride_time,apply_time,end_time,ride_grade,applicant,role) " +
            "values(#{statisticName},#{rideTime},#{applyTime},#{endTime},#{rideGrade},#{applicant},#{role})")
    void save(CarStatisticalList carStatisticalList);

    void update(CarStatisticalList carStatisticalList);

    void deleteById(long id);

    CarStatisticalList findById(long id);

    @Select("select * from car_statistical_list")
    List<CarStatisticalList> findAll();

    @Select("select * from car_statistical_list order by create_time desc")
    List<CarStatisticalList> selectPage(Page<CarStatisticalList> page);
}
