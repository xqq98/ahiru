package com.webservice.ahiru.service.impl;


import com.alibaba.druid.util.StringUtils;
import com.webservice.ahiru.entity.*;
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
                    && tAomDtlPMItem.getProjectName().equals( tEmpWork.get(i).getProjectName()))) {
                tAomDtlPMItem = new TAomDtlPMItem();
                tAomDtlPMItem.setPmNo(tEmpWork.get(i).getPmNo());
                tAomDtlPMItem.setProjectName(tEmpWork.get(i).getProjectName());

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
    * 获取PM 项目的详细信息
    * */
    public LinkedHashMap<String, List<TAomPMTeams>> getTAomPMTeams(){
        List<TAomPMTeams> tAomPMTeams= tAomDtlMapper.getTAomPMTeams();
        LinkedHashMap<String, List<TAomPMTeams>> result = new LinkedHashMap<>();
        String keys="";
        for (int i=0, k=0;i<tAomPMTeams.size();i++,k++){
            if(result.containsKey(tAomPMTeams.get(i).getProjectName())){
                result.get(tAomPMTeams.get(i).getProjectName()).add(tAomPMTeams.get(i));
            }else{
                result.put(tAomPMTeams.get(i).getProjectName(),new ArrayList<TAomPMTeams>(){});
                result.get(tAomPMTeams.get(i).getProjectName()).add(tAomPMTeams.get(i));
                keys+=tAomPMTeams.get(i).getProjectName()+',';
            }
        }

        keys=keys.substring(0, keys.length()-1);
        TAomPMTeams pmt=new TAomPMTeams();
        pmt.setProjectName(keys);
        result.put("containskeys",new ArrayList<TAomPMTeams>(){});
        result.get("containskeys").add(pmt);

        return result;
    }

    public  List<TAomDtlPMItem> getTAomSumMonth(String year)
    {
        List<TAomDtl> tAomPMTeams= tAomDtlMapper.getTAomSumMonth(year);
        List<TAomDtlPMItem> result = new ArrayList<>();
        for(int i=0;i<tAomPMTeams.size();i++){
            TAomDtlPMItem pmItem =new TAomDtlPMItem();
            pmItem.setPmNo(tAomPMTeams.get(i).getPmNo());
            List<String> categories = new ArrayList(){
                {//这个大括号 就是 构造代码块 会在构造函数前 调用
                    add("01");
                    add("02");
                    add("03");
                    add("04");
                    add("05");
                    add("06");
                    add("07");
                    add("08");
                    add("09");
                    add("10");
                    add("11");
                    add("12月");
                }
            };
            pmItem.settAomDtlCategories(categories);
            TAomDtlSeries series = new TAomDtlSeries();
            series.setName(tAomPMTeams.get(i).getPmName());
            List<Float> times = new ArrayList();
            times.add(tAomPMTeams.get(i).getJanNo());
            times.add(tAomPMTeams.get(i).getFebNo());
            times.add(tAomPMTeams.get(i).getMarNo());
            times.add(tAomPMTeams.get(i).getAprNo());
            times.add(tAomPMTeams.get(i).getMayNo());
            times.add(tAomPMTeams.get(i).getJunNo());
            times.add(tAomPMTeams.get(i).getJulNo());
            times.add(tAomPMTeams.get(i).getAugNo());
            times.add(tAomPMTeams.get(i).getSepNo());
            times.add(tAomPMTeams.get(i).getOctNo());
            times.add(tAomPMTeams.get(i).getNovNo());
            times.add(tAomPMTeams.get(i).getDecNo());
            series.setData(times);
            pmItem.settAomDtlSeries(new ArrayList(){{
                add(series);
            }});
            result.add(pmItem);
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
