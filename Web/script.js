// Le canvas sur lequel on va dessiner
var canvas;
var temps = 0;
var lecture = 1;
var img;

function preload() {
    img = loadImage("circuit.png");
}


function setup() {
    canvas = createCanvas(img.width, img.height);
}

function draw() {
    if (lecture === 1 && temps < 200) {
        image(img, 0, 0, img.width, img.height)
        ellipse(temps, temps, 5, 5);
        temps++;
    }
}

function mousePressed() {
    lecture = (lecture === 1) ? 0 : 1;
}