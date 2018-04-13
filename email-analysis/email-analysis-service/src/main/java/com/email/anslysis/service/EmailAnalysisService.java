package com.email.anslysis.service;

import java.util.List;

/**
 * 邮件地址解析服务
 */
public interface EmailAnalysisService {
    String checkAddress(String address);
    List<String> domain2MX(String domain);
}
