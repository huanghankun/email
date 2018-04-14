package com.email.anslysis.service.impl;

import com.email.anslysis.service.EmailAnalysisService;
import com.email.aop.model.AopLog;
import com.email.common.EmailUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailAnalysisServiceImpl implements EmailAnalysisService {

    @Override
    public String checkAddress(String address) {

        return "("+address+")";
    }

    @Override
    @AopLog(before = "进入domain2MX",after = "完成domain2MX",funModule = "域名解析成MX记录")
    public List<String> domain2MX(String domain) {
        try{
            System.out.println("执行domain2MX");
            return EmailUtils.domain2MX(domain);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
