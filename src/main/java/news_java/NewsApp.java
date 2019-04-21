package news_java;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;

public class NewsApp {



    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("news_first");


        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);



        Dataset<Row> dataString1 = sqlContext.read().json("data/news/*.json");
        dataString1.show();


    }
}

   /* SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("linked in");
    JavaSparkContext sc = new JavaSparkContext(conf);
    SQLContext sqlContext = new SQLContext(sc);
    Dataset<Row> dataFrame = sqlContext.read().json("data/linkedIn/*.json");
        dataFrame.show();
    */

