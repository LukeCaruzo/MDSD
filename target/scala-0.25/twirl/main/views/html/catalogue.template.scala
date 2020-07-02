
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._
import model._

object catalogue extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[List[Item],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(items: List[Item]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {
/*2.2*/import model._

def /*4.2*/product/*4.9*/(p: Product):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*4.25*/("""
    """),format.raw/*5.5*/("""<p>"Product: """),_display_(/*5.19*/p/*5.20*/.id),format.raw/*5.23*/(""""</p>
""")))};def /*8.2*/displayCatalogue/*8.18*/(c: Catalogue):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*8.36*/("""
    """),format.raw/*9.5*/("""<h1>"""),_display_(/*9.10*/c/*9.11*/.name),format.raw/*9.16*/("""</h1>
    """),_display_(/*10.6*/for(item <- c.items) yield /*10.26*/ {_display_(Seq[Any](format.raw/*10.28*/("""
        """),_display_(/*11.10*/displayItem(item)),format.raw/*11.27*/("""
    """)))}),format.raw/*12.6*/("""
""")))};def /*15.2*/displayItem/*15.13*/(item: Item):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*15.29*/("""
    """),_display_(/*16.6*/if(item.isInstanceOf[Product])/*16.36*/{_display_(Seq[Any](format.raw/*16.37*/("""
        """),_display_(/*17.10*/product(item.asInstanceOf[Product])),format.raw/*17.45*/("""
    """)))}/*18.7*/else if(item.isInstanceOf[Catalogue])/*18.44*/ {_display_(Seq[Any](format.raw/*18.46*/("""
        """),_display_(/*19.10*/displayCatalogue(item.asInstanceOf[Catalogue])),format.raw/*19.56*/("""
    """)))}),format.raw/*20.6*/("""
""")))};
Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*6.2*/("""

"""),format.raw/*13.2*/("""

"""),format.raw/*21.2*/("""

"""),_display_(/*23.2*/main("Auto generated items")/*23.30*/ {_display_(Seq[Any](format.raw/*23.32*/("""
    """),_display_(/*24.6*/for(item <- items) yield /*24.24*/ {_display_(Seq[Any](format.raw/*24.26*/("""
        """),_display_(/*25.10*/if(item.isInstanceOf[Catalogue])/*25.42*/ {_display_(Seq[Any](format.raw/*25.44*/("""
            """),_display_(/*26.14*/displayCatalogue(item.asInstanceOf[Catalogue])),format.raw/*26.60*/("""
        """)))}/*27.11*/else/*27.16*/{_display_(Seq[Any](format.raw/*27.17*/("""
            """),_display_(/*28.14*/displayItem(item)),format.raw/*28.31*/("""
        """)))}),format.raw/*29.10*/("""
    """)))}),format.raw/*30.6*/("""
""")))}))
      }
    }
  }

  def render(items:List[Item]): play.twirl.api.HtmlFormat.Appendable = apply(items)

  def f:((List[Item]) => play.twirl.api.HtmlFormat.Appendable) = (items) => apply(items)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: 2020-06-30T11:46:30.822451
                  SOURCE: /Users/lucas/Documents/HTWG/Master/MDSD/MDSD/app/views/catalogue.scala.html
                  HASH: af7620f393f4d3134c8dd3b7c2ad0b0dcc20a7ca
                  MATRIX: 752->1|844->22|871->39|885->46|977->62|1008->67|1048->81|1057->82|1080->85|1109->95|1133->111|1227->129|1258->134|1289->139|1298->140|1323->145|1360->156|1396->176|1436->178|1473->188|1511->205|1547->211|1572->216|1592->227|1685->243|1717->249|1756->279|1795->280|1832->290|1888->325|1912->332|1958->369|1998->371|2035->381|2102->427|2138->433|2178->37|2205->92|2234->213|2263->435|2292->438|2329->466|2369->468|2401->474|2435->492|2475->494|2512->504|2553->536|2593->538|2634->552|2701->598|2730->609|2743->614|2782->615|2823->629|2861->646|2902->656|2938->662
                  LINES: 22->1|25->2|27->4|27->4|29->4|30->5|30->5|30->5|30->5|31->8|31->8|33->8|34->9|34->9|34->9|34->9|35->10|35->10|35->10|36->11|36->11|37->12|38->15|38->15|40->15|41->16|41->16|41->16|42->17|42->17|43->18|43->18|43->18|44->19|44->19|45->20|47->3|48->6|50->13|52->21|54->23|54->23|54->23|55->24|55->24|55->24|56->25|56->25|56->25|57->26|57->26|58->27|58->27|58->27|59->28|59->28|60->29|61->30
                  -- GENERATED --
              */
          