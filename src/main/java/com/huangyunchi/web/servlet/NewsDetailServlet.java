package com.huangyunchi.web.servlet;

import com.huangyunchi.entity.News;
import com.huangyunchi.service.NewsService;
import com.huangyunchi.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 公告的详情
 */
@WebServlet("/news/detail")
public class NewsDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //
        String idStr = request.getParameter("id");
        Integer id = Integer.valueOf(idStr);

        //
        NewsService newsService = ServiceFactory.getNewsService();
        News news = newsService.findOne(id);

        //
        request.setAttribute("news", news);
        request.getRequestDispatcher("/news_detail.jsp").forward(request, response);
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
