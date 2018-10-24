package views

// TODO: Delete when moved
import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.util.Utils

class WebInterface(player: String, game: GameTrait) {
  // TODO: Move this code to game.scala.html
  val initialize = "Hello " + player + ". Game started!\nUsed W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.\n\n" + game.grid.toString + "\n" + "Your Score: " + game.score.toString + "\n\n"

  def action(input: Char): String = { // TODO: Move this code to game.scala.html
    Turn.makeTurn(game, Utils.processKey(0, input), Math.random(), Math.random())

    if (game.win) {
      return "You won!"
    } else if (game.lose) {
      return "You lost!"
    } else {
      return game.grid.toString + "\nYour Score: " + game.score.toString + "\n\n"
    }
  }
}