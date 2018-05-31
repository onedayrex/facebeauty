package com.git.onedayrex.facebeauty.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class FaceReq implements Serializable {
    private static final long serialVersionUID = -7487106218383224854L;


    @JSONField(name = "app_id")
    private Integer app_id;

    @JSONField(name = "time_stamp")
    private Integer time_stamp;

    /**
     *  随机字符串
     */
    @JSONField(name = "nonce_str")
    private String nonce_str;

    /**
     * 签名
     */
    private String sign;

    /**
     * base64图片
     */
    private String image;

    /**
     * 检测模式，0-正常，1-大脸模式（默认1）
     */
    private Integer mode;

    public Integer getApp_id() {
        return app_id;
    }

    public void setApp_id(Integer app_id) {
        this.app_id = app_id;
    }

    public Integer getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(Integer time_stamp) {
        this.time_stamp = time_stamp;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getMode() {
        return mode;
    }

    public void setMode(Integer mode) {
        this.mode = mode;
    }
}
