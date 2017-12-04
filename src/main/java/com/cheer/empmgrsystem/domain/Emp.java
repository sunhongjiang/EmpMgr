/*
 * 文件名：Emp.java 版权：Copyright by www.cheer.com 描述： 修改人：Cheer 修改时间：2017年11月10日
 */

package com.cheer.empmgrsystem.domain;


import java.util.Date;


public class Emp
{

    private Integer empno;

    private String ename;

    private String job;

    private Integer mgr;

    private Date hiredate;

    private Double sal;

    private Double comm;

    private Dept dept;

    public Emp()
    {}

    public Emp(Integer empno, String ename, String job, Date hiredate, Double sal)
    {
        super();
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    
    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, Double sal,
               Double comm, Dept dept)
    {
        super();
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.dept = dept;
    }

    public Integer getEmpno()
    {
        return empno;
    }

    public void setEmpno(Integer empno)
    {
        this.empno = empno;
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public Integer getMgr()
    {
        return mgr;
    }

    public void setMgr(Integer mgr)
    {
        this.mgr = mgr;
    }

    public Date getHiredate()
    {
        return hiredate;
    }

    public void setHiredate(Date hiredate)
    {
        this.hiredate = hiredate;
    }

    public Double getSal()
    {
        return sal;
    }

    public void setSal(Double sal)
    {
        this.sal = sal;
    }

    public Double getComm()
    {
        return comm;
    }

    public void setComm(Double comm)
    {
        this.comm = comm;
    }

    public Dept getDept()
    {
        return dept;
    }

    public void setDept(Dept dept)
    {
        this.dept = dept;
    }

}
