package edu.knoldus

import org.scalatest.FunSuite
import scala.concurrent.Await
import scala.concurrent.duration._

/**
  * Created by kunal on 2/6/2017.
  */
class TwitterFeedsTest extends FunSuite {

  val tweetFeedsObject = new TwitterFeeds

  test("Fetched Number Of Tweets") {

    assert(Await.result(tweetFeedsObject.fetchTweets, 20.second) == 100)

  }
  test("Average Retweets") {

    assert(Await.result(tweetFeedsObject.averageRetweets, 20.second) == 5)

  }
  test("Average Likes"){

    assert(Await.result(tweetFeedsObject.averageLikes,20.second)==0)

  }

}
