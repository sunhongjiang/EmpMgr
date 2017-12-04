/*
 * 文件名：Dept.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月10日
 */

package com.cheer.empmgrsystem.domain;

public class Dept
{

    private Integer deptno;

    private String dname;

    private String loc;

    public Dept()
    {
    }
    
    public Dept(Integer deptno, String dname, String loc)
    {
        super();
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public Integer getDeptno()
    {
        return deptno;
    }

    public void setDeptno(Integer deptno)
    {
        this.deptno = deptno;
    }

    public String getDname()
    {
        return dname;
    }

    public void setDname(String dname)
    {
        this.dname = dname;
    }

    public String getLoc()
    {
        return loc;
    }

    public void setLoc(String loc)
    {
        this.loc = loc;
    }

}
