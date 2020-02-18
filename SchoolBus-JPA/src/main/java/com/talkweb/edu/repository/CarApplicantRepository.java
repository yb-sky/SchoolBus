package com.talkweb.edu.repository;

import com.talkweb.edu.entity.CarApplicant;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * @author SKyOne
 * @create 2020-02-12 9:25
 */
public interface CarApplicantRepository extends JpaRepository<CarApplicant,Long> {
    @Transactional
    void deleteById(long id);

    @Transactional
    CarApplicant save(CarApplicant carApplicant);

}
