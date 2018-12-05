package controllers

import akka.actor.{Actor, ActorRef, Props}
import com.google.gson.Gson
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import javax.inject._
import play.api.libs.streams.ActorFlow
import play.api.mvc._

import scala.swing.Reactor

@Singleton
class HomeController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  val game = new Game
  val gson = new Gson

  def index() = Action {
    Ok(views.html.index())
  }

  def start() = Action {
    de.htwg.se.twothousandfortyeight.controller.Turn.makeTurn(game, de.htwg.se.twothousandfortyeight.util.Utils.processKey(82, 'r'), Math.random(), Math.random())

    Ok(views.html.game())
  }

  def gameToJsonAjax() = Action {
    Ok(gson.toJson(game))
  }

//  // TODO: Finish this mess
//  def gameToJsonWebSocket() = WebSocket.accept[String, String] {
//    request {
//      ActorFlow.actorRef { out =>
//        println("Connect received")
//        WebSocketActorFactory.create(out)
//      }
//    }
//
//    object WebSocketActorFactory {
//      def create(out: ActorRef) = {
//        Props(new WebSocketActor(out))
//      }
//    }
//
//    class WebSocketActor(out: ActorRef) extends Actor with Reactor {
//      listenTo(gameController)
//
//      def receive = {
//        case msg: String =>
//          out ! (gameController.toJson.toString)
//          println("Sent Json to Client" + msg)
//      }
//
//      reactions += {
//        case event: GridSizeChanged => sendJsonToClient
//        case event: CellChanged => sendJsonToClient
//        case event: CandidatesChanged => sendJsonToClient
//      }
//
//      def sendJsonToClient = {
//        println("Received event from Controller")
//        out ! (gameController.toJson.toString)
//      }
//    }
//  }

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
