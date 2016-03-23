var canvas;

function setup() {
    canvas = createCanvas(2000, 2000);
}

function draw() {
    x = 0;
    y = 0;

    for (i = 0; i < 1200; i++) {
        fill(200, 200, 200);
        ellipse(x, y, 5, 5);
        x++;
        y++;
    }

    ellipse(0, 0, 50, 50);
}