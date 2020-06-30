package model

import model.Item
import model.Price

case class Product(id: Int, name: String, image: String, price: Price, tags: String, description: String) extends Item(id, name)