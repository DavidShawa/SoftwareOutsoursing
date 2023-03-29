package com.example.softwareoutsoursing.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author XYZ
 * @since 2023-03-29
 */
public class Employee implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 员工id，用于唯一标识员工，使用员工id关联门店
     */
    private String eid;

    private String ename;

    /**
     * 员工邮件地址，可以作为用户登录名，唯一
     */
    private String email;

    /**
     * 可选值：门店经理，副经理，小组长，店员
     */
    private String position;

    /**
     * 员工所属门店
     */
    private String sname;


    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public String toString() {
        return "Employee{" +
        "eid=" + eid +
        ", ename=" + ename +
        ", email=" + email +
        ", position=" + position +
        ", sname=" + sname +
        "}";
    }
}
