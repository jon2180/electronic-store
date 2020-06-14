package com.huangyunchi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.huangyunchi.dto.PicDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonUtilTest {

    @Test
    public void testJson() {
        try {
            assertEquals("{\"code\":200,\"desc\":\"测试\",\"data\":{\"url\":null,\"basePath\":null,\"filename\":null}}", JsonUtil.getJson(200, "测试", new PicDTO()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

// expected: java.lang.String@6d73326<
// {"code":200,"desc":"测试","data":{"url":null,"basePath":null,"filename":null}}
// > but was: java.lang.String@b177f72<
// {"code":200,"desc":"测试","data":{"url":null,"basePath":null,"filename":null}}
// >