package com.bs.servicecard.controller;

import com.bs.servicecard.Entity.CardEntity;
import com.bs.servicecard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
