package com.huangyunchi.service;

import com.huangyunchi.entity.Category;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CategoryServiceTest {

    @Test
    public void testFindAll() {
        CategoryService service = new CategoryService();

        List<Category> list = service.findAll(); //

        for (Category category : list) { //遍历一级类目
            System.out.println("|--" + category.getName());

            for (Category child : category.getChilds()) { //遍历当前一级类目下的所有二级类目
                System.out.println("    |--" + child.getName());
            }
        }
    }
}
