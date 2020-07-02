package model

case class Catalogue(id: Int, name: String, items: List[Item]) extends Item(id, name)
