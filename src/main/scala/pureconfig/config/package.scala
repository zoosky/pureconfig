package pureconfig

import com.typesafe.config.{ ConfigObject, ConfigValue }
import pureconfig.error.KeyNotFoundException

import scala.util.{ Failure, Success, Try }

package object config {
  private[pureconfig] def lookupKey(key: String, configObject: ConfigObject): Try[ConfigValue] =
    Option(configObject.get(key)) match {
      case None => Failure(KeyNotFoundException(key))
      case Some(configValue) => Success(configValue)
    }
}