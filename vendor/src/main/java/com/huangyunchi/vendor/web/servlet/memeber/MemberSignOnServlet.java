package com.huangyunchi.vendor.web.servlet.memeber;

import com.huangyunchi.common.BaseHttpServlet;
import com.huangyunchi.entity.Vendor;
import com.huangyunchi.util.HeaUtil;
import com.huangyunchi.util.Validator;
import com.huangyunchi.vendor.service.VendorService;
import com.huangyunchi.vendor.web.KeyConfig;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@WebServlet("/member/sign-on")
public class MemberSignOnServlet extends BaseHttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String license = req.getParameter("license");
        String mobile = req.getParameter("email");
        String rawPassword = req.getParameter("password");
        String captcha = req.getParameter("captcha");

        // step 2: 检查验证码信息
        if (captcha == null ||
                !captcha.toLowerCase().equals(
                        (req.getSession().getAttribute(KeyConfig.captchaName)).toString().toLowerCase()
                )) {
            req.setAttribute("msg", "注册失败，验证码不匹配");
            req.getRequestDispatcher("/signon.jsp").forward(req, resp);
            return;
        }

        // 验证格式
        if (!Validator.mobilePhone(mobile) || !Validator.checkComplexPassword(rawPassword)) {
            req.setAttribute("msg", "注册失败，手机号或密码格式错误");
            req.getRequestDispatcher("/signon.jsp").forward(req, resp);
            return;
        }

        // 查询
        Vendor vendor = new Vendor();
        vendor.setVendorName(name);
        vendor.setVendorLicense(license);
        vendor.setVendorTel(mobile);
        try {
            vendor.setVendorPassword(HeaUtil.md5(rawPassword));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        VendorService service = new VendorService();
        if (service.register(vendor)) {
            resp.sendRedirect(getServletContext().getContextPath() + "/signin.jsp");
        } else {
            resp.sendRedirect(getServletContext().getContextPath() + "/signon.jsp");
        }


//        vendor_name          varchar(128)                        not null comment '店家的名字，公司名',
//                vendor_license       varchar(256)                        not null comment '许可证信息',
//                vendor_tel           varchar(32)                         not null comment '联系电话',
//                vendor_email         varchar(256)                        default null comment '邮箱',
//                vendor_password      varchar(64)                         not null,
//                vendor_score         double                              null comment '评分',
//                vendor_level         tinyint   default 1                 not null comment '1 初始状态，最高 10',
//                vendor_register_time timestamp default CURRENT_TIMESTAMP not null comment '注册事件',
//                vendor_status        tinyint   default 0                 not null comment '0 正常'

    }
}
