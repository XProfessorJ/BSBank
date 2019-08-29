package com.bs.servicecard.controller;

import com.bs.servicecard.Entity.CardEntity;
import com.bs.servicecard.Entity.CardEntity;
import com.bs.servicecard.Entity.CreditcardEntity;
import com.bs.servicecard.Entity.SavingcardEntity;
import com.bs.servicecard.Entity.SavingcardEntity;
import com.bs.servicecard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */
@RestController
@CrossOrigin
public class CardController {

    @Autowired
    CardService cardService;

    @RequestMapping(value = "/cards/{accountId}", produces = {"application/json"})
    @ResponseBody
    public Map<String, Object> getCards(@PathVariable("accountId") String accountId) {
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, List> cardMap =  cardService.getCardsByAccountId(accountId);
        resultMap.put("cards", cardMap);
        return resultMap;
    }


    //修改card状态
    @PutMapping(value = "/cardstatus/{cardId}")
    public String updateCardStatus(@PathVariable("cardId") String cardId) {
        String res = cardService.updateCardStatus(cardId);
        return res;
    }

    @PostMapping(value="/savingcard", produces = {"application/json"})
    @ResponseBody
    public boolean addSavingCard(@RequestBody SavingcardEntity savingCardEntity){
        boolean addSavingCardFlag;

        String cardId = savingCardEntity.getCardId();
        String productName = "Debit Card";
        String productCode = savingCardEntity.getProductCode();
        String accountNickName = savingCardEntity.getAccountNickname();
        String displayAccountNumber = savingCardEntity.getDisplayAccountNumber();
        String currencyCode = savingCardEntity.getCurrencyCode();
        String accountClassification = savingCardEntity.getAccountClassification();
        String accountId = savingCardEntity.getAccountId();


        addSavingCardFlag = cardService.addSavingCard(cardId, productName, productCode, accountNickName, displayAccountNumber, currencyCode, accountClassification, accountId);

        return addSavingCardFlag;
    }

    @PostMapping(value="/creditcard", produces = {"application/json"})
    @ResponseBody
    public boolean addCreditCard(@RequestBody CreditcardEntity creditCardEntity){
        boolean addCreditCardFlag;

        String cardId = creditCardEntity.getCardId();
        String productName = creditCardEntity.getProductName();
        String productCode = creditCardEntity.getProductCode();
        String accountNickName = creditCardEntity.getAccountNickname();
        String displayAccountNumber = creditCardEntity.getDisplayAccountNumber();
        String currencyCode = creditCardEntity.getCurrencyCode();
        String accountClassification = creditCardEntity.getAccountClassification();
        Date creditLimitIncreaseStartDate = creditCardEntity.getCreditLimitIncreaseStartDate();
        Date creditLimitIncreaseEndDate = creditCardEntity.getCreditLimitIncreaseEndDate();
        String reasonCode = creditCardEntity.getReasonCode();
        String accountId = creditCardEntity.getAccountId();

        addCreditCardFlag = cardService.addCreditCard(cardId, productName, productCode, accountNickName, displayAccountNumber, currencyCode, accountClassification, creditLimitIncreaseStartDate, creditLimitIncreaseEndDate, reasonCode, accountId);

        return addCreditCardFlag;
    }
}
