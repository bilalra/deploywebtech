function draw(json) {
    var intro = "<div class='intro'>Hello Player.</div>"
    var tiles = json.grid.tiles
    var grid = "<div class='grid'><div>"
    for (i = 0; i < Math.sqrt(tiles.length); i++) {
        grid = grid + "<div>"
        for (j = 0; j < Math.sqrt(tiles.length); j++) {
            var tile = tiles[Math.sqrt(tiles.length) * i + j].value

            if(tile == 0) {
                tile = "-"
            }
            grid = grid + "<div class='tile'>" + tile + "</div>"
        }
        grid = grid + "</div>"
    }
    grid = grid + "</div>"

    var score = "<div class='score'>Score: " + json.score.value + "</div>"

    var html = intro + "<br>" + grid + "<br>" + score

    $("#content").html(html)
    $("#buttons").show()
}

function evaluate(json) {
    if (json.win) {
        $("#content").html("<div class='win'>GAME WON!</div>")
        $("#buttons").hide()
    } else if (json.lose) {
        $("#content").html("<div class='lose'>GAME OVER!</div>")
        $("#buttons").hide()
    } else {
        draw(json)
    }
}

function turn(action) {
    $.ajax({
        method: "GET",
        url: action,
        dataType: "json",

        success: function (result) {
            evaluate(result)
        }
    });
}

function clickListener() {
    $("#buttonUp").click(function () {
        turn("/up")
    });
    $("#buttonDown").click(function () {
        turn("/down")
    });
    $("#buttonLeft").click(function () {
        turn("/left")
    });
    $("#buttonRight").click(function () {
        turn("/right")
    });
    $("#buttonReset").click(function () {
        turn("/reset")
    });
    $("#buttonUndo").click(function () {
        turn("/undo")
    });
}

function ajax() {
    $.ajax({
        method: "GET",
        url: "/toJsonAjax",
        dataType: "json",

        success: function (result) {
            evaluate(result)
            clickListener()
        }
    });
}

function webSocket() {
    var websocket = new WebSocket("ws://localhost:9000/toJsonWebSocket");
    websocket.setTimeout

    websocket.onopen = function (event) {
        console.log("Connected to Websocket");
        clickListener()
    }

    websocket.onclose = function () {
        console.log('Connection with Websocket Closed!');
    };

    websocket.onerror = function (error) {
        console.log('Error in Websocket Occured: ' + error);
    };

    websocket.onmessage = function (result) {
        console.log('Got a message!')
        evaluate(JSON.parse(result.data))
    };
}

$(document).ready(function () {
    console.log("Document is ready!");
    //ajax();
    webSocket();
});
