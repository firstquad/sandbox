package com.firstquad.sandbox.concurrency.synchronizing;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public interface Shared {

    int getValue();

    void increment();

    void decrement();

    void loop();
}
