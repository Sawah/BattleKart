var listeJoueur = ["Rayan","Wissam","Quentin","Antoine","Rudy","Arthur"];

var listeCourse = ["Course#1","Course#2","Course#3","Course#4","Course#5"];




window.onload = function(){

var westcanv = document.getElementById("westCanvas");
var westctx = westcanv.getContext('2d');
westctx.font = "20pt Algerian";
westctx.fillStyle = "rgb(0,0,255)";
westctx.fillText("Les Joueurs", 90, 60);
westctx.font = "12pt arial";
for(var i=0;i<listeJoueur.length;i++)
	westctx.fillText(listeJoueur[i],20,(80+i*12));


var botcanv = document.getElementById("bottomCanvas");
var botctx = botcanv.getContext('2d');
botctx.font = "20pt Algerian";
botctx.fillStyle = "rgb(0,0,255)";
botctx.fillText("Les Courses", 90, 60);
botctx.font = "10pt arial";
for(var i=0;i<listeCourse.length;i++)
	botctx.fillText(listeCourse[i],20,(80+i*12));

}

document.getElementById("bottomCanvas").onclick = function(){

	alert("Vous avez selectionné une course");
	
}