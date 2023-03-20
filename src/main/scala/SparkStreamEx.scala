import org.apache.spark._
import org.apache.spark.streaming._


object SparkStreamEx extends App {
  // start the local host n/w server by using the command : nc -lk 9999
  val conf = new SparkConf().setAppName("streamEX").setMaster("local[2]")
  val ssc = new StreamingContext(conf, Seconds(60))
  ssc.sparkContext.setLogLevel("ERROR")
  // Create a DStream that will connect to hostname:port, like localhost:9999
  val lines = ssc.socketTextStream("localhost", 9999)
  // Split each line into words
  val words = lines.flatMap(_.split(" "))
  val pairs = words.map(word => (word, 1))
  val wordCounts = pairs.reduceByKey(_ + _)
  wordCounts.print()

  ssc.start()             // Start the computation
  ssc.awaitTermination()
}
