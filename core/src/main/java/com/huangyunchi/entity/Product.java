package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 *
 * @author qiujy
 */
@Data
public class Product implements Serializable {
    private static final long serialVersionUID = -379231982515404860L;
    /* 编号 */
    private Integer id;
    /* '商品名称' */
    private String name;
    /* '所属类目'cate_id */
    private Integer cate_id;
    /* '主配图片' */
    private String thumbnail;
    /* '库存数量' */
    private int inventory;
    /* '售出数量' */
    private int sales_volume;
    /* '定价' */
    private BigDecimal price;
    /* '售价' */
    private BigDecimal sale_price;
    /* '详情富文本描述' */
    private String detail_description;
    /* '卖点富文本描述' */
    private String selling_description;
    /* '添加时间' */
    private Date create_time;
    /* '开售时间' */
    private Date sale_time;

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", cate_id=" + cate_id
                + ", thumbnail=" + thumbnail + ", inventory=" + inventory
                + ", sales_volume=" + sales_volume + ", price=" + price
                + ", sale_price=" + sale_price + ", detail_description="
                + detail_description + ", selling_description="
                + selling_description + ", create_time=" + create_time
                + ", sale_time=" + sale_time + "]";
    }

}
