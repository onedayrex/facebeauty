package com.git.onedayrex.facebeauty.uitl;

import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Base64Utils {

    public static final String image2Str() {
        try {
            BASE64Encoder base64Encoder = new BASE64Encoder();
            File file = new File("C:/Users/537002/Pictures/3.jpg");
            InputStream in = new FileInputStream(file);
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            in.close();
            return base64Encoder.encode(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
