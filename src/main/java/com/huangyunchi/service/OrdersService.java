package com.huangyunchi.service;

import com.huangyunchi.dao.OrderDAO;
import com.huangyunchi.dao.impl.OrdersDAOImpl;
import com.huangyunchi.entity.Orders;
import com.huangyunchi.entity.common.Page;

/**
 * 订单处理相关的业务逻辑类
 *
 * @author qiujy
 */
public class OrdersService {

    private final OrderDAO orderDAO = new OrdersDAOImpl();

    public void updateStatus(Integer id, int status) throws RuntimeException {
        orderDAO.updateStatus(id, status);
    }

    /**
     * 添加订单，并级联添加订单项
     *
     * @param orders
     * @return
     * @throws RuntimeException
     */
    public Orders save(Orders orders) throws RuntimeException {
        orderDAO.save(orders);
        return orders;
    }

    /**
     * 获取进行中的订单分页列表
     *
     * @param number
     * @param size
     * @return
     * @throws RuntimeException
     */
    public Page<Orders> findAccumulating(int number, int size) throws RuntimeException {
        return findAccumulating(number, size);
    }

    /**
     * 获取指定状态的订单分页列表
     *
     * @param number
     * @param size
     * @return
     * @throws RuntimeException
     */
    public Page<Orders> findByStatus(int status, int number, int size) throws RuntimeException {
        return orderDAO.findByStatus(status, number, size);
    }

    /**
     * 获取指定会员的订单分页列表
     *
     * @param number
     * @param size
     * @return
     * @throws RuntimeException
     */
    public Page<Orders> findByBuyer(Integer buyer_id, int number, int size) throws RuntimeException {
        return orderDAO.findByMemberID(buyer_id, number, size);
    }

    /**
     * 获取指定编号的订单
     *
     * @return
     * @throws RuntimeException
     */
    public Orders findOne(Integer id) throws RuntimeException {
        return orderDAO.findByID(id);
    }
}
