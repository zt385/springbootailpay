package com.zt.ailpayspringboot.common;

public interface WorkerIdStrategy {
    void initialize();

    long availableWorkerId();

    void release();
}
