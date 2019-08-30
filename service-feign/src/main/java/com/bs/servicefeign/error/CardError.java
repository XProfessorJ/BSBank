package com.bs.servicefeign.error;

import com.bs.servicefeign.Entity.CreditcardEntity;
import com.bs.servicefeign.Entity.SavingcardEntity;
import com.bs.servicefeign.service.CardService;
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

    @Override
    public boolean addSavingCard(SavingcardEntity savingCardEntity){
        return false;
    }

    @Override
    public boolean addCreditCard(CreditcardEntity creditCardEntity){
        return false;
    }
}
