package com.qingfeng.api.config;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.InputStream;

/**
 * @author 清风学Java
 * @version 1.0.0
 * @date 2022/2/22
 */
public class MyPayConfig implements WXPayConfig {
    @Override
    public String getAppID() {
        return null;
    }

    @Override
    public String getMchID() {
        return null;
    }

    @Override
    public String getKey() {
        return null;
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
