package com.bs.servicecard.dao;

import com.bs.servicecard.Entity.CardEntity;

import java.util.List;
import java.util.Map;

/**
 * @author Leo Wang
 * @date 2019/8/28
 */
public interface CardDao {
    Map<String, List> getCardsByAccountId(String accountId);
}
