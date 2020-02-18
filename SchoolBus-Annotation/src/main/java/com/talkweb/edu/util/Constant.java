package com.talkweb.edu.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SKyOne
 * @create 2020-02-15 15:54
 */
public class Constant {

    public static Map<String,String> gradeMap = new HashMap<>();

    static {
        gradeMap.put("1", "一年级");
        gradeMap.put("2", "二年级");
        gradeMap.put("3", "三年级");
        gradeMap.put("4", "四年级");
        gradeMap.put("5", "五年级");
        gradeMap.put("6", "六年级");
        gradeMap.put("7", "初一");
        gradeMap.put("8", "初二");
        gradeMap.put("9", "初三");
        gradeMap.put("10", "高一");
        gradeMap.put("11", "高二");
        gradeMap.put("12", "高三");

    }
}
