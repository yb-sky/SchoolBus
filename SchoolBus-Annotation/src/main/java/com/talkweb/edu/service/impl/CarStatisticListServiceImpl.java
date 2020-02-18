package com.talkweb.edu.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.talkweb.edu.entity.CarStatisticalList;
import com.talkweb.edu.mapper.CarStatisticListMapper;
import com.talkweb.edu.service.ICarStatisticListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-12 12:34
 */
@Service
public class CarStatisticListServiceImpl implements ICarStatisticListService {

    @Autowired
    private CarStatisticListMapper carStatisticListMapper;

    @Override
    public CarStatisticalList findById(long id) {
        return carStatisticListMapper.findById(id);
    }

    @Override
    public List<CarStatisticalList> findAll() {
        return carStatisticListMapper.findAll();
    }

    @Override
    public void update(CarStatisticalList carStatisticalList) {
        carStatisticListMapper.update(carStatisticalList);
    }

    @Override
    public void delete(long id) {
        carStatisticListMapper.deleteById(id);
    }

    @Override
    public void add(CarStatisticalList carStatisticalList) {
        carStatisticListMapper.save(carStatisticalList);
    }

    @Override
    public Page<CarStatisticalList> selectPage(Page<CarStatisticalList> page) {
        return page.setRecords(carStatisticListMapper.selectPage(page));
    }

}
