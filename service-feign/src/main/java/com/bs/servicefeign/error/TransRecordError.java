package com.bs.servicefeign.error;

import com.bs.servicefeign.Entity.AccountWithTokenEntity;
import com.bs.servicefeign.Entity.CardIdWithTokenEntity;
import com.bs.servicefeign.service.TransRecordService;

public class TransRecordError implements TransRecordService {
    @Override
    public String getTransRecordList(CardIdWithTokenEntity cardIdWithTokenEntity) {
        return "Failed to get transRecord";
    }
}
