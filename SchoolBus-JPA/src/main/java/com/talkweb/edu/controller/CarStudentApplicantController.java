package com.talkweb.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.talkweb.edu.entity.CarApplicant;
import com.talkweb.edu.entity.CarStatisticalList;
import com.talkweb.edu.service.ICarStuApplicantService;
import com.talkweb.edu.util.Result;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author SKyOne
 * @create 2020-02-12 9:38
 */
@Controller
@RequestMapping("/car/stu")
public class CarStudentApplicantController {

    @Resource
    private ICarStuApplicantService iCarStuApplicantService;

    @RequestMapping("/")
    public String index(){
//        return "redirect:/car/stu/page?page=1";
        return "nameManage/index";
    }

    @RequestMapping(value = "/page", method = {RequestMethod.POST,RequestMethod.GET})
    public String page(HttpServletResponse response, Model model, String gradeId,String classId,String name,int page){
        response.setHeader("Access-Control-Allow-Origin","*");
        Page<CarApplicant> list = iCarStuApplicantService.findAllByPage(page,10);
        System.out.println("list=>"+ JSONObject.toJSONString(list));

        model.addAttribute("list", list);
        return "nameManage/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<CarApplicant> detail(@PathVariable long id){
        Result<CarApplicant> result = new Result<>();

        CarApplicant csl = iCarStuApplicantService.findById(id);
        System.out.println("detail=>"+JSONObject.toJSONString(csl));
        result.setMsg("success");
        result.setCode(0);
        result.setData(csl);
        return result;
    }

    @RequestMapping("/add")
    public String add(CarApplicant carApplicant){
        iCarStuApplicantService.add(carApplicant);
        return "redirect:/car/stu/page?page=1";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> update(@RequestBody CarApplicant carApplicant){
        Result<String> result =  new Result<String>();
        iCarStuApplicantService.update(carApplicant);
        return result.success("ok");
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> delete(@PathVariable long id){
        Result<String> result =  new Result<String>();
        iCarStuApplicantService.delete(id);
        return result.success("ok");
    }
}
