//{"win":false,"lose":false,"score":{"value":4},"grid":{"random1":0.8428385304209037,"random2":0.1854348155911838,"random3":0.13083804045657776,"random4":0.794336226046478,"tiles":[{"value":0},{"value":4},{"value":0},{"value":0},{"value":0},{"value":2},{"value":0},{"value":0},{"value":0},{"value":0},{"value":0},{"value":0},{"value":0},{"value":0},{"value":0},{"value":0}]}}


function draw() {

}

function evaluate(json) {
    if(json.)
    $("#content").html(json)
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
    $("#buttonUp").click(function() { turn("/up") });
    $("#buttonDown").click(function() { turn("/down") });
    $("#buttonLeft").click(function() { turn("/left") });
    $("#buttonRight").click(function() { turn("/right") });
    $("#buttonReset").click(function() { turn("/reset") });
    $("#buttonUndo").click(function() { turn("/undo") });
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

$(document).ready(function() {
    init();
});
