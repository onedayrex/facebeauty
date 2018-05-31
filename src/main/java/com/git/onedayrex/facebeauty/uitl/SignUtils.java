package com.git.onedayrex.facebeauty.uitl;

import cn.hutool.crypto.digest.DigestUtil;

import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.*;

public class SignUtils {

    public static final String sign(Object o) {
        Field[] declaredFields = o.getClass().getDeclaredFields();
        Map<String,String> fieldName = new HashMap<>();
        try {
            for (Field declaredField : declaredFields) {
                if ("serialVersionUID".equals(declaredField.getName())) {
                    continue;
                }
                declaredField.setAccessible(true);
                Object o1 = declaredField.get(o);
                if (null != o1) {
                    fieldName.put(declaredField.getName(), String.valueOf(o1));
                }
            }
            List<String> filedNames = new ArrayList<>();
            for (Map.Entry<String, String> stringStringEntry : fieldName.entrySet()) {
                filedNames.add(stringStringEntry.getKey());
            }
            String[] nameArray = filedNames.toArray(new String[0]);
            Arrays.sort(nameArray);
            List<String> names = Arrays.asList(nameArray);
            StringBuilder sb = new StringBuilder();
            for (String name : names) {
                sb.append(name);
                sb.append("=");
                sb.append(URLEncoder.encode(fieldName.get(name), "UTF-8"));
                sb.append("&");
            }
            sb.append("app_key=");
            sb.append(ConfigUtils.getProperties("appKey"));
            String newstr = DigestUtil.md5Hex(sb.toString());
            return newstr.toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
