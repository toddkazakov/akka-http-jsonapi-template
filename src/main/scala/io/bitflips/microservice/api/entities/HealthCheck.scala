package io.bitflips.microservice.api.entities

import org.zalando.jsonapi.JsonapiRootObjectWriter
import org.zalando.jsonapi.model.JsonApiObject.StringValue
import org.zalando.jsonapi.model.RootObject.ResourceObject
import org.zalando.jsonapi.model.{RootObject, Attribute, Links}

case class HealthCheck(status: String)

object HealthCheck {
  private val HealthCheckIdAndType = "health-check"
  implicit val healthCheckJsonapiWriter = new JsonapiRootObjectWriter[HealthCheck] {
    override def toJsonapi(healthCheck: HealthCheck) = {
      RootObject(data = Some(ResourceObject(
        `type` = HealthCheckIdAndType,
        id = Some(HealthCheckIdAndType),
        attributes = Some(List(
          Attribute("status", StringValue(healthCheck.status))
        )), links = Some(List(Links.Self("/health-check", None)))
      )))
    }
  }
}
