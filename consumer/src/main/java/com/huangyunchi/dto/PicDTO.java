package com.huangyunchi.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class PicDTO {
    private String url;

    @JsonIgnore
    private int code;

    private String basePath;
    private String filename;

    public String getBasePath() {
        return basePath;
    }

    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }


}
