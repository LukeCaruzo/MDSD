package controllers

import javax.inject._
import model._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{ExecutionContext, Future}
import service._

@Singleton
class Controller @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  type ItemResult = List[Item] 

  def catalogue(): Action[String] = {
    Action.async(parse.text) { 
      request => Future.successful(Ok(views.html.catalogue(parse(request.body))))
    }
  }

  def parse(input: String): List[Item] = InputParser.inputParse(input)
}