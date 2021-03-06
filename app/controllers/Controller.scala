package controllers

import javax.inject._
import model._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{ExecutionContext, Future}
import service._
import service.Transformer

@Singleton
class Controller @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  type ItemResult = Either[ErrorModel, List[Item]]

  def catalogue(): Action[String] = {
    Action.async(parse.text) { 
      request => transform(parse(request.body)) match {
        case Right(items) => Future.successful(Ok(views.html.catalogue(items)))
        case Left(error) => Future.successful(Ok(views.html.error(error)))
      }
    }
  }

  def transform(input: ItemResult): ItemResult = Transformer(input)

  def parse(input: String): ItemResult = InputParser.inputParse(input)
}