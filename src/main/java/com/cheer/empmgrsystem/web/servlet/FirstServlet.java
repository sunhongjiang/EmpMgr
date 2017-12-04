package com.cheer.empmgrsystem.web.servlet;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// 从Servlet3.0开始支持注解，但是建议使用xml配置方式
@WebServlet(urlPatterns = {"/servlet/first"})
public class FirstServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = LogManager.getLogger(FirstServlet.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        
        // 获取请求行的相关信息
        // /Servlet-01/servlet/first
        LOGGER.info("RequestURI={}", request.getRequestURI());
        // http://192.168.2.129:8080/Servlet-01/servlet/first
        LOGGER.info("RequestURL={}", request.getRequestURL());
        // /Servlet-01
        LOGGER.info("ContextPath={}", request.getContextPath());
        // /servlet/first
        LOGGER.info("ServletPath={}", request.getServletPath());
        LOGGER.info("RemoteHost={}", request.getRemoteHost());
        LOGGER.info("RemoteAddress={}", request.getRemoteAddr());
        
        // 获取http协议请求头
        LOGGER.info("Connection={}", request.getHeader("Connection"));
        LOGGER.info("User-Agent={}", request.getHeader("User-Agent"));
        LOGGER.info("Accept-Language={}", request.getHeader("Accept-Language"));
        
        StringBuilder sb = new StringBuilder();
        Enumeration<String> value = request.getHeaders("Accept-Language");
        while(value.hasMoreElements())
        {
            sb.append(value.nextElement()).append("|");
        }
        
        sb.deleteCharAt(sb.length() - 1);
        
        LOGGER.info("Accept-Language={}", sb);
        
        
        LOGGER.info("request共享域中的值: isLogin={}", request.getAttribute("isLogin"));
        
        // 跳转至hello.jsp
        response.sendRedirect("../index.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }

}
