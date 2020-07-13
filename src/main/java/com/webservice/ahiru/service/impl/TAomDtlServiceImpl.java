package com.webservice.ahiru.service.impl;


import com.alibaba.druid.util.StringUtils;
import com.webservice.ahiru.entity.TAomDtlJson;
import com.webservice.ahiru.entity.TAomDtlPMItem;
import com.webservice.ahiru.entity.TAomDtlSeries;
import com.webservice.ahiru.entity.VAomDtl;
import com.webservice.ahiru.mapper.TAomDtlMapper;
import com.webservice.ahiru.service.TAomDtlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TAomDtlServiceImpl implements TAomDtlService {

    @Autowired
    TAomDtlMapper tAomDtlMapper;
    TAomDtlJson tAomDtlJson;

    public LinkedHashMap<String, List<TAomDtlPMItem>> getTAomSingleMonth() {
        List<VAomDtl> tEmpWork = tAomDtlMapper.getTAomSingleMonth();

        LinkedHashMap<String, List<TAomDtlPMItem>> result = new LinkedHashMap<>();
        TAomDtlPMItem tAomDtlPMItem = new TAomDtlPMItem();
        for (int i = 0; i < tEmpWork.size(); i++) {
            if (!result.containsKey(tEmpWork.get(i).getMonth())) {
                tAomDtlJson = new TAomDtlJson();
                result.put(tEmpWork.get(i).getMonth(), new ArrayList<TAomDtlPMItem>() {});
            }

            if (StringUtils.isEmpty(tAomDtlPMItem.getPmNo()) || !(tAomDtlPMItem.getPmNo().equals(tEmpWork.get(i).getPmNo())
                    && tAomDtlPMItem.getTeam().equals( tEmpWork.get(i).getTeam()))) {
                tAomDtlPMItem = new TAomDtlPMItem();
                tAomDtlPMItem.setPmNo(tEmpWork.get(i).getPmNo());
                tAomDtlPMItem.setTeam(tEmpWork.get(i).getTeam());

                List<String> tAomDtlCategories = new ArrayList();
                tAomDtlCategories.add(tEmpWork.get(i).getWorkPlace());
                tAomDtlPMItem.settAomDtlCategories(tAomDtlCategories);
                List<TAomDtlSeries> liTAomDtlSeries = AddTAomDtlSeries(tEmpWork.get(i).getPmName(), tEmpWork.get(i).getTimes(), null, null, null);

                tAomDtlPMItem.settAomDtlSeries(liTAomDtlSeries);
                result.get(tEmpWork.get(i).getMonth()).add(tAomDtlPMItem);
            } else {
                tAomDtlPMItem.gettAomDtlCategories().add(tEmpWork.get(i).getWorkPlace());
                AddTAomDtlSeries(tEmpWork.get(i).getPmName(), tEmpWork.get(i).getTimes(),
                        tAomDtlPMItem.gettAomDtlSeries(), tAomDtlPMItem.gettAomDtlSeries().get(0), tAomDtlPMItem.gettAomDtlSeries().get(0).getData());
            }
        }
        return result;
    }

    /*
    * 添加单个人员的时间数据对象
    * */
    private List<TAomDtlSeries> AddTAomDtlSeries(String pmName, Float time, List<TAomDtlSeries> liTAomDtlSeries, TAomDtlSeries tAomDtlSeries, List<Float> times) {
        if (liTAomDtlSeries == null) {
            liTAomDtlSeries = new ArrayList();
        }

        if (tAomDtlSeries == null) {
            tAomDtlSeries = new TAomDtlSeries();
        }

        if (times == null) {
            times = new ArrayList();
        }
        tAomDtlSeries.setName(pmName);
        times.add(time);
        tAomDtlSeries.setData(times);
        if(liTAomDtlSeries.size()==0)
        {
            liTAomDtlSeries.add(tAomDtlSeries);
        }

        return liTAomDtlSeries;
    }
}
