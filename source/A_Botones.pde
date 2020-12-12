class Botones {
  PFont titulo, textos; 

  Botones() {
    textos=loadFont("Historia.vlw");
  }
  void dibujarbotoncentro(String actual, float px, float py, float ptamx, float ptamy, String texto, int tx, float ty) { //dibujar botón de fondo de textos
    if (estado==actual) {
      fill(0, 170);
      rect(px, py, ptamx, ptamy);
      textAlign(CENTER);
      textFont(textos, 20);
      fill(255);
      text(texto, tx, ty);
    }
  }
  void dibujarbotontexto(String actual, float px, float py, float ptamx, int ptamy, String texto, float tx, float ty, int f, int transparencia) { //dibujar botón con su texto
    if (estado==actual) {
      fill(f, transparencia);
      rect(px, py, ptamx, ptamy);
      fill(255);
      textAlign(CENTER);
      textFont(textos, 17);
      text(texto, tx, ty);
    }
  }
  void presionartecla(String actual, String ir, int tecla) {
    if (keyCode==tecla &&estado==actual) {
      estado=ir;
    }
  }
  void click(float px, float py, int tamx, int tamy, String estoy, String voy) {
    if (mouseX>=px&&mouseX<=px+tamx&&mouseY>=py&&mouseY<=py+tamy&&estado==estoy) {
      estado=voy;
    }
  }
}
