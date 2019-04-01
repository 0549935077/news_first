package news_java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class NewsApp {



    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("news_first")
                .setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);



        Dataset<String> dataString1 = sqlContext.read().textFile("data/new1/new1.txt");
        dataString1.show();


    }
}



