package io.bitflips.microservice.utils

import akka.http.scaladsl.model.HttpRequest
import akka.http.scaladsl.server.Directive0
import akka.http.scaladsl.server.directives.{LoggingMagnet, DebuggingDirectives}

trait RequestLoggingDirective extends DebuggingDirectives with Loggable {
  def logAllRequests: Directive0 = DebuggingDirectives.logRequest(LoggingMagnet(_ => logRequest))

  private def logRequest(request: HttpRequest): Unit = {
    logger.info(s"[${request.method.value}] '${request.uri.toRelative} ${request.protocol.value}'")
  }
}