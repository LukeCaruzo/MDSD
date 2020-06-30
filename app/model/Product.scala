package model

import model.Item

case class Product(id: Int, name: String, image: String, price: Int, tags: String, description: String) extends Item(id, name)