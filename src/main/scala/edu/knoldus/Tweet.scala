package edu.knoldus

import com.typesafe.config.ConfigFactory
import twitter4j.{Twitter, TwitterFactory}
import twitter4j.conf.ConfigurationBuilder

/**
  * Created by kunal on 2/6/2017.
  */
class Tweet {
  val config = ConfigFactory.load("details.conf")

  val consumerKey = config.getString("details.secret.consumerKey")
  val consumerSecretKey = config.getString("details.secret.consumerSecretKey")
  val accessToken = config.getString("details.secret.accessToken")
  val accessTokenSecret = config.getString("details.secret.accessTokenSecret")

  println(consumerKey)
  println(accessToken)

  def tweetConfig : Twitter = {
    val configurationBuilder = new ConfigurationBuilder()
    configurationBuilder.setDebugEnabled(false)
      .setOAuthConsumerKey(consumerKey)
      .setOAuthConsumerSecret(consumerSecretKey)
      .setOAuthAccessToken(accessToken)
      .setOAuthAccessTokenSecret(accessTokenSecret)

    new TwitterFactory(configurationBuilder.build()).getInstance()

  }
}
