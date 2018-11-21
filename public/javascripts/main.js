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
            grid = grid + "<span class='tile'>" + tile + "</span>"
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

function init() {
    $.ajax({
        method: "GET",
        url: "/toJson",
        dataType: "json",

        success: function (result) {
            evaluate(result)
            clickListener()
        }
    });
}

$(document).ready(function () {
    init();
});
