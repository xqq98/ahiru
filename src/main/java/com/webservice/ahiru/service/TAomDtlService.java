package com.webservice.ahiru.service;
import com.webservice.ahiru.entity.TAomDtlPMItem;
import java.util.LinkedHashMap;
import java.util.List;

public interface TAomDtlService {
    public LinkedHashMap<String, List<TAomDtlPMItem>> getTAomSingleMonth();
}
