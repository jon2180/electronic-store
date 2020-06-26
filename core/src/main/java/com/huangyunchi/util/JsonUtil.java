package com.huangyunchi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyunchi.dto.ResponseData;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class JsonUtil {

    public static <T> String getJson(int code, String desc, T object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseData<T> data = new ResponseData<>(code, desc, object);
        return mapper.writeValueAsString(data);
    }

    public static <T> ResponseData<T> readJson(String jsonStr) {
        return null;
    }


    /**
     * 读取 Http 中 body 的内容： 字符串读取
     *
     * @param request 请求对象
     * @return 二进制数组
     * @throws IOException 流读取失败时抛出
     */
    public static String readBodyAsString(HttpServletRequest request) throws IOException {
        BufferedReader br = request.getReader();
        String str;
        StringBuilder wholeStr = new StringBuilder();
        while ((str = br.readLine()) != null) {
            wholeStr.append(str);
        }
        return wholeStr.toString();
    }

    /**
     * 读取 Http 中 body 的内容： 二进制读取
     *
     * @param request 请求对象
     * @return 二进制数组
     * @throws IOException 流读取失败时抛出
     */
    public static byte[] readBodyAsBinary(HttpServletRequest request) throws IOException {
        int len = request.getContentLength();
        ServletInputStream iii = request.getInputStream();
        byte[] buffer = new byte[len];
        if (iii.read(buffer, 0, len) > 0)
            return buffer;
        else
            return null;
    }

}
