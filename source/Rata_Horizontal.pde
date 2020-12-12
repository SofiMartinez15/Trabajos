class Rata2 {
  float px, py, tam;

  PImage rata2;
  boolean mover;

  Rata2() { //valores iniciales
    rata2 = loadImage("rata2.png");
    tam= width/10.66;
    px= random(width/40, width-tam);
    py= random(height/15, height-tam);
  }
  void dibujarata2() {
    image(rata2, px, py, tam*2, tam);
    if (mover) {
      px+=2;
    } else {
      px-=2;
    }
  }
  void moverRata2() {
    if (px<0) {
      mover=true;
    }
    if (px>width-width/5.71) {
      mover= false;
    }
  }
}
