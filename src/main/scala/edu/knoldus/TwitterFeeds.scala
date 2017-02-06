package edu.knoldus

import twitter4j._

import scala.collection.JavaConverters._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class TwitterFeeds {

  val tweetObj = new Tweet
  val twitter: twitter4j.Twitter = tweetObj.tweetConfig
  val query = new Query("#Scala")
  val count = 100

  @throws(classOf[TwitterException])
  def fetchTweets: Future[Int] = Future {

    //fetching all tweets

    query.setSince("2016-06-06")
    query.setCount(count)
    val list = twitter.search(query)
    val tweets = list.getTweets.asScala.toList
    println(tweets)
    tweets.length
  }

  def averageRetweets: Future[Int] = Future {

      //finding the average of retweets
    query.setCount(count)
    query.setSince("2016-05-09")
    val list = twitter.search(query)
    val tweets = list.getTweets.asScala.toList
    val res = tweets.map(_.getRetweetCount)
    val res1 = res.sum
    val finalAvg = res1 / count
    finalAvg
  }

  def averageLikes: Future[Int] = Future {

    //finding the average likes
    query.setCount(count)
    query.setSince("2015-05-10")
    val list = twitter.search(query)
    val tweets = list.getTweets.asScala.toList
    val res = tweets.map(_.getFavoriteCount)
    val res1 = res.fold(0)(_ + _)
    val finalAvg = res1 / count
    finalAvg
  }

}
