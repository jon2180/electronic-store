package com.huangyunchi.service;

import com.huangyunchi.dao.ProductDAO;
import com.huangyunchi.dao.impl.ProductDAOImpl;
import com.huangyunchi.entity.Product;
import com.huangyunchi.entity.common.Page;

import java.util.List;


/**
 * 商品的业务逻辑类
 *
 * @author qiujy
 */
public class ProductService {

    private final ProductDAO productDAO = new ProductDAOImpl();

    public Product save(Product product) throws RuntimeException {
        productDAO.save(product);
        return product;
    }

    public void update(Product product) throws RuntimeException {
        productDAO.update(product);
    }

    public Product findOne(Integer id) throws RuntimeException {
        return productDAO.findByID(id);
    }

    public List<Product> find(Integer... ids) throws RuntimeException {
        return productDAO.findByIDs(ids);
    }

    public Page<Product> findAll(int number, int size) throws RuntimeException {
        return productDAO.findByPaging(number, size);
    }


    public Page<Product> findAll(int cate_id, String title, int number, int size) throws RuntimeException {
        return productDAO.findAll(cate_id, title, number, size);
    }

    public void delete(Integer id) throws RuntimeException {
        productDAO.remove(id);
    }

    public long count() throws RuntimeException {
        return productDAO.getCount();
    }

    /**
     * 获取指定的二级类目下的产品分页列表
     *
     * @param cate_id 类目的编号
     * @param number  当前页号
     * @param size    每页要显示的记录数
     * @return 分页对象
     * @throws RuntimeException
     */
    public Page<Product> findBySubCategory(Integer cate_id, int number, int size) throws RuntimeException {
        return productDAO.findBySubCategory(cate_id, number, size);
    }

    /**
     * 获取热门产品分页列表
     *
     * @param number 当前页号
     * @param size   每页要显示的记录数
     * @return 分页对象
     * @throws RuntimeException
     */
    public Page<Product> findHot(int number, int size) throws RuntimeException {
        return productDAO.findHot(number, size);
    }

    /**
     * 获取指定一级类目下的热门产品分页列表
     *
     * @param cate_id 一级类目
     * @param number
     * @param size
     * @return
     * @throws RuntimeException
     */
    public Page<Product> findHotTopCategory(Integer cate_id, int number, int size) throws RuntimeException {
        return productDAO.findHotTopCategory(cate_id, number, size);
    }

    /**
     * 获取指定二级类目下的热门产品分页列表
     *
     * @param cate_id 二级类目的编号
     * @param number  当前页号
     * @param size    每页要显示的记录数
     * @return 分页对象
     * @throws RuntimeException
     */
    public Page<Product> findHotSubCategory(Integer cate_id, int number, int size) throws RuntimeException {
        return productDAO.findHotSubCategory(cate_id, number, size);
    }

    /**
     * 根据产品标题模糊查询，返回分页列表
     *
     * @param name   标题
     * @param number 当前页号
     * @param size   每页要显示的记录数
     * @return 分页对象
     * @throws RuntimeException
     */
    public Page<Product> findByLikeName(String name, int number, int size) throws RuntimeException {
        return productDAO.findByLikeName(name, number, size);
    }

    /**
     * 获取指定一级类目下的所有产品分页列表
     *
     * @param cate_id
     * @param number
     * @param size
     * @return
     * @throws RuntimeException
     */
    public Page<Product> findByTopCategory(Integer cate_id, int number, int size) throws RuntimeException {
        return productDAO.findByTopCategory(cate_id, number, size);
    }
}