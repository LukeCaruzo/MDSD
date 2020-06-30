package controllers

import javax.inject._
import model._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{ExecutionContext, Future}
import service._

@Singleton
class Controller @Inject()(val controllerComponents: ControllerComponents)(using ec: ExecutionContext) extends BaseController:
  type ItemResult = List[Item]

  def (input: String).parse: ItemResult = InputParser.inputParse(input)

  //def (input: ItemResult).transform: Either[List[Item], List[Error]] = ItemTransformer(input)

  def index(): Action[String] = 
    Action.async(parse.text) { 
          request => Future.successful(Ok(views.html.catalogue(request.body.parse)))
    }