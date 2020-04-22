package com.webservice.ahiru.entity;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author mengliang
 * @since 2020-1-7
 */

public class MCodeName implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;

    //通用代码名称
    private String hanYouValueName;

    public String getHanYouValueName() {
        return hanYouValueName;
    }

    public void setHanYouValueName(String hanYouValueName) {
        this.hanYouValueName = hanYouValueName;
    }

}
