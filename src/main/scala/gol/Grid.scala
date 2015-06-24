package gol

case class Grid(cells: Set[Cell]) {
  def next: Grid = {
    val newCells = neighbours.filter { cell =>
      val liveNeighbours = cell.neighbours & cells
      liveNeighbours.size == 3
    }

    val deadCells = cells.filter { cell =>
      val liveNeighbours = cell.neighbours & cells
      liveNeighbours.size < 2 || liveNeighbours.size > 3
    }

    Grid(
      cells ++ newCells -- deadCells
    )
  }

  def neighbours: Set[Cell] = {
    for {
      cell <- cells
      neighbour <- cell.neighbours
      if !cells.contains(neighbour)
    } yield neighbour
  }
}
