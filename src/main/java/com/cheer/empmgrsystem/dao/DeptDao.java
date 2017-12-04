/*
 * 文件名：DeptDao.java
 * 版权：Copyright by www.cheer.com
 * 描述：
 * 修改人：Cheer
 * 修改时间：2017年11月28日
 */

package com.cheer.empmgrsystem.dao;

import java.util.List;

import com.cheer.empmgrsystem.domain.Dept;
import com.cheer.empmgrsystem.util.Page;


public interface DeptDao
{
    void save(Dept dept);

    void batchSave(List<Dept> depts);
    
    void delete(Dept dept);
    
    void update(Dept dept);
    
    Dept find(Integer deptno);
    
    List<Dept> getAll();

    List<Dept> getPage(Page page);
}
