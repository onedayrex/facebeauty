package com.git.onedayrex.facebeauty.uitl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class BeanToMapUtils {

    public static final Map<String,Object> beanToMap(Object bean){
        Map<String, Object> map = new HashMap<>();
        if (bean == null) {
            return map;
        }
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field declaredField : declaredFields) {
            if ("serialVersionUID".equals(declaredField.getName())) {
                continue;
            }
            declaredField.setAccessible(true);
            try {
                Object o = declaredField.get(bean);
                map.put(declaredField.getName(), o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
