package com.bs.servicecard.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */
public interface CardService {
    Map<String, List> getCardsByAccountId(String accountId);
    boolean addSavingCard(String cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currencyCode, String accountClassification, String accountId);
    boolean addCreditCard(String  cardId, String productName, String productCode, String accountNickName, String displayAccountNumber, String currentCode, String accountClassification, Date creditLimitIncreaseStartDate, Date creditLimitIncreaseEndDate, String reasonCode, String accountId);

    String getStatusByCardId(String cardId);
    String updateCardStatus(String cardId);
}
