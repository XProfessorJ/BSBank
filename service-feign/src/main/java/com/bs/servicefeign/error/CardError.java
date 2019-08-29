package com.bs.servicefeign.error;

import com.bs.servicefeign.Entity.CardEntity;
import com.bs.servicefeign.service.CardService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */
public class CardError implements CardService {
    @Override
    public Map<String, Object> getCardsByAccountId(String accountId){
        return null;
    }

    @Override
    public String updateCardStatus(String cardId){
        return null;
    }
}
