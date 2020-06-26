package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 公告
 *
 * @author qiujy
 */
@Data
public class News implements Serializable {

    private static final long serialVersionUID = 8419106325554272464L;

    private Integer id;
    /*标题*/
    private String title;
    /*主配图*/
    private String thumbnail;
    /*是否为轮播图*/
    private boolean top;
    /*主内容*/
    private String content;

    private int hits;
    /*发布时间*/
    private Date pub_time;

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "News [id=" + id + ", title=" + title + ", thumbnail="
                + thumbnail + ", top=" + top + ", content=" + content
                + ",hits=" + hits + ", pub_time=" + pub_time + "]";
    }
}
