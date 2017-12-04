/*
 * 文件名：DeptDaoImpl.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月28日
 */

package com.cheer.empmgrsystem.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cheer.empmgrsystem.dao.DeptDao;
import com.cheer.empmgrsystem.domain.Dept;
import com.cheer.empmgrsystem.util.DBHelper;
import com.cheer.empmgrsystem.util.Page;


public class DeptDaoImpl implements DeptDao
{
    private static final Logger LOGGER = LogManager.getLogger(DeptDaoImpl.class);

    @Override
    public void save(Dept dept)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void batchSave(List<Dept> depts)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Dept dept)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(Dept dept)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public Dept find(Integer deptno)
    {
        Dept dept = null;

        Connection conn = DBHelper.getInstance().getConnection();

        String sql = "SELECT * FROM dept WHERE deptno = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, deptno);

            rs = ps.executeQuery();

            while (rs.next())
            {
                dept = new Dept();
                dept.setDeptno(deptno);
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));
            }

        }
        catch (SQLException e)
        {
            LOGGER.catching(e);
        }
        return dept;
    }

    @Override
    public List<Dept> getAll()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Dept> getPage(Page page)
    {
        // TODO Auto-generated method stub
        return null;
    }

}
