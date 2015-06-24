package gol

case class Cell(x: Int, y: Int) {
  def neighbours: Set[Cell] = {
    for {
      newX <- Set(x-1, x, x+1)
      newY <- Set(y-1, y, y+1)
      if (newX, newY) != (x, y)
    } yield Cell(newX, newY)
  }
}
