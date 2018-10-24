package controllers

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import javax.inject._
import play.api._
import play.api.mvc._
import views.WebInterface

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  val game = new Game

  def index() = Action {
    Ok(views.html.index())
  }

  def start() = Action {
    Ok(views.html.twothousandfortyeight(game))
  }

  def action(input: Char) = Action {
    Ok(views.html.twothousandfortyeight(game))
  }
}
