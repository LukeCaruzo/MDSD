package service

import scala.util.parsing.combinator._
import model._

object InputParser extends Parser {
  def inputParse(input: String): Either[ErrorModel, List[Item]] =
    parseAll(catalogueParser, input) match {
      case Success(matched, _) => Right(matched)
      case NoSuccess(msg, next) =>
        val pos = next.pos
        Left(ErrorModel(pos.line, msg, pos.longString))
    }
}

class Parser extends RegexParsers {
  //basic types
  private def text: Parser[String] = """[^\v\s\d]+""".r ^^ (_.toString)
  private def integer: Parser[Int] = """(0|[1-9]\d*)""".r ^^ (_.toInt)

  //item parameters
  private def id: Parser[Int] = integer
  private def name: Parser[String] = text
  private def image: Parser[String] = text
  private def price: Parser[Int] = integer
  private def tags: Parser[String] = text
  private def description: Parser[String] = text

  //item creator
  private def product: Parser[Product] =
    id ~ name ~ image ~ price ~ tags ~ description ^^ { case i ~ n ~ j ~ p ~ t ~ d => Product(i, n, j, p, t, d) }

  private def catalogue: Parser[Catalogue] =
    id ~ name ^^ { case id ~ n => Catalogue(id, n, List()) }

  //item identifier
  private def productIdentifier: Parser[Product] = "product" ~> product

  private def catalogueIdentifier: Parser[Catalogue] = "catalogue" ~> catalogue

  //item matcher
  private def item: Parser[Item] = productIdentifier

  private def itemStructureIdentifier: Parser[Catalogue] =
    catalogueIdentifier ~ rep1(item) ^^ { case c ~ i => c.copy(items = i) }

  def catalogueParser: Parser[List[Item]] = rep1(itemStructureIdentifier)
}
