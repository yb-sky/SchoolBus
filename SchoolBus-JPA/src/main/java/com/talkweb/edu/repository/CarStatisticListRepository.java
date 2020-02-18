package com.talkweb.edu.repository;

import com.talkweb.edu.entity.CarStatisticalList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @author SKyOne
 * @create 2020-02-12 12:32
 */
public interface CarStatisticListRepository extends JpaRepository<CarStatisticalList,Long> {
    @Transactional
    void deleteById(long id);

    @Transactional
    CarStatisticalList save(CarStatisticalList carStatisticalList);

    /*@Modifying
    @Transactional
    @Query("UPDATE CarStatisticalList obj SET obj.name = ?1 WHERE obj.id = ?2")
    void updateName(String name, Long id);*/
}
