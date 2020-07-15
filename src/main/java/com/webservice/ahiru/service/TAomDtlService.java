package com.webservice.ahiru.service;
import com.webservice.ahiru.entity.TAomDtl;
import com.webservice.ahiru.entity.TAomDtlPMItem;
import com.webservice.ahiru.entity.TAomPMTeams;

import java.util.LinkedHashMap;
import java.util.List;

public interface TAomDtlService {
    public LinkedHashMap<String, List<TAomDtlPMItem>> getTAomSingleMonth();

    public LinkedHashMap<String, List<TAomPMTeams>> getTAomPMTeams();
}
