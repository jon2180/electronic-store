package com.huangyunchi.web.servlet;

import com.huangyunchi.common.BaseHttpServlet;
import com.huangyunchi.entity.Address;
import com.huangyunchi.entity.Member;
import com.huangyunchi.entity.Orders;
import com.huangyunchi.service.AddressService;
import com.huangyunchi.service.MemberService;
import com.huangyunchi.service.ServiceFactory;
import com.huangyunchi.util.HeaUtil;
import com.huangyunchi.util.Validator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import static com.huangyunchi.web.KeyConfig.captchaName;

/**
 * 处理会员登录的Servlet
 */
@WebServlet("/member_login")
public class MemberLoginServlet extends BaseHttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatchToPrivateView("member_login.jsp", req, resp);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //step1： 获取客户端提交的数据
        String mobile = request.getParameter("mobile");
        String rawPwd = request.getParameter("pwd");
        String captcha = request.getParameter("captcha");

        // step 2: 检查验证码信息
        if (captcha == null ||
                !captcha.toLowerCase().equals(
                        (request.getSession().getAttribute(captchaName)).toString().toLowerCase()
                )) {
            request.setAttribute("msg", "登录失败，验证码不匹配");
            request.getRequestDispatcher("/member_login.jsp").forward(request, response);
            return;
        }

        // step 3: 验证格式
        if (!Validator.mobilePhone(mobile) || !Validator.checkComplexPassword(rawPwd)) {
            request.setAttribute("msg", "登录失败，手机号或密码格式错误");
            request.getRequestDispatcher("/member_login.jsp").forward(request, response);
            return;
        }

        // step 4: 获取用户信息
        MemberService service = ServiceFactory.getMemberService();
        Member mbr = service.findByMobile(mobile);
        // 用户名不存在，退出
        if (mbr == null) {
            request.setAttribute("msg", "用户名不存在！");
            request.getRequestDispatcher("/member_login.jsp").forward(request, response);
            return;
        }

        // 业务逻辑处理

        // md5 加密处理密码
        String pwd = null;
        try {
            pwd = HeaUtil.md5(rawPwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (mbr.getPwd().equals(pwd)) {
            // 登录成功
            // 在会话中记录当前登录的会员信息
            request.getSession().setAttribute("curr_mbr", mbr);

            // 如果登录后的会员，有提交订单，跳转到/orders.jsp; 没有就跳转到会员的首页
            Orders order = (Orders) request.getSession().getAttribute("curr_order");
            if (order != null) {
                AddressService service2 = ServiceFactory.getAddressService();
                List<Address> addressList = service2.findByMember(mbr.getId());
                // step3: 执行跳转
                request.setAttribute("addressList", addressList);
                request.getRequestDispatcher("/orders.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/member/orders");
            }
        } else {//密码有误
            request.setAttribute("msg", "密码不正确！");
            request.getRequestDispatcher("/member_login.jsp").forward(request, response);
        }
    }

}
