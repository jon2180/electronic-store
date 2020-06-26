package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员实体类---->对象数据
 *
 * @author Administrator
 */
@Data
public class Member implements Serializable {
    private static final long serialVersionUID = -8313180789415412016L;

    private Integer id;
    private String mobile;
    private String pwd;
    private String real_name;
    private String nick_name;
    private String email;
    private boolean gender;
    private Date register_time;
    
    @Override
    public String toString() {
        return "Member [id=" + id + ", mobile=" + mobile + ", pwd=" + pwd + ", real_name=" + real_name + ", nick_name="
                + nick_name + ", email=" + email + ", gender=" + gender + ", register_time=" + register_time + "]";
    }
}
