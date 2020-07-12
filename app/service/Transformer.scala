package service

import model.{ErrorModel, Item}


object Transformer {
  def apply(result: Either[ErrorModel, List[Item]]): Either[ErrorModel, List[Item]] = {
    for {
      parsed <- result
      item <- validateItems(parsed)
    } yield {
      item
    }
  }

  def validateItems(items: List[Item]): Either[ErrorModel, List[Item]] = {
    if(items.isEmpty) {
       Left(new ErrorModel(0, "There are no Items", "no items"))
    } else {
      Right(items)
    }
  }
}
