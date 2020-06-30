package model

import model.CatalogueTrait

case class Catalogue(id: Int, name: String, products : List[Product]) extends CatalogueTrait(id, name)
