package com.talkweb.edu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.talkweb.edu.entity.CarStatisticalList;

import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-12 12:33
 */
public interface ICarStatisticListService {

    CarStatisticalList findById(long id);

    List<CarStatisticalList> findAll();

    void update(CarStatisticalList carStatisticalList);

    void delete(long id);

    void add(CarStatisticalList carStatisticalList);

    Page<CarStatisticalList> selectPage(Page<CarStatisticalList> page);
}
