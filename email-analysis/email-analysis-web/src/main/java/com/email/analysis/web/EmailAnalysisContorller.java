package com.email.analysis.web;

import com.email.anslysis.service.EmailAnalysisService;
import com.email.common.ResponseResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Logger;

/**
 * 邮件地址解析服务
 */
@RestController
@RequestMapping(value = "analysis")
public class EmailAnalysisContorller {

    @Resource
    private EmailAnalysisService emailAnalysisService;
    @RequestMapping(value = "/get/{address}",method = RequestMethod.GET)
    public ResponseResult<String> get(@PathVariable String address){
        try{
            return ResponseResult.createFailResult("解析成功",emailAnalysisService.checkAddress(address));
        }catch (Exception e){
            return ResponseResult.createFailResult(e.getMessage(),null);
        }
    }
    @RequestMapping(value = "/domain2MX/{domain}",method = RequestMethod.GET)
    public ResponseResult<List<String>> domain2MX(@PathVariable String domain){
        try{
            return ResponseResult.createFailResult("解析成功",emailAnalysisService.domain2MX(domain));
        }catch (Exception e){
            return ResponseResult.createFailResult(e.getMessage(),null);
        }
    }

}

