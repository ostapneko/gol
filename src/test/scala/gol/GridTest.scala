package gol

import org.scalatest.FreeSpec

class GridTest extends FreeSpec {
  "neighbours" - {
    "returns the neighbouring cells excluding the ones already included in the grid" in {
      val grid = Grid(Set(Cell(0,0), Cell(1,0)))

      assertResult(
        Set(
          Cell(-1, 1),
          Cell(-1, 0),
          Cell(-1, -1),
          Cell(0, 1),
          Cell(0, -1),
          Cell(1, 1),
          Cell(1, -1),
          Cell(2, 1),
          Cell(2, 0),
          Cell(2, -1)
        )
      )(grid.neighbours)
    }
  }

  "next" - {
    val grid = Grid(Set(Cell(0,0), Cell(1,0), Cell(2,0)))

    "returns a new grid" - {
      "with new cells" in {
        assert(grid.next.cells.contains(Cell(1, 1)))
        assert(grid.next.cells.contains(Cell(1, -1)))
      }

      "without cells with 0 or 1 neighbours" in {
        assert(!grid.next.cells.contains(Cell(0, 0)))
        assert(!grid.next.cells.contains(Cell(2, 0)))
      }

      "whithout cells with more 4 or more neighbours" in {
        val grid = Grid(
          Set(
            Cell(0, 0),
            Cell(1, 0),
            Cell(2, 0),
            Cell(1, 1),
            Cell(1, -1)
          )
        )

        assert(!grid.next.cells.contains(Cell(1, 0)))
      }
    }
  }
}
