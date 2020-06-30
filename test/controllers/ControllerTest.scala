package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.ResultExtractors
import play.api.test.Helpers._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.{ RequestHeader, Result }
import org.junit.Test
import org.junit.Assert._

import scala.concurrent.Future
/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class ControllerTest extends PlaySpec with GuiceOneAppPerTest {
  val example = """
  |catalogue 0 Bekleidung 
  |product 0 T-Shirt /path/to/image 99 checked tshirt
  |product 0 Hemd /path/to/image 99 striped hemd
  |""".stripMargin

  @Test def test(): Unit = {
    given ec as scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
    val controller = new Controller(stubControllerComponents())
    val request = FakeRequest(POST, "/").withHeaders(HOST -> "localhost:9000").withBody(example)
    val home:Future[Result] = route(app, request).get

    assertEquals(status(home),OK)
  }
}
