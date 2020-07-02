import service.InputParser

val parseTest = InputParser.inputParse("""
|catalogue 0 Bekleidung
|product 0 T-Shirt /path/to/image 99 checked tshirt
|product 0 Hemd /path/to/image 99 striped hemd
|""".stripMargin)