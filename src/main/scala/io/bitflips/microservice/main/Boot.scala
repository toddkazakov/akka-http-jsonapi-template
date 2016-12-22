package io.bitflips.microservice.main

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.pulsepoint.metricsserver.data.RandomMetricsDAO
import com.pulsepoint.metricsserver.models.Channel
import com.pulsepoint.metricsserver.services.{ConcurrencyLimitedMetricsService, RandomMetricsService}
import io.bitflips.microservice.api.Api
import io.bitflips.microservice.utils.Loggable

import scala.concurrent.duration._

object Boot extends App with Loggable {
  implicit val as = ActorSystem("ActorSystem")
  implicit val ec = as.dispatcher
  implicit val mat = ActorMaterializer()

  val port = Settings.serverPort

  val api = new Api

  val server = Http().bindAndHandle(api.routes, interface = "0.0.0.0", Settings.serverPort)

  logger.info(s"Listening on port $port")
}