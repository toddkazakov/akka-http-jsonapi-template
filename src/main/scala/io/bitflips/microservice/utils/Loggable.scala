package io.bitflips.microservice.utils

import org.slf4j.LoggerFactory

trait Loggable {
  def logger = LoggerFactory.getLogger(this.getClass)

}
