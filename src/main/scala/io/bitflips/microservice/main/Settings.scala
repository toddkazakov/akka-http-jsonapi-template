package io.bitflips.microservice.main

import com.typesafe.config.ConfigFactory

object Settings {
  private val config = ConfigFactory.load()

  lazy val serverPort = config.getInt("service.port")
}