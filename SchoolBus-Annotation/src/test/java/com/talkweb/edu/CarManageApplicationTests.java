package com.talkweb.edu;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.talkweb.edu.entity.CarApplicant;
import com.talkweb.edu.mapper.CarApplicantMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class CarManageApplicationTests {
    @Autowired
    private CarApplicantMapper carApplicantMapper;

    @Test
    public  void testByWrapper(){
        QueryWrapper<CarApplicant> queryWrapper = new QueryWrapper<CarApplicant>();
        /*queryWrapper.lambda().eq(CarApplicant::getId,1)
                .eq(CarApplicant::getId,1);*/
//        List<CarApplicant> list = carApplicantMapper.findByParam(queryWrapper);
        CarApplicant obj = carApplicantMapper.findById(1);
        System.out.println("Result=>"+ JSONObject.toJSONString(obj));
    }
}
