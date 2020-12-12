class Mano {
  float px, py;
  int tam;
  PImage negro, mano;
  Boolean agarre, sombra;

  Mano() { //constructor-valores iniciales
    px= width/2;
    py= height/2;
    tam=width/10;
    negro=loadImage("oscuro.png");
    mano=loadImage("mano.png");
    sombra=true; // cuando es true la imagen aparece
  }

  void dibujarmano() {
    image(mano, px, py, tam, tam*2);
  }
  void dibujaroscuridad() {
    if (sombra) {
      imageMode(CENTER);
      image(negro, px, py);
    }
  }

  void mover(int tecla) {
    if (tecla==LEFT) {
      px -= 8;
    }
    if (tecla==RIGHT) {
      px += 8;
    }
    if (tecla==UP) {
      py -= 8;
    }
    if (tecla==DOWN) {
      py +=8;
    }
  }
  void limites() { //Limites de la mano en la ventana
    if (px <= tam/2) { //izquierda
      px = tam/2;
    }
    if (px >= width-tam/2) {//derecha
      px = width-tam/2;
    }
    if (py <= tam-height/50) { //arriba
      py = tam-height/50;
    }
    if (py >= height-tam) { //abajo
      py = height-tam;
    }
  }

  void agarrar (int tecla) {
    if (tecla==' ') {
      agarre=true;
    } else {
      agarre=false;
    }
  }
}
