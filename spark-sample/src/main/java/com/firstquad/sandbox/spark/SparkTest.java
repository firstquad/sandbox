package com.firstquad.sandbox.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.sql.*;
import org.apache.spark.util.sketch.BloomFilter;

/**
 * Created by DVFirstov
 */
public class SparkTest {


    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local[*]");
        sparkConf.setAppName("test");
        sparkConf.set("spark.driver.bindAddress", "127.0.0.1");

        SparkContext sc = new SparkContext(sparkConf);
        SparkSession sparkSession = new SparkSession(sc);

        SQLContext sqlContext = new SQLContext(sparkSession);

        Dataset<Row> csv = sqlContext
                .read()
//                .option("header", "true")
                .parquet("/Users/dmitriy/work/java/project/sandbox/spark-out");

//        csv.show();


        BloomFilter bf = csv.stat().bloomFilter("id", 3000, 0.05);
        bf.put("1");

        Dataset res = csv.filter(new Column("name").equalTo("1"));
//        Dataset res = csv.filter(new FilterFunctionCustom(bf));

        res.select("*").explain();


//        csv
//                .repartition(10)
//                .coalesce(10)
//                .write()
//                .partitionBy("name")
//                .parquet("spark-out");
    }
}
