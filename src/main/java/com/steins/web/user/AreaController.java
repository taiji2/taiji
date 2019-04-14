package com.steins.web.user;

import com.steins.entity.Area;
import com.steins.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/1/22.
 */
@Controller
@RequestMapping("/area")
public class AreaController {
    Logger logger= LoggerFactory.getLogger(AreaController.class);
    @Autowired
    private AreaService areaService;
    @ResponseBody
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){
        logger.info("==start==");
        long startTime=System.currentTimeMillis();
       Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Area> list=new ArrayList<>();
        try{
            list=areaService.getAreaList();
        modelMap.put("rows",list);
            modelMap.put("sucess",true);
            modelMap.put("total",list.size());

        }catch (Exception ex){
            ex.printStackTrace();
            modelMap.put("errMsg", ex.toString());
        }
        logger.error("test error!");
        long endTime=System.currentTimeMillis();
        logger.debug("costTime:[{}]",endTime-startTime);
        logger.info("==end==");
        return modelMap;
       }


}
