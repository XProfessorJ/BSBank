package com.bs.servicefeign.service;

import com.bs.servicefeign.Entity.CardEntity;
import com.bs.servicefeign.Entity.CreditcardEntity;
import com.bs.servicefeign.Entity.SavingcardEntity;
import com.bs.servicefeign.error.CardError;
import com.bs.servicefeign.error.CustomerError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */

@FeignClient(value = "service-card", fallback = CardError.class)
@CrossOrigin
public interface CardService {
    @RequestMapping(value = "/cards/{accountId}", method = RequestMethod.GET)
    public Map<String, Object> getCardsByAccountId(@PathVariable("accountId") String accountId);

    @RequestMapping(value = "/cardstatus/{cardId}", method = RequestMethod.PUT)
    public String updateCardStatus(@PathVariable("cardId") String cardId);

    @RequestMapping(value = "/savingcard", method = RequestMethod.POST)
    public boolean addSavingCard(@RequestBody SavingcardEntity savingCardEntity);

    @RequestMapping(value = "/creditcard", method = RequestMethod.POST)
    public boolean addCreditCard(@RequestBody CreditcardEntity creditCardEntity);

}

