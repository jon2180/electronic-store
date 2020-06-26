package com.huangyunchi.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 订单项
 *
 * @author qiujy
 */
@Data
public class Item implements Serializable {
    private static final long serialVersionUID = -5513015465167003750L;
    private Integer id;
    private Integer order_id;/* '所属订单编号', */
    private Integer product_id;/* '所购商品编号', */
    private int amount;/* '单品数量', */
    private BigDecimal total_price;/* '单品总价', */
    private BigDecimal payment_price;/* '单品实付的总价' */

    private Product product;/* '所购商品' */

    /**
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Item [id=" + id + ", order_id=" + order_id + ", product_id="
                + product_id + ", amount=" + amount + ", total_price="
                + total_price + ", payment_price=" + payment_price
                + ", product=" + product + "]";
    }
}
