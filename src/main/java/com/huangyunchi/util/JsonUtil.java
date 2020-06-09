package com.huangyunchi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.huangyunchi.dto.ResponseData;

public class JsonUtil {

    public static <T> String getJson(int code, String desc, T object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ResponseData<T> data = new ResponseData<>(code, desc, object);
        return mapper.writeValueAsString(data);
    }

}
