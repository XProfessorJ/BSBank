package com.bs.servicetransrecord.dao;

import com.bs.servicetransrecord.entity.TransRecordEntity;

import java.util.List;

public interface TransRecordDao {
    List<TransRecordEntity> getTransRecordListByCardId(String cardId, int pagenum, int pagerow);
    int countRecordsByCardId(String cardId);
}
