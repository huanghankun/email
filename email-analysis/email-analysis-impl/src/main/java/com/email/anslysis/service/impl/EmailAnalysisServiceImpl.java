package com.email.anslysis.service.impl;

import com.email.anslysis.service.EmailAnalysisService;
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
    public List<String> domain2MX(String domain) {
        try{
            return EmailUtils.domain2MX(domain);
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
