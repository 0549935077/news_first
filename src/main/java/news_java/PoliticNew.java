package news_java;

import org.apache.spark.sql.api.java.UDF1;


@RegisterUdf
public class PoliticNew implements UDF1<String,String> {

    @Override
    public String call(String word) throws Exception {
        return String.valueOf(News.getWord(word));
    }
}
