package com.huangyunchi.web.servlet.tool;

import com.huangyunchi.util.CAPTCHAUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static com.huangyunchi.web.KeyConfig.captchaName;

/**
 * 生成验证码的servlet，并将验证码的文本设置到session中，session 的键 为 KeyConfig.captchaName
 * 直接配置在a标签的href属性下即可
 */
@WebServlet(name = "fetch captcha", urlPatterns = "/tool/captcha/*")
public class CAPTCHAServlet extends HttpServlet {
    /*
     1. 生成验证码
     2. 把验证码上的文本存在session中
     3. 把验证码图片发送给客户端
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CAPTCHAUtil v = new CAPTCHAUtil();     //用我们的验证码类，生成验证码类对象
        BufferedImage image = v.getImage();  //获取验证码

        req.getSession().setAttribute(captchaName, v.getText()); //将验证码的文本存在session中

        CAPTCHAUtil.output(image, resp.getOutputStream());       //将验证码图片响应给客户端
    }
}
