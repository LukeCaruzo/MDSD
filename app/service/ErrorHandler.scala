package service

import model._
import model.Error

type ErrorHandle = ErrorConverter.DisplayError {
      val header: Error
      val pos: Option[Int]
      val msg: String
} 

object ErrorConverter: 
  case class DisplayError(elems: (String, Any)*) extends Selectable:
    private val fields = elems.toMap
    def selectDynamic(name: String): Any = fields(name)

  def convertToReturnError(pos: Option[Int], msg: String, extra: String): ErrorHandle = 
    DisplayError("header" -> Error.ParserError, "pos" -> pos, "msg" -> msg).asInstanceOf[ErrorHandle]
  def converToFailureError(pos: Option[Int], msg: String, extra: String): ErrorHandle = 
    DisplayError("header" -> Error.InputError, "pos" -> pos, "msg" -> msg).asInstanceOf[ErrorHandle]
  def convertToTransformError(pos: Option[Int], msg: String = "", extra: String = ""): ErrorHandle =
    DisplayError("header" -> Error.TransformError, "pos" -> pos, "msg" -> msg).asInstanceOf[ErrorHandle]