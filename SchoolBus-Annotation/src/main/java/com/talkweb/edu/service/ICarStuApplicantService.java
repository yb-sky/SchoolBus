package com.talkweb.edu.service;

import com.talkweb.edu.entity.CarApplicant;


/**
 * @author SKyOne
 * @create 2020-02-12 9:30
 */
public interface ICarStuApplicantService {
    CarApplicant findById(long id);

    void add(CarApplicant carApplicant);

    void update(CarApplicant carApplicant);

    void delete(long id);

}
