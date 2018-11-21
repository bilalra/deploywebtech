function turn(action) {
    $.ajax({
        method: "GET",
        url: action,
        dataType: "json",

        success: function (result) {
            $(".content").html(result)
        }
    });
}

function clickListener() {
    $("buttonUp").click(function() { turn("/up") });
    $("buttonDown").click(function() { turn("/down") });
    $("buttonLeft").click(function() { turn("/left") });
    $("buttonRight").click(function() { turn("/right") });
    $("buttonReset").click(function() { turn("/reset") });
    $("buttonUndo").click(function() { turn("/undo") });
}