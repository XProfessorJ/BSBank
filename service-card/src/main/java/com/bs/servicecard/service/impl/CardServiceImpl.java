package com.bs.servicecard.service.impl;

import com.bs.servicecard.dao.CardDao;
import com.bs.servicecard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public boolean addSavingCard(String cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currencyCode, String accountClassification, String accountId) {
        return cardDao.addSavingCard(cardId, productName, productCode, accountNickName, displayAccountNumber, currencyCode, accountClassification, accountId);
    }

    @Override
    public boolean addCreditCard(String  cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currentCode, String accountClassification, Date creditLimitIncreaseStartDate, Date creditLimitIncreaseEndDate, String reasonCode, String accountId){
        return cardDao.addCreditCard(cardId, productName, productCode, accountNickName, displayAccountNumber, currentCode, accountClassification, creditLimitIncreaseStartDate, creditLimitIncreaseEndDate, reasonCode, accountId);
    }


}
