package io.bitflips.microservice.api

import akka.actor.ActorSystem
import akka.http.scaladsl.server.{RouteConcatenation, Route}
import com.pulsepoint.metricsserver.models.Channel
import com.pulsepoint.metricsserver.services.{ConcurrencyLimiter, MetricsService}
import io.bitflips.microservice.utils.RequestLoggingDirective
import scala.concurrent.ExecutionContext

class Api(implicit val as: ActorSystem, implicit val ec: ExecutionContext)
    extends RouteConcatenation with RequestLoggingDirective {

  private[this] val healthCheckEndpoint = new HealthCheckEndpoint

  val routes = Route.seal {
    logAllRequests {
      healthCheckEndpoint.routes
    }
  }
}
