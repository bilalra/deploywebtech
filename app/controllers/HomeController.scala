package controllers

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import javax.inject._
import play.api.mvc._
import com.google.gson.Gson

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  val game = new Game
  val gson = new Gson

  def index() = Action {
    Ok(views.html.index())
  }

  def newGame() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(81, 'q'), Math.random(), Math.random())

    Ok(views.html.game())
  }

  def up() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(87, 'w'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def down() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(83, 's'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def left() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(65, 'a'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def right() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(68, 'd'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def reset() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(82, 'r'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def undo() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(81, 'q'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }
}
