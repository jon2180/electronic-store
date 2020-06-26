package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 订单实体类
 *
 * @author qiujy
 */
@Data
public class Orders implements Serializable {
    private static final long serialVersionUID = -181747313514354329L;
    private Integer id;
    private String number;/* '订单号', */
    private Integer buyer_id;/* '所属买家会员编号', */
    private Integer total_amount;/* '商品总数量', */
    private BigDecimal total_price;/* '总的费用', */
    private BigDecimal payment_price;/* '实付的费用', */
    private String remark;/* '买家留言', */
    private String contact;/* '收货人', */
    private String mobile;/* '联系电话', */
    private String street;/* '详细地址', */
    private String zipcode;/* '邮编', */
    private Date create_time;/* '下单时间', */
    private Date payment_time;/* '支付时间', */
    private Date delivery_time;/* '发货时间', */
    private Date end_time;/* '完成时间', */

    /* comment '订单状态：0下单,1待付款,2已付款,3待发货,4已发货,5己收货,6已完成,-1已取消' */
    private int status;

    private List<Item> items = new ArrayList<>();

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Orders [id=" + id + ", number=" + number + ", buyer_id="
                + buyer_id + ", total_amount=" + total_amount + ", total_price="
                + total_price + ", payment_price=" + payment_price + ", remark="
                + remark + ", contact=" + contact + ", mobile=" + mobile
                + ", street=" + street + ", zipcode=" + zipcode
                + ", create_time=" + create_time + ", payment_time="
                + payment_time + ", delivery_time=" + delivery_time
                + ", end_time=" + end_time + ", status=" + status + ", items="
                + items + "]";
    }
}
