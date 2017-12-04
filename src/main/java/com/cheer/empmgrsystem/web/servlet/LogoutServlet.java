package com.cheer.empmgrsystem.web.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@WebServlet(name = "logoutServlet", urlPatterns = {"/servlet/logout"})
public class LogoutServlet extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(LogoutServlet.class);

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
        HttpSession session = request.getSession();
        session.invalidate();
        
        LOGGER.info("会话已经注销！");
        
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("已退出登录！");
        out.print("<br/>");
        out.print("<a href=\"../login.jsp\">重新登录</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }

}
