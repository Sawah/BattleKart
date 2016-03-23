var listeJoueur = ["Rayan","Wissam","Quentin","Antoine","Rudy","Arthur"];

window.onload = function(){

var canv = document.getElementById("westCanvas");
var ctx = canv.getContext('2d');
ctx.font = "20pt Algerian";
ctx.fillStyle = "rgb(0,0,255)";
ctx.fillText("Les Joueurs", 90, 60);
ctx.font = "12pt arial";
for(var i=0;i<listeJoueur.length;i++)
	ctx.fillText(listeJoueur[i],20,(80+i*12));

}