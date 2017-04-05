# spark-demos
Writing some Spark jobs to exercise the Spark APIs.

Some quick and dirty Spark jobs to verify that a Spark cluster is
at least partially functional. Not intended to be an exhaustive test,
many of these samples are unremarkable.

Sample usage:
$ sbt package
$  path/to/spark-submit \
    --class "org.soltren.spark.examples.ShuffleGroupCount" \
    --master local[4] \
    ./target/scala-2.11/spark-demos-by-jsoltren_2.11-0.1.jar

