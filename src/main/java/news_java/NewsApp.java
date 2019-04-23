package news_java;

import lombok.Getter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

import static java.util.Arrays.asList;
import static org.apache.spark.sql.functions.*;

public class NewsApp<column> {

    private static final String MEDIA = "media";
    private static final String AUTHOR = "author";
    private static final String TOPIC = "topic";
    private static final String WORDS = "words";
    private static final String POLITIC_WORDS = "politic_words";
    @Getter
    private List<String> garbage;

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("news_first");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        sqlContext.udf().register(PoliticNew.class.getName(),new PoliticNew(),
                DataTypes.StringType);
        Dataset<Row> dataString1 = sqlContext.read().json("data/news/news.json");
        dataString1.show();


        Dataset<Row> dataString2 = dataString1.withColumn(POLITIC_WORDS,col(WORDS)
        .multiply(WORDS));
        dataString2.show();
        dataString2.withColumn("News",callUDF(PoliticNew.class.getName(),
                col(WORDS))).show();
    }
    @Value("${garbage}")
    public void setGarbage(String[] garbage) {
        this.garbage = asList(garbage);
    }
}


