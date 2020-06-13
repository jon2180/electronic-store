package com.huangyunchi.service;

import com.huangyunchi.dao.AddressDAO;
import com.huangyunchi.dao.impl.AddressDAOImpl;
import com.huangyunchi.entity.Address;

import java.util.List;

/**
 * 地址的业务逻辑类
 *
 * @author qiujy
 */
public class AddressService {

    private final AddressDAO addressDAO = new AddressDAOImpl();

    public Address save(Address address) throws RuntimeException {
        addressDAO.save(address);
        return address;
    }

    /**
     * 更新地址信息
     *
     * @param address
     * @throws RuntimeException
     */
    public void update(Address address) throws RuntimeException {
        addressDAO.update(address);
    }

    public void updateDefault(Integer mbr_id, Integer address_id) throws RuntimeException {
        addressDAO.changeDefault(mbr_id, address_id);
    }

    /**
     * 根据编号删除地址
     *
     * @param id 地址的编号
     * @throws RuntimeException
     */
    public void delete(Integer id) throws RuntimeException {
        addressDAO.remove(id);
    }

    /**
     * 获取指定会员的所有地址列表
     *
     * @param mbr_id 会员的编号
     * @return 该会员的所有地址列表
     * @throws RuntimeException
     */
    public List<Address> findByMember(Integer mbr_id) throws RuntimeException {
        return addressDAO.findByMemberID(mbr_id);
    }

    /**
     * 获取指定编号的地址
     *
     * @param id 地址的编号
     * @return 地址
     * @throws RuntimeException
     */
    public Address findOne(Integer id) throws RuntimeException {
        return addressDAO.findByID(id);
    }
}