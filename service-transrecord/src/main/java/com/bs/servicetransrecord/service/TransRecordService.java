package com.bs.servicetransrecord.service;

import com.bs.servicetransrecord.entity.TransRecordEntity;

import java.util.List;

public interface TransRecordService {
    List<TransRecordEntity> getTransRecordListByCardId(String cardId);
}
