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
public class Store implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 门店编号，业务预测数据用id关联门店
     */
    private String sid;

    /**
     * 在页面上显示门店名称
     */
    private String sname;

    /**
     * 门店地址
     */
    private String address;

    /**
     * 单位：平方米
     */
    private Float size;


    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Store{" +
        "sid=" + sid +
        ", sname=" + sname +
        ", address=" + address +
        ", size=" + size +
        "}";
    }
}
