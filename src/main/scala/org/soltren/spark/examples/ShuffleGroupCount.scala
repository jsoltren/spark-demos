/*
 * See LICENSE for licensing information.
 */

package org.soltren.spark.examples

import org.apache.spark.{SparkConf, SparkContext}

object ShuffleGroupCount {
  def main(): Long = {
    val countMax = 1e6

    val conf = new SparkConf().setAppName("ShuffleGroupCount")
    val sc = new SparkContext(conf)

    val numbers = sc.parallelize(1.toLong to countMax.toLong).cache()
    val buckets = numbers.map(x => (x%100, x)).groupByKey()

    val means = buckets.map(b => (b._1, b._2.sum/b._2.size))

    val sumMeans: Long = means.values.reduce((x,y) => (x + y))

    sumMeans
  }
}
