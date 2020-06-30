package controllers

import javax.inject._
import model._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class Controller @Inject()(val controllerComponents: ControllerComponents)(using ec: ExecutionContext) extends BaseController:
  type Result = ErrorModel | List[Product]