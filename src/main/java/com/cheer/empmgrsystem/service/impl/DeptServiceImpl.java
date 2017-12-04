/*
 * 文件名：DeptServiceImpl.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月28日
 */

package com.cheer.empmgrsystem.service.impl;


import java.util.List;

import com.cheer.empmgrsystem.dao.DeptDao;
import com.cheer.empmgrsystem.domain.Dept;
import com.cheer.empmgrsystem.service.DeptService;
import com.cheer.empmgrsystem.util.Page;


public class DeptServiceImpl implements DeptService
{
    private DeptDao deptDao;

    public void setDeptDao(DeptDao deptDao)
    {
        this.deptDao = deptDao;
    }

    @Override
    public void save(Dept dept)
    {
        this.deptDao.save(dept);

    }

    @Override
    public void batchSave(List<Dept> depts)
    {
        this.deptDao.batchSave(depts);
    }

    @Override
    public void delete(Dept dept)
    {
        this.deptDao.delete(dept);
    }

    @Override
    public void update(Dept dept)
    {
        this.deptDao.update(dept);
    }

    @Override
    public Dept find(Integer deptno)
    {
        return this.deptDao.find(deptno);
    }

    @Override
    public List<Dept> getAll()
    {
        return this.deptDao.getAll();
    }

    @Override
    public List<Dept> getPage(Page page)
    {
        return this.deptDao.getPage(page);
    }

}
