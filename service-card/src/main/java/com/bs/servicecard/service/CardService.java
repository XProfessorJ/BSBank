package com.bs.servicecard.service;

import com.bs.servicecard.Entity.CardEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */
public interface CardService {
    Map<String, List> getCardsByAccountId(String accountId);
}
