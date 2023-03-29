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
public class Schedulingrules implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 可选值：开店规则、关店规则、客流规则。可扩展
     */
    private String stype;

    /**
     * 
为空时，为系统通用规则。

不为空时，为门店规则。

当门店有门店规则时，使用门店规则进行排班，没有门店规则时，使用系统通用规则进行排班	
     */
    private String sname;

    /**
     * 需要开发者自行设计。

示例：

- 客流规则："3.8"  表示按照业务预测数据，每3.8个客流必须安排至少一个员工当值

- 开店规则："1.5,23.5" 表示开店1个半小时前需要有员工当值，当值员工数为门店面积除以23.5

- 关店规则："2.5,3,13" 表示关店2个半小时内需要有员工当值，当值员工数不小于3并且不小于门店面积除以13

为了提高规则的灵活性，建议使用json格式保存规则值，如关店规则：{"after":"2.5","count":"3","fomula":"size/13"}
     */
    private String svalue;


    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSvalue() {
        return svalue;
    }

    public void setSvalue(String svalue) {
        this.svalue = svalue;
    }

    @Override
    public String toString() {
        return "Schedulingrules{" +
        "stype=" + stype +
        ", sname=" + sname +
        ", svalue=" + svalue +
        "}";
    }
}
