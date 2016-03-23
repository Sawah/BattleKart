// Le canvas sur lequel on va dessiner
var canvas;
var tempsX = 300;
var tempsY = 300;
var lecture = 1;
var img;
var passe = false;

function preload() {
    img = loadImage("circuit.png");
}


function setup() {
    canvas = createCanvas(img.width, img.height);
    image(img, 0, 0, img.width, img.height)
}

function draw() {
    if (lecture === 1 ) {
    	if(tempsX < 1700 && passe==false){
        ellipse(tempsX, tempsY, 5, 5);
        tempsX+=2;
    	}
    	else{
    	passe=false;
    	ellipse(tempsX, tempsY, 5, 5);
        tempsY+=2;
    	}

    	if(tempsY >1700 && tempsY >400){
    		passe=true;
	    	ellipse(tempsX, tempsY, 5, 5);
	       	tempsX-=2;
    	}
    }
}

function mousePressed() {
    lecture = (lecture === 1) ? 0 : 1;
}