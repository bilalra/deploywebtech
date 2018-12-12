let app = new Vue({
    methods: {
        handleGlobalKeyDown(e) {
            turn(processKey(e.keyCode))
        }
    }
});

function processKey(keyCode) {
    switch (keyCode) {
        case 38:
            return "/up";
        case 40:
            return "/down";
        case 37:
            return "/left";
        case 39:
            return "/right";
        case 173:
            return "/undo";
        case 190:
            return "/reset";
        default:
            return null;
    }
}

window.addEventListener('keydown', function (e) {
    app.handleGlobalKeyDown(e)
}, false);