package com.webservice.ahiru.service;

import com.baomidou.mybatisplus.service.IService;
import com.webservice.ahiru.entity.VEmployeeOut;
import com.webservice.ahiru.pojo.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lijunchen
 * @since 2020-03-09
 */
//Service层业务接口类编写
public interface VEmployeeOutService extends IService<VEmployeeOut> {
   Result getInfo(VEmployeeOut vEmployeeOUT);

  // List<VEmployeeOut> getBU(VEmployeeOut vEmployeeOUT);

   Result getBU(VEmployeeOut vEmployeeOUT);
}
