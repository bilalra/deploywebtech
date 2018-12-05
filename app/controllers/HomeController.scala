package controllers

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.stream.Materializer
import com.google.gson.Gson
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.controller.TurnMade
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import javax.inject._
import play.api.libs.streams.ActorFlow
import play.api.mvc._

import scala.swing.Reactor

@Singleton
class HomeController @Inject()(cc: ControllerComponents)(implicit system: ActorSystem, mat: Materializer) extends AbstractController(cc) {
  val game = new Game
  val turn = new Turn
  val gson = new Gson

  def index() = Action {
    Ok(views.html.index())
  }

  def start() = Action {
    turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey('r'), Math.random(), Math.random())

    Ok(views.html.game())
  }

  def up() = Action {
    turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey('w'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def down() = Action {
    turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey('s'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def left() = Action {
    turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey('a'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def right() = Action {
    turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey('d'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def reset() = Action {
    turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey('r'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def undo() = Action {
    turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey('q'), Math.random(), Math.random())

    Ok(gson.toJson(game))
  }

  def gameToJsonAjax() = Action {
    Ok(gson.toJson(game))
  }

  def gameToJsonWebSocket() = WebSocket.accept[String, String] { request =>
    ActorFlow.actorRef { out =>
      println("Connect received")
      WebSocketActorFactory.create(out)
    }
  }

  object WebSocketActorFactory {
    def create(out: ActorRef) = {
      Props(new WebSocketActor(out))
    }
  }

  class WebSocketActor(out: ActorRef) extends Actor with Reactor {
    listenTo(turn)

    out ! (gson.toJson(game))

    reactions += {
      case event: TurnMade => sendJsonToClient
    }

    def sendJsonToClient = {
      println("Received event from Controller")
      out ! (gson.toJson(game))
      println("Sent Json to Client")
    }

    def receive = {
      case msg: String => {
        println("Got message from Client: " + msg)
      }
    }
  }
}
