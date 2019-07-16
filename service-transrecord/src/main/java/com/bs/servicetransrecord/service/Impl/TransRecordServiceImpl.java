package com.bs.servicetransrecord.service.Impl;

import com.bs.servicetransrecord.dao.TransRecordDao;
import com.bs.servicetransrecord.entity.TransRecordEntity;
import com.bs.servicetransrecord.service.TransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransRecordServiceImpl implements TransRecordService {
    @Autowired
    TransRecordDao transRecordDao;

    @Override
    public List<TransRecordEntity> getTransRecordListByCardId(String cardId){
        return transRecordDao.getTransRecordListByCardId(cardId);
    }

}
