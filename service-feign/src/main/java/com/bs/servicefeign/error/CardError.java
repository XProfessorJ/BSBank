package com.bs.servicefeign.error;

import com.bs.servicefeign.service.CardService;

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
}
