function setup() {
    canv = document.getElementById("mainCanvas");
    canv.style.width = window.innerWidth - 200;
    canv.style.height = window.innerHeight - 200;
}

function draw() {
    x = 0;
    y = 0;

    for (i = 0; i < 50; i++) {
        fill(200, 200, 200);
        ellipse();
    }
}