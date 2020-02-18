package com.talkweb.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.talkweb.edu.entity.CarApplicant;
import com.talkweb.edu.service.ICarStuApplicantService;
import com.talkweb.edu.util.Constant;
import com.talkweb.edu.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author SKyOne
 * @create 2020-02-12 9:38
 */
@Controller
@RequestMapping("/car/stu")
public class CarStudentApplicantController {

    private static Map<String,String> classMap = new HashMap<>();

    @Resource
    private ICarStuApplicantService iCarStuApplicantService;

    @RequestMapping("/")
    public String index(){
//        return "redirect:/car/stu/page?page=1";
        return "nameManage/index";
    }

    @RequestMapping(value = "/page", method = {RequestMethod.POST,RequestMethod.GET})
    public String page(HttpServletResponse response, Model model, String gradeId,String classId,String studentName,int page){
        response.setHeader("Access-Control-Allow-Origin","*");

        classMap.put("1","101班");
        classMap.put("2","102班");

        page = page <= 0 ? 1 : page ;
        CarApplicant carApplicant = new CarApplicant();
        if(!StringUtils.isEmpty(gradeId)){
            carApplicant.setGradeId(gradeId);
        }
        if(!StringUtils.isEmpty(classId)){
            carApplicant.setClassId(classId);
        }
        if(!StringUtils.isEmpty(studentName)){
            carApplicant.setStudentName(studentName);
        }
       /* PageInfo<CarApplicant> list = iCarStuApplicantService.findByParam(carApplicant, page, 10);
        model.addAttribute("list",list);*/
        model.addAttribute("carApplicant",carApplicant);
        model.addAttribute("gradeMap", Constant.gradeMap);
        model.addAttribute("classMap", classMap);
        return "nameManage/index";
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<JSONObject> detail(@PathVariable long id){
        Result<JSONObject> result = new Result<>();

        CarApplicant carApplicant = iCarStuApplicantService.findById(id);
        result.setMsg("success");
        result.setCode(0);

        JSONObject data = new JSONObject();
        data.put("carApplicant",carApplicant);
        data.put("classMap",classMap);
        data.put("gradeMap",Constant.gradeMap);

        result.setData(data);
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
