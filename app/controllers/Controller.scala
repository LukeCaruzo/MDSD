package controllers

import javax.inject._
import model._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.concurrent.{ExecutionContext, Future}
import service._
import service.ErrorHandle

@Singleton
class Controller @Inject()(val controllerComponents: ControllerComponents)(using ec: ExecutionContext) extends BaseController:
  type CatalogueResult = ErrorHandle | List[Item]

  def (input: String).parse: CatalogueResult = InputParser.inputParse(input)

  def (input: CatalogueResult).transform: Either[List[Product], List[ErrorHandle]] = CatalogueTransformer(input)

  def index(): Action[String] = 
    Action.async(parse.text) { 
          request => request.body.parse.transform match
                case Left(catalogue) => Future.successful(Ok(views.html.products(catalogue)))
                case Right(error) => Future.successful(BadRequest(views.html.error(error)))
    }