package com.webservice.ahiru.entity;

import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * <p>
 * 编写实体类（依据数据库表），创建私有变量，Set/Get方法的实现
 * </p>
 *
 * @author lijunchen
 * @since 2020-03-09
 */
//视图名：V_EMPLOYEE_OUT
@TableName("V_EMP_OUT")
public class OutManager implements Serializable {

    //用来表明类的不同版本间的兼容性
    private static final long serialVersionUID = 1L;


    //员工姓名
    private String name;

    //经理
    private String manager;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }



    //编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。
    @Override
    //返回参数名称和值
    public String toString() {
        return "OutManager{" +
        ", name=" + name +
        ", manager=" + manager +
        "}";
    }
}
