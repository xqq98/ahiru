package com.webservice.ahiru.controller;
import com.webservice.ahiru.entity.TAomDtl;
import com.webservice.ahiru.entity.TAomDtlPMItem;
import com.webservice.ahiru.entity.TAomPMTeams;
import com.webservice.ahiru.entity.VAomDtl;
import com.webservice.ahiru.pojo.Result;
import com.webservice.ahiru.service.TAomDtlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("/taomdtl")
public class TAomDtlController {
    //Log文件的获取
    private Logger logger = LoggerFactory.getLogger(MProjectController.class);
    //Service接口的实现类
    @Autowired
    private TAomDtlService tAomDtlService;

    //控制器处理“/gettempwork”的URL请求，POST请求
    @RequestMapping(value = "/gettaomsinglemonth", method = RequestMethod.GET)
    public Result getTEmpWork() {
        LinkedHashMap<String, List<TAomDtlPMItem>> result =tAomDtlService.getTAomSingleMonth();

        return Result.ok(result);
    }

    //控制器处理“/gettempwork”的URL请求，POST请求
    @RequestMapping(value = "/gettaomsummonth", method = RequestMethod.GET)
    public Result getTAomSumMonth() {//@RequestParam("year") String year
        List<TAomDtlPMItem> result =tAomDtlService.getTAomSumMonth("2020");

        return Result.ok(result);
    }

    @RequestMapping(value = "/gettaompmteams", method = RequestMethod.GET)
    public Result getTAomPMTeams(){
        LinkedHashMap<String, List<TAomPMTeams>> result  =tAomDtlService.getTAomPMTeams();

        return Result.ok(result);
    }
}
