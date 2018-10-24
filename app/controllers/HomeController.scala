package controllers

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import javax.inject._
import play.api._
import play.api.mvc._
import views.WebInterface

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
//  val student = "Lucas/Bilal"
//  val game = new Game
//  val webInterface = new WebInterface(student, game)

  def index() = Action {
    Ok(views.html.index())
  }

  def start() = Action {
    Ok(views.html.twothousandfortyeight)
  }

  def action(input: Char) = Action {
    Ok(views.html.twothousandfortyeight)
  }
}
