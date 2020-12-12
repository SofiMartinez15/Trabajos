class Fondo {
  int px, py;
  PImage fondo;
  Fondo() { //valores iniciales
    fondo=loadImage("piso.jpg");
  }
  void dibujarpiso() {
    imageMode(CORNER);
    image(fondo, px, py, width, height);
  }
}
