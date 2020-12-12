class Llaves {
  float px, py;
  int tam;
  PImage llave;

  Llaves() { //valores iniciales
    px=random(width/40, width/1.23);
    py=random(height/12, height/1.33);
    tam=width/8;

    llave = loadImage("llave2.png");
  }

  void dibujarllave() {
    image(llave, px, py, tam, tam);
  }
}
