// Le canvas sur le quel on va dessiner
var canvas;
var temps = 0;
var lecture = 1;

function setup() {
    canvas = createCanvas(2000, 2000);
}

function draw() {
    if (lecture === 1 && temps < 200) {
        ellipse(temps, temps, 5, 5);
        temps++;
    }
}

function mousePressed() {
    lecture = (lecture === 1) ? 0 : 1;
}