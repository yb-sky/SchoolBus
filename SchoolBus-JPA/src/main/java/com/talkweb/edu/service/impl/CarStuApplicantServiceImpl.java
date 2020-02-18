package com.talkweb.edu.service.impl;

import com.talkweb.edu.entity.CarApplicant;
import com.talkweb.edu.repository.CarApplicantRepository;
import com.talkweb.edu.service.ICarStuApplicantService;
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
 * @create 2020-02-12 9:32
 */
@Service
public class CarStuApplicantServiceImpl implements ICarStuApplicantService {

    @Autowired
    private CarApplicantRepository carApplicantRepository;

    @Override
    public Page<CarApplicant> findAllByPage(int page, int pageSize) {
        List<Sort.Order> orders = new ArrayList<>();
        orders.add(new Sort.Order(Sort.Direction.DESC, "createTime"));//设置时间倒序
        Sort sort = Sort.by(orders);

        Pageable pageable = PageRequest.of(page,pageSize,sort);
        return carApplicantRepository.findAll(pageable);
    }

    @Override
    public CarApplicant findById(long id) {
        return carApplicantRepository.findById(id).get();
    }

    @Override
    public CarApplicant add(CarApplicant carApplicant) {
        return carApplicantRepository.save(carApplicant);
    }

    @Override
    public CarApplicant update(CarApplicant carApplicant) {
        return carApplicantRepository.save(carApplicant);
    }

    @Override
    public void delete(long id) {
        carApplicantRepository.deleteById(id);
    }

}
