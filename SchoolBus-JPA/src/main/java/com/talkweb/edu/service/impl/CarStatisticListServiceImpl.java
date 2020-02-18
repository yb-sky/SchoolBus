package com.talkweb.edu.service.impl;

import com.talkweb.edu.entity.CarStatisticalList;
import com.talkweb.edu.repository.CarStatisticListRepository;
import com.talkweb.edu.service.ICarStatisticListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-12 12:34
 */
@Service
public class CarStatisticListServiceImpl implements ICarStatisticListService {

    @Autowired
    private CarStatisticListRepository carStatisticListRepository;

    @Override
    public CarStatisticalList findById(long id) {
        return carStatisticListRepository.findById(id).get();
    }

    @Override
    public List<CarStatisticalList> findAll() {
        return carStatisticListRepository.findAll();
    }

    @Override
    public Page<CarStatisticalList> findAllByPage(int page, int pageSize) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "createTime"));//设置时间倒序
        Sort sort = Sort.by(orders);

        Pageable pageable = PageRequest.of(page,pageSize,sort);
        return carStatisticListRepository.findAll(pageable);
    }

    @Override
    public CarStatisticalList update(CarStatisticalList carStatisticalList) {
        return carStatisticListRepository.save(carStatisticalList);
    }

    @Override
    public void delete(long id) {
        carStatisticListRepository.deleteById(id);
    }

    @Override
    public CarStatisticalList add(CarStatisticalList carStatisticalList) {
        return carStatisticListRepository.save(carStatisticalList);
    }
}
