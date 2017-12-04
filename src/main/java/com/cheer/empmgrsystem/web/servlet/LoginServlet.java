package com.cheer.empmgrsystem.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet(name = "login", urlPatterns = {"/servlet/login"})
public class LoginServlet extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(LoginServlet.class);

    private static final long serialVersionUID = 1L;
    
    private String contentType;
    
    @Override
    public void init(ServletConfig config)
        throws ServletException
    {
        super.init(config);
        LOGGER.info("init() method is invoked...");

        this.contentType = config.getInitParameter("Content-Type");

        LOGGER.info("contentType : {}", contentType);
    }
    
    public LoginServlet()
    {
        LOGGER.info("LoginServlet实例被创建...");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet() method is invoked...");

        String userName = null;
        String password = null;

        // 从客户端获取Cookie
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies)
        {
            LOGGER.info("Cookie:{}={}", cookie.getName(), cookie.getValue());
            // 检查cookie里是否有username的cookie
            if ("username".equals(cookie.getName()))
            {
                userName = cookie.getValue();
                continue;
            }

            // 检查cookie里是否有password的cookie
            if ("password".equals(cookie.getName()))
            {
                password = cookie.getValue();
            }
        }

        // 从前台表单页面里获取name值为？的input的value值
        userName = request.getParameter("username") != null ? request.getParameter(
            "username") : userName;
        password = request.getParameter("password") != null ? request.getParameter(
            "password") : password;

        // on/null
        String autoLogin = request.getParameter("autoLogin");
        LOGGER.info("autoLogin={}", autoLogin);

        // 设置内容类型 以 内容编码
        response.setContentType(this.contentType);
        PrintWriter pw = response.getWriter();

        ServletContext context = this.getServletContext();
        String userNameParam = context.getInitParameter("username");
        String passwordParam = context.getInitParameter("password");
        LOGGER.info("username={}, password={}", userNameParam, passwordParam);

        if (userNameParam.equals(userName) && passwordParam.equals(password))
        {
            // 获取session并设置域值username
            HttpSession session = request.getSession();
            session.setAttribute("username", userName);
            // 并设置登录状态
            session.setAttribute("isLogin", true);
            
            // 如果选择了保存自动登录就设置cookie
            if ("on".equals(autoLogin))
            {
                LOGGER.info("服务端设置的Cookie...");
                Cookie usernameCookie = new Cookie("username", userName);
                Cookie passwordCookie = new Cookie("password", password);
                usernameCookie.setMaxAge(3600);
                passwordCookie.setMaxAge(3600);
                usernameCookie.setPath("/");
                passwordCookie.setPath("/");

                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);

            }

            LOGGER.info("转发---------->/servlet/first");
            // 当前 /servlet/login
            // 目标 /servlet/first

            // 设置共享域 在转发后的请求中可以获取该值
            request.setAttribute("isLogin", "false");

            // 路径可以是相对路径也可以是绝对路径，绝对路径是绝对于该应用的根目录也就是/Servlet-01
            request.getRequestDispatcher("first").forward(request, response);
            return;
        }

        // pw.println("用户名密码不匹配，登录失败！");
        // pw.close();

        // 如果密码错误跳转到登录页面
        // 当前 /servlet/login
        // 目标 /index.html

        LOGGER.info("跳转---------->login.jsp");
        // 此处使用转发会出现问题，跳转后，虽然页面内容改变了，但是url未改变，说明此时页面路径还是在/servlet
        // request.getRequestDispatcher("../index.html").forward(request, response);
        /**
         * HTTP Status 404 – Not Found Type Status Report Message /Servlet-01/servlet/servlet/login
         * Description The origin server did not find a current representation for the target
         * resource or is not willing to disclose that one exists. Apache Tomcat/8.5.23
         */

        // 注意：在使用response.sendRedirect()或者request.getRequestDispatcher().forward()时，
        // 在之前不可以使用response的PrintWriter对象或者ServletOutputStream对象
        // 路径可以是相对路径也可以是绝对路径，绝对路径是绝对于整个web站点，也是tomcat的webapps目录
        // 可以跨站点重定向
        response.sendRedirect("../login.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {

        LOGGER.info("doPost() method is invoked...");
        this.doGet(request, response);
    }
    
    @Override
    public void destroy()
    {
        LOGGER.info("destroy() method is invoked...");
    }

}
