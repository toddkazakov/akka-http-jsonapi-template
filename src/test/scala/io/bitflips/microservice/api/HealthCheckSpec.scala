package io.bitflips.microservice.api

import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.testkit.ScalatestRouteTest
import org.scalatest.{FlatSpec, Matchers}

class HealthCheckSpec extends FlatSpec with Matchers with ScalatestRouteTest {
  private val healthCheck = new HealthCheckEndpoint()

  it should "handle health check route" in {
    Get("/health-check") ~> healthCheck.routes ~> check {
      status shouldBe StatusCodes.OK
    }
  }
}
