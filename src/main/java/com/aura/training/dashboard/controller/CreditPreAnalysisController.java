package com.aura.training.dashboard.controller;

import com.aura.training.dashboard.service.CreditPreAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hadoopuser on 11/17/19.
 */
@RestController
@RequestMapping(value = "/jdcredit")
public class CreditPreAnalysisController {

    @Autowired
    CreditPreAnalysisService creditPreAnalysisService;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public ModelAndView sayHello(){

        return new ModelAndView("demo");

    }

    @RequestMapping(value = "/clickCount",method = RequestMethod.GET)
    public ModelAndView showClickCount(){
        return new ModelAndView("clickCountByPage");
    }

    @RequestMapping(value = "/consumeSum",method = RequestMethod.GET)
    public ModelAndView showConsumeSum(){
        return new ModelAndView("consumeSumByAge");
    }

    @RequestMapping(value = "/getClickResult",method = RequestMethod.GET)
    public List<String> getClickStatisticsResult(){

        return creditPreAnalysisService.getClickCountResult();
    }

    @RequestMapping(value = "/getConsumeResult",method = RequestMethod.GET)
    public List<String> getConsumeStatisticsResult(){

        return creditPreAnalysisService.getConsumeSumResult();
    }
}
