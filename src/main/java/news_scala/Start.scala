package news_scala


import org.apache.spark.SparkConf
import org.apache.spark.api.java.JavaSparkContext
import org.apache.spark.sql._

object Start {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("news_first").setMaster("local[*]")
    val sc = new JavaSparkContext(conf)


    val session = SparkSession.builder.getOrCreate

    /*val dataSetNews = session.read.json("data/new1.txt")
    dataSetNews.show()*/

    val dataString1 = session.read.textFile("data/new1/new1.txt")
    dataString1.show()


    /*val c = dataString1.filter(functions.grouping(dataString1.col("value"))
        .equalTo("migrants"))

    c.show()*/


  }
}



