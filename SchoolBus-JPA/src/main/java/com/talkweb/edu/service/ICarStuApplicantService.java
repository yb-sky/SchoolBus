package com.talkweb.edu.service;

import com.talkweb.edu.entity.CarApplicant;
import org.springframework.data.domain.Page;

import java.util.List;


/**
 * @author SKyOne
 * @create 2020-02-12 9:30
 */
public interface ICarStuApplicantService {
    Page<CarApplicant> findAllByPage(int page, int pageSize);

    CarApplicant findById(long id);

    CarApplicant add(CarApplicant carApplicant);

    CarApplicant update(CarApplicant carApplicant);

    void delete(long id);
}
