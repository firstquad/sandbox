package com.test.aop;

import org.springframework.stereotype.Service;

/**
 * Created by DVFirstov
 */
@Service
public class AdditionServlce {

    @LogExecutionTime
    public int sum(int a, int b) {

        return a + b;
    }
}
