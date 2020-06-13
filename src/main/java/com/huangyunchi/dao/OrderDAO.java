package com.huangyunchi.dao;

import com.huangyunchi.entity.Orders;
import com.huangyunchi.entity.common.Page;

public interface OrderDAO {

    boolean save(Orders order);

    //    boolean remove(Integer ID);
//
//    boolean update(Integer ID);

    void updateStatus(Integer id, int status);

    Orders findByID(Integer ID);

    Page<Orders> findByStatus(int status, int number, int size);

    Page<Orders> findByMemberID(Integer ID, int number, int size);
}
