package controllers

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  val game = new Game

  def index() = Action {
    Ok(views.html.index())
  }

  def start() = Action {
    Ok(views.html.game(game, ' '))
  }

  def action(input: Char) = Action {
    Ok(views.html.game(game, input))
  }
}
