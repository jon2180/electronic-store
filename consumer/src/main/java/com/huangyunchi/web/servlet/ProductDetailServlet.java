package com.huangyunchi.web.servlet;

import com.huangyunchi.common.BaseHttpServlet;
import com.huangyunchi.entity.Category;
import com.huangyunchi.entity.Product;
import com.huangyunchi.entity.common.Page;
import com.huangyunchi.service.CategoryService;
import com.huangyunchi.service.ProductService;
import com.huangyunchi.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 商品的详情展示
 */
@WebServlet("/product_detail")
public class ProductDetailServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String idStr = request.getParameter("id");
        Integer id = Integer.valueOf(idStr);

        //
        ProductService productService = ServiceFactory.getProductService();
        Product product = productService.findOne(id);
        request.setAttribute("product", product);

        //查询商品所属的类目对象
        Integer cate_id = product.getCate_id();
        CategoryService categoryService = ServiceFactory.getCategoryService();
        Category cate = categoryService.findOne(cate_id);
        request.setAttribute("cate", cate);

        //当前商品所属类目下的热门商品列表
        Page<Product> hotsPage = productService.findBySubCategory(cate_id, 1, 3);
        request.setAttribute("hots", hotsPage.getItems());

        //
        dispatchToPrivateView("/product_detail.jsp", request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
