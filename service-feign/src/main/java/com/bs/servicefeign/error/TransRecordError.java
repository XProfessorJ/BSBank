package com.bs.servicefeign.error;

import com.bs.servicefeign.Entity.PageList;
import com.bs.servicefeign.service.TransRecordService;

public class TransRecordError implements TransRecordService {

    @Override
    public PageList getTransRecordList(String cardId, Integer pagenum, Integer pagerow) {
        return null;
    }
}
