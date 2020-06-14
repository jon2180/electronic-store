package com.huangyunchi.dao;

import com.huangyunchi.entity.News;
import com.huangyunchi.entity.common.Page;

import java.util.List;

public interface NewsDAO {

    boolean save(News news);

    boolean update(News news);

    boolean remove(Integer ID);

    News findByID(Integer ID);

    List<News> findAll();

    Page<News> findByPaging(int number, int size);

    long getCount();

    Page<News> findTopByPublic(int number, int size);

    public Page<News> findByPublic(int number, int size);
}
