package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 类目
 *
 * @author qiujy
 */
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = -3350763396111688050L;
    /**
     * 编号
     */
    private Integer id;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 类目别名
     */
    private String alias;
    /**
     * 父类目p_id
     */
    private Integer p_id;
    /**
     * 排序权重
     */
    private int orderWeight = 10;

    /**
     * 子类目列表
     */
    private List<Category> children = new ArrayList<Category>();

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Category [id=" + id + ", name=" + name + ", alias=" + alias
                + ", p_id=" + p_id + ", order_weight=" + orderWeight
                + ", childs=" + children + "]";
    }
}