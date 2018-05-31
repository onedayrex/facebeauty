package com.git.onedayrex.facebeauty;

import cn.hutool.http.HttpUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.git.onedayrex.facebeauty.dto.FaceReq;
import com.git.onedayrex.facebeauty.uitl.Base64Utils;
import com.git.onedayrex.facebeauty.uitl.BeanToMapUtils;
import com.git.onedayrex.facebeauty.uitl.ConfigUtils;
import com.git.onedayrex.facebeauty.uitl.SignUtils;

import java.util.Map;
import java.util.UUID;

public class Main {


    public static void main(String[] args) {
        Log log = LogFactory.get();
        FaceReq faceReq = new FaceReq();
        faceReq.setApp_id(Integer.valueOf(ConfigUtils.getProperties("appId")));
        Integer time = Integer.valueOf(String.valueOf(System.currentTimeMillis()/1000));
        faceReq.setTime_stamp(time);
        faceReq.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
        faceReq.setImage(Base64Utils.image2Str());
        faceReq.setMode(0);
        String sign = SignUtils.sign(faceReq);
        faceReq.setSign(sign);
        Map<String, Object> param = BeanToMapUtils.beanToMap(faceReq);
        String result = HttpUtil.post(ConfigUtils.getProperties("appUrl"), param);
        JSONObject jsonObject = JSON.parseObject(result);
        log.info("param==>{}", jsonObject);
        JSONObject data = jsonObject.getJSONObject("data");
        JSONArray face_list = data.getJSONArray("face_list");
        for (Object o : face_list) {
            JSONObject temp = (JSONObject)o;
            int beauty = temp.getIntValue("beauty");
            log.info("beauty====>{}", beauty);
        }
    }
}
