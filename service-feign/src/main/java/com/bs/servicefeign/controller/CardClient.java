package com.bs.servicefeign.controller;

import com.bs.servicefeign.Entity.CreditcardEntity;
import com.bs.servicefeign.Entity.SavingcardEntity;
import com.bs.servicefeign.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */

@RestController
@CrossOrigin
public class CardClient {

    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    CardService cardService;

    @RequestMapping(value = "/cards/{accountId}", method = RequestMethod.GET)
    public Map<String, Object> getCardsByAccountId(@PathVariable("accountId") String accountId){
        return cardService.getCardsByAccountId(accountId);
    }

    //修改card状态
    @RequestMapping(value = "/cardstatus/{cardId}", method = RequestMethod.PUT)
    public String updateCardStatus(@PathVariable("cardId") String cardId) {
        return cardService.updateCardStatus(cardId);
    }

    @RequestMapping(value = "/savingcard", method = RequestMethod.POST)
    public boolean addSavingCard(@RequestBody SavingcardEntity savingCardEntity) {
        return cardService.addSavingCard(savingCardEntity);
    }

    @RequestMapping(value = "/creditcard", method = RequestMethod.POST)
    public boolean addCreditCard(@RequestBody CreditcardEntity creditCardEntity) {
        return cardService.addCreditCard(creditCardEntity);
    }
}
