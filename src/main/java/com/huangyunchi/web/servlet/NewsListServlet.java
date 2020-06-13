package com.huangyunchi.web.servlet;

import com.huangyunchi.common.BaseHttpServlet;
import com.huangyunchi.entity.News;
import com.huangyunchi.entity.common.Page;
import com.huangyunchi.service.NewsService;
import com.huangyunchi.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 公告的列表页
 */
@WebServlet("/news/list")
public class NewsListServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int size = 10; //每页要显示的记录条数
        int number = 1; //要查询第number页
        String numberStr = request.getParameter("number");
        if (numberStr != null && !"".equals(numberStr)) {
            number = Integer.parseInt(numberStr);
        }
        if (number < 1) {
            number = 1;
        }

        NewsService newsService = ServiceFactory.getNewsService();
        Page<News> page = newsService.findByPublic(number, size);


        request.setAttribute("newsPage", page);
        dispatchToPrivateView("/news_list.jsp", request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
