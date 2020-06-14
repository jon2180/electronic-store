package com.huangyunchi.dao;

import com.huangyunchi.entity.Address;

import java.util.List;

public interface AddressDAO {

    /**
     * 保存地址信息至数据库
     * @param address
     * @return
     */
    boolean save(Address address);

    /**
     * 更新地址信息
     *
     * @param address
     * @throws RuntimeException
     */
    boolean update(Address address);

    boolean changeDefault(Integer memberID, Integer addressID);

    /**
     * 根据编号删除地址
     *
     * @param ID 地址的编号
     * @throws RuntimeException
     */
    boolean remove(Integer ID);

    /**
     * 获取指定会员的所有地址列表
     *
     * @param memberID 会员的编号
     * @return 该会员的所有地址列表
     * @throws RuntimeException
     */
    List<Address> findByMemberID(Integer memberID);

    /**
     * 获取指定编号的地址
     *
     * @param ID 地址的编号
     * @return 地址
     * @throws RuntimeException
     */
    Address findByID(Integer ID);
}
