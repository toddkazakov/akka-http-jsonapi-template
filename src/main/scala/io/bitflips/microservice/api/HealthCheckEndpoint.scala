package io.bitflips.microservice.api

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Directives._
import io.bitflips.microservice.api.entities.HealthCheck
import org.zalando.jsonapi.json.akka.http.AkkaHttpJsonapiSupport._

import scala.concurrent.ExecutionContext

class HealthCheckEndpoint(implicit val as: ActorSystem, implicit val ec: ExecutionContext) {
  val routes = {
    get {
      path("health-check") {
        complete {
          HealthCheck("ok")
        }
      }
    }
  }
}
