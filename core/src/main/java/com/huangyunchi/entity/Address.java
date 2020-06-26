package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 会员的地址
 *
 * @author qiujy
 */
@Data
public class Address implements Serializable {
    private static final long serialVersionUID = 529932754573978762L;
    /* 编号 */
    private Integer id;
    /* '收货人' */
    private String contact;
    /* '联系电话' */
    private String mobile;
    /* '详细地址' */
    private String street;
    /* '邮编' */
    private String zipcode;
    /* '所属会员' */
    private Integer mbr_id;
    /* '是否为所属会员的默认收货地址' */
    private boolean default_value;

    /**
     * @return the default_value
     */
    public boolean getDefault_value() {
        return default_value;
    }

    /**
     * @param default_value the default_value to set
     */
    public void setDefault_value(boolean default_value) {
        this.default_value = default_value;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Address [id=" + id + ", contact=" + contact + ", mobile="
                + mobile + ", street=" + street + ", zipcode=" + zipcode
                + ", mbr_id=" + mbr_id + ", default_value=" + default_value
                + "]";
    }
}
