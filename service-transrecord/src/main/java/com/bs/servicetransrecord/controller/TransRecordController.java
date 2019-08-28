package com.bs.servicetransrecord.controller;


import com.bs.servicetransrecord.entity.CardIdWithTokenEntity;
import com.bs.servicetransrecord.entity.TransRecordEntity;
import com.bs.servicetransrecord.entity.TransRecordWithDisplayEntity;
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

    @RequestMapping(value = "/Transrecords/{cardId}/{pagenum}/{pagerow}", produces = {"application/json"})
    @ResponseBody
//    public PageList getTransRecordList(@RequestBody CardIdWithTokenEntity cardIdWithTokenEntity){
    public PageList getTransRecordList(@PathVariable("cardId") String cardId, @PathVariable("pagenum") Integer pagenum, @PathVariable("pagerow") Integer pagerow){
//        int pagenum = 0;
//        int pagerow = 0;
//        try{
//            pagenum = cardIdWithTokenEntity.getPagenum();
//            pagerow = cardIdWithTokenEntity.getPagerow();
//        } catch (Exception e) {
//            return null;
//        }



        PageList pageList = new PageList();
        if(pagenum == 0){
            pagenum = 1;
        }
        if(pagerow == 0){
            pagerow = 10;
        }
        List<TransRecordWithDisplayEntity> list = transRecordService.getRecordByCardIdAndPage(cardId, pagenum, pagerow);

        int TotalRows = transRecordService.countRecordsByCardId(cardId);
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
