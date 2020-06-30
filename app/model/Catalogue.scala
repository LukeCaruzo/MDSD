package model

import model.Item

case class Catalogue(id: Int, name: String, products : List[Item]) extends Item(id, name)
