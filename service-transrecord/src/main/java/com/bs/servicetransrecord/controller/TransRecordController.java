package com.bs.servicetransrecord.controller;


import com.bs.servicetransrecord.entity.CardIdWithTokenEntity;
import com.bs.servicetransrecord.entity.TransRecordEntity;
import com.bs.servicetransrecord.service.TransRecordService;
import com.bs.servicetransrecord.utils.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TransRecordController {

    @Autowired
    TransRecordService transRecordService;

    @RequestMapping(value = "/queryTransrecords", produces = {"application/json"})
    @ResponseBody
    public PageList getTransRecordList(@RequestBody CardIdWithTokenEntity cardIdWithTokenEntity){
        int pagenum = cardIdWithTokenEntity.getPagenum();
        int pagerow = cardIdWithTokenEntity.getPagerow();

        PageList pageList = new PageList();
        if(pagenum == 0){
            pagenum = 1;
        }
        if(pagerow == 0){
            pagenum = 10;
        }
        List<TransRecordEntity> list = transRecordService.getRecordByCardIdAndPage(cardIdWithTokenEntity.getCardId(),
                pagenum, pagerow);

        int TotalRows = transRecordService.countRecordsByCardId(cardIdWithTokenEntity.getCardId());
        pageList.setPage(pagenum);
        pageList.setTotalRows(TotalRows);
        int pages = 0;

        if(TotalRows % pagerow == 0){ pages = TotalRows / pagerow;}
        else { pages = TotalRows / pagerow +1 ;}

        pageList.setPages(pages);
        pageList.setList(list);
        pageList.setTotalRows(TotalRows);

        return pageList;
    }
}
