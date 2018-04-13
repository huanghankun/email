package com.email.anslysis.service.impl;

import com.email.anslysis.service.EmailAnalysisService;
import org.springframework.stereotype.Component;

@Component
public class EmailAnalysisServiceImpl implements EmailAnalysisService {

    @Override
    public String checkAddress(String address) {

        return "("+address+")";
    }
}
