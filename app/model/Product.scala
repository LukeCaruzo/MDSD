package model

import model.CatalogueTrait

case class Product(id: Int, name: String) extends CatalogueTrait(id, name)