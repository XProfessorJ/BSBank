package com.bs.servicetransrecord.service.Impl;

import com.bs.servicetransrecord.dao.TransRecordDao;
import com.bs.servicetransrecord.entity.TransRecordEntity;
import com.bs.servicetransrecord.entity.TransRecordWithDisplayEntity;
import com.bs.servicetransrecord.service.TransRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransRecordServiceImpl implements TransRecordService {
    @Autowired
    TransRecordDao transRecordDao;

    @Override
    public List<TransRecordWithDisplayEntity> getRecordByCardIdAndPage(String cardId, int pagenum, int pagerow){
        return transRecordDao.getTransRecordListByCardId(cardId, pagenum, pagerow);
    }

    @Override
    public int countRecordsByCardId(String cardId){
        return transRecordDao.countRecordsByCardId(cardId);
    }
}
