Aventura aventura;
import processing.sound.*;
SoundFile sonido;
String estado; //variable global
void setup() {
  size(800, 600);
  surface.setResizable(true);
  aventura = new Aventura();
  estado="presentacion";
  sonido = new SoundFile(this, "ambiente.mp3");
  sonido.loop();
  sonido = new SoundFile(this, "ratas.mp3");
}
void draw() {
  aventura.dibujar();
  if (estado=="llaves2"&&keyCode==ENTER) { //empieza en el juego
    sonido.loop();
  }
  if (estado=="Final1") {
    sonido.pause();
  }
}
void keyPressed() {
  aventura.presionar();
  aventura.presionar2();
}
void mousePressed() {
  aventura.clickear();
}
