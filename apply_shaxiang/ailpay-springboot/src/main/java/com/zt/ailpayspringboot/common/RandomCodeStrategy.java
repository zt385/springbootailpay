package com.zt.ailpayspringboot.common;

public interface RandomCodeStrategy {
    void init();

    int prefix();

    int next();

    void release();
}
