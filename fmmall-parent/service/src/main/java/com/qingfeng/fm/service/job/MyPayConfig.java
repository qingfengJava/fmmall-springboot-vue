package com.qingfeng.fm.service.job;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2021/12/25
 */
public class MyPayConfig implements WXPayConfig {

    @Override
    public String getAppID() {
        return "wx632c8f211f8122c6";
    }

    @Override
    public String getMchID() {
        return "1497984412";
    }

    @Override
    public String getKey() {
        return "sbNCm1JnevqI36LrEaxFwcaT0hkGxFnc";
    }

    @Override
    public InputStream getCertStream() {
        return null;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 0;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 0;
    }
}
