class Imagenes {
  PImage[] fotos=new PImage[26];
  PFont  textos;
  Imagenes() {

    textos=loadFont("Historia.vlw");
    for (int i=0; i<fotos.length; i++) {
      fotos[i]= loadImage( "Foto " + i + ".jpg");
    }
  }
  void imagen(String actual, int imagen) {  
    if (estado==actual) {
      image(fotos[imagen], 0, 0, width, height);
    }
  }
  void escribirtexto(String actual, String texto, float tx, float ty, int tcolor) { //para textos sin botón que indican una acción
    if (estado==actual) {
      fill(tcolor);
      textAlign(CENTER);
      textFont(textos, 18);
      text(texto, tx, ty);
    }
  }
}
