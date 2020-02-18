package com.talkweb.edu.service.impl;

import com.talkweb.edu.entity.CarApplicant;
import com.talkweb.edu.mapper.CarApplicantMapper;
import com.talkweb.edu.service.ICarStuApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author SKyOne
 * @create 2020-02-12 9:32
 */
@Service
public class CarStuApplicantServiceImpl implements ICarStuApplicantService {

    @Autowired
    private CarApplicantMapper carApplicantMapper;

    @Override
    public CarApplicant findById(long id) {
        return carApplicantMapper.findById(id);
    }

    @Override
    public void add(CarApplicant carApplicant) {
        carApplicantMapper.save(carApplicant);
    }

    @Override
    public void update(CarApplicant carApplicant) {
        carApplicantMapper.update(carApplicant);
    }

    @Override
    public void delete(long id) {
        carApplicantMapper.deleteById(id);
    }

}
