package com.huangyunchi.web.servlet;

import com.huangyunchi.common.BaseHttpServlet;
import com.huangyunchi.entity.News;
import com.huangyunchi.entity.Product;
import com.huangyunchi.entity.common.Page;
import com.huangyunchi.service.NewsService;
import com.huangyunchi.service.ProductService;
import com.huangyunchi.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 前台首页数据展示的Servlet
 */
@WebServlet("/main")
public class MainServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //取出轮播图，3条
        NewsService newsService = ServiceFactory.getNewsService();
        Page<News> pageTop = newsService.findTopByPublic(1, 3);
        request.setAttribute("tops", pageTop.getItems());

        //取最新公告，7条
        Page<News> pageNews = newsService.findByPublic(1, 7);
        request.setAttribute("news", pageNews.getItems());

        //取热门产品，6条
        ProductService productService = ServiceFactory.getProductService();
        Page<Product> pageHot = productService.findHot(1, 6);
        request.setAttribute("hots", pageHot.getItems());

        //取一级类目“手机”下的商品列表，6条
        Page<Product> pagePhone = productService.findByTopCategory(1, 1, 6);
        request.setAttribute("phones", pagePhone.getItems());

        //取一级类目“电脑”下的商品列表，6条
        Page<Product> pageComputer = productService.findByTopCategory(2, 1, 6);
        request.setAttribute("computers", pageComputer.getItems());

        dispatchToPrivateView("/main.jsp", request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
