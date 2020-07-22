package com.webservice.ahiru.mapper;
import com.webservice.ahiru.entity.TEmpWork;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Rocky.Yu
 * @since 2020-01-15
 */
//用于标注数据访问组件，即DAO组件。
@Repository
//添加接口
@Mapper
//数据库访问接口类
public interface TEmpWorkMapper {

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中
    public List<TEmpWork> getTEmpWork();

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，把查询出来的数据保存在数据对象中（根据主键）
    public List<TEmpWork> getTEmpWorkById(String id,String year);

    //把表（T_EMP_WORK）的所有字段的值都插入表中
    public int addTEmpWork(TEmpWork tEmpWork);

    //修改数据库表（T_EMP_WORK）的数据
    public int edtTEmpWork(TEmpWork tEmpWork);

    //韩广晨 2020-04-16 Begin
    //修改数据库表（T_EMP_WORK）的数据，根据 PM_EMPLOYEE_NO,PROJECT_ID,CASE_NAME
    public int setTEmpWorkByNO(String newprojectid, String newcasename,
                               String updDt, String updId,
                               String oldpmemployeeno, String oldprojectid, String oldcaseid);

    //获取数据库表（T_EMP_WORK）的数据，以list列表的形式，根据项目经理号去重查询
    public List<TEmpWork> getTEmpWorkByPM_NO(String pmEmployeeNo);
    //韩广晨 2020-04-16 End
    //删除数据库表（T_EMP_WORK）的数据
    public int delTEmpWork(TEmpWork tEmpWork);

    //根据work_no物理删除数据
    public int delTEmpWorkbyworkNo(TEmpWork tEmpWork);
}
