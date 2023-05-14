package com.sliu.JPADemo.utils;

import com.sliu.JPADemo.entity.StudentEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static <T extends StudentEntity> T getV(T t) {
        return t;
    }

    public static void main(String[] args) {
        String[] split = "123.134.34".split("\\.");
        System.out.println(split);
        Map<String, List> map = new HashMap<>();
        List hr = map.getOrDefault("hr", new ArrayList());
        hr.add(new Object());

    }
}
