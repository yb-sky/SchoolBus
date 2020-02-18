package com.talkweb.edu.controller;

import com.alibaba.fastjson.JSONObject;
import com.talkweb.edu.entity.CarStatisticalList;
import com.talkweb.edu.service.ICarStatisticListService;
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
 * @create 2020-02-12 12:30
 */
@Controller
@RequestMapping("/car/stastic")
public class CarStatisticListController {
    @Resource
    private ICarStatisticListService iCarStatisticListService;

    @RequestMapping("/list")
    public String list(Model model){
        List<CarStatisticalList> list = iCarStatisticListService.findAll();
        model.addAttribute("list", list);
        return "list";
    }

    @RequestMapping("/add")
    public String add(CarStatisticalList carStatisticalList){
        carStatisticalList.setApplicant("test1");
        carStatisticalList.setRole("1");
//        carStatisticalList.setCreateTime(new Date());
        iCarStatisticListService.add(carStatisticalList);
        return "redirect:/car/stastic/page?page=1";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result<String> update(@RequestBody CarStatisticalList carStatisticalList){
        Result<String> result =  new Result<String>();
        carStatisticalList.setApplicant("test1");
        carStatisticalList.setRole("1");
        iCarStatisticListService.update(carStatisticalList);
        return result.success("ok");
    }

    @RequestMapping(value = "/delete" ,method = RequestMethod.GET)
    public String delete(long id){
        Result<JSONObject> result = new Result<>();
        if(id>0){
            CarStatisticalList obj = iCarStatisticListService.findById(id);
            if(null != obj && obj.getId()>0){
                iCarStatisticListService.delete(id);
                result.success("Delete OK!");
            }else{
                result.setCode(0);
                result.setMsg("Can't find record.");
            }
        }else{
            result.setCode(0);
            result.setMsg("Id must big than 0.");
        }
        return "redirect:/car/stastic/page?page=1";
    }

    @RequestMapping("/page")
    public String page(HttpServletResponse response, Model model, int page){
        response.setHeader("Access-Control-Allow-Origin","*");
        page = (page <= 0 ? 1 : page);
        Page<CarStatisticalList> list = iCarStatisticListService.findAllByPage(page,10);
        System.out.println("list=>"+JSONObject.toJSONString(list));
        
        model.addAttribute("list", list);
        return "carManage/list";
    }

    @RequestMapping("/detail_")
    public String detailPage( Model model, long id, int type){
        // 1. detail, 2. edit
        String page = type == 1 ? "carManage/detail" : "carManage/edit";
        CarStatisticalList csl = iCarStatisticListService.findById(id);
        System.out.println("detail=>"+JSONObject.toJSONString(csl));
        model.addAttribute("car", csl);
        return page;
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.POST)
    @ResponseBody
    public Result<CarStatisticalList> detail(@PathVariable long id){
        Result<CarStatisticalList> result = new Result<>();

        CarStatisticalList csl = iCarStatisticListService.findById(id);
        System.out.println("detail=>"+JSONObject.toJSONString(csl));
        result.setMsg("success");
        result.setCode(0);
        result.setData(csl);
        return result;
    }

    @RequestMapping("/test/{id}")
    @ResponseBody
    public JSONObject test(@PathVariable int id){

        Page<CarStatisticalList> list = iCarStatisticListService.findAllByPage(1,10);
        JSONObject result = new JSONObject();
        result.put("code",0);
        result.put("msg","OK");
        result.put("data", list);
        return result;
    }
}
