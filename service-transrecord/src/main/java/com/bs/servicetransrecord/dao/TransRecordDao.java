package com.bs.servicetransrecord.dao;

import com.bs.servicetransrecord.entity.TransRecordWithDisplayEntity;

import java.util.List;

public interface TransRecordDao {
    List<TransRecordWithDisplayEntity> getTransRecordListByCardId(String cardId, int pagenum, int pagerow);
    int countRecordsByCardId(String cardId);
}
