package com.bs.servicetransrecord.service;

import com.bs.servicetransrecord.entity.TransRecordEntity;
import com.bs.servicetransrecord.entity.TransRecordWithDisplayEntity;

import java.util.List;

public interface TransRecordService {
    List<TransRecordWithDisplayEntity> getRecordByCardIdAndPage(String cardId, int pagenum, int pagerow);
    int countRecordsByCardId(String cardId);
}
