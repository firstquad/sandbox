package com.firstquad.sandbox.spark;

import org.apache.spark.api.java.function.FilterFunction;
import org.apache.spark.sql.Row;
import org.apache.spark.util.sketch.BloomFilter;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class FilterFunctionCustom implements FilterFunction {

    BloomFilter bf;

    public FilterFunctionCustom(BloomFilter bf) {
        this.bf = bf;
    }

    @Override
    public boolean call(Object value) throws Exception {
        Row value1 = (Row) value;
        Object item = value1.get(0);
        return bf.mightContainString((String) item);
    }
}
