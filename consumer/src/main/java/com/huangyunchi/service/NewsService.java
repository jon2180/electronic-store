package com.huangyunchi.service;

import com.huangyunchi.dao.NewsDAO;
import com.huangyunchi.dao.impl.NewsDAOImpl;
import com.huangyunchi.entity.News;
import com.huangyunchi.entity.common.Page;

import java.util.List;


/**
 * 公告的业务逻辑类
 *
 * @author qiujy
 */
public class NewsService {

    private final NewsDAO newsDAO = new NewsDAOImpl();

    public News save(News news) throws RuntimeException {
        newsDAO.save(news);

        return news;
    }

    public void update(News news) throws RuntimeException {
        newsDAO.update(news);
    }

    public News findOne(Integer id) throws RuntimeException {
        return newsDAO.findByID(id);
    }

    public List<News> findAll() throws RuntimeException {
        return newsDAO.findAll();
    }

    public void delete(Integer id) throws RuntimeException {
        newsDAO.remove(id);
    }

    public long count() throws RuntimeException {
        return newsDAO.getCount();
    }

    public Page<News> findAll(int number, int size) throws RuntimeException {
        return newsDAO.findByPaging(number, size);
    }

    /**
     * 获取已经发布的轮播新闻列表
     *
     * @param number
     * @param size
     * @return
     * @throws RuntimeException
     */
    public Page<News> findTopByPublic(int number, int size) throws RuntimeException {
        return newsDAO.findTopByPublic(number, size);
    }

    /**
     * 获取已经发布的新闻列表
     *
     * @param number
     * @param size
     * @return
     * @throws RuntimeException
     */
    public Page<News> findByPublic(int number, int size) throws RuntimeException {
        return newsDAO.findByPublic(number, size);
    }
}