
package com.huangyunchi.dto;

import lombok.Data;

@Data
public class ResponseData<E> {
    private int code;
    private String desc;
    private E data;

    public ResponseData(int code, String desc, E data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }
}
