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
public class Preferences implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 偏好类型：可选值：工作日偏好、工作时间偏好、班次时长偏好。可扩展
     */
    private String pretype;

    /**
     * 当员工没有选择对应的偏好类型时，表示员工对该类型无特殊偏好。
     */
    private String ename;

    /**
     * 偏好值：
需要开发者自行设计。
示例：

- 工作日偏好的值：1,3,4     表示偏好周一、周三、周四工作。

- 工作时间偏好的值：08:00-12:00,18:00:22:00 表示偏好上午8点到12点和晚上6点到10点工作
     */
    private String prevalue;


    public String getPretype() {
        return pretype;
    }

    public void setPretype(String pretype) {
        this.pretype = pretype;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getPrevalue() {
        return prevalue;
    }

    public void setPrevalue(String prevalue) {
        this.prevalue = prevalue;
    }

    @Override
    public String toString() {
        return "Preferences{" +
        "pretype=" + pretype +
        ", ename=" + ename +
        ", prevalue=" + prevalue +
        "}";
    }
}
