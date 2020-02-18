package com.talkweb.edu.service;

import com.talkweb.edu.entity.CarStatisticalList;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-12 12:33
 */
public interface ICarStatisticListService {

    CarStatisticalList findById(long id);

    List<CarStatisticalList> findAll();

    Page<CarStatisticalList> findAllByPage(int page, int pageSize);

    CarStatisticalList update(CarStatisticalList carStatisticalList);

    void delete(long id);

    CarStatisticalList add(CarStatisticalList carStatisticalList);
}
