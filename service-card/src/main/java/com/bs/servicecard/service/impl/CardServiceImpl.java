package com.bs.servicecard.service.impl;

import com.bs.servicecard.Entity.CardEntity;
import com.bs.servicecard.Entity.CreditcardEntity;
import com.bs.servicecard.Entity.SavingcardEntity;
import com.bs.servicecard.dao.CardDao;
import com.bs.servicecard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardDao cardDao;

    @Override
    public Map<String, List> getCardsByAccountId(String accountId) {
        return cardDao.getCardsByAccountId(accountId);
    }

    @Override
    public String updateCardStatus(String cardId){
        return cardDao.updateCardStatus(cardId);
    }

}
