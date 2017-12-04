/*
 * 文件名：AddEmpServlet.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：JuliusRandle
 * 修改时间：2017年11月29日
 */

package com.cheer.empmgrsystem.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.empmgrsystem.domain.Emp;
import com.cheer.empmgrsystem.service.EmpService;

@WebServlet(name = "addEmp", urlPatterns = {"/servlet/addEmp"})
public class AddEmpServlet extends HttpServlet
{
    private static final Logger LOGGER = LogManager.getLogger(AddEmpServlet.class);

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        LOGGER.info("doGet method is invoked...");
       
        EmpService empService = (EmpService)this.getServletContext().getAttribute("empService");

        Emp emp = new Emp();

        empService.save(emp);
        
        response.sendRedirect("../add.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException,
        IOException
    {
        this.doGet(request, response);
    }
}
