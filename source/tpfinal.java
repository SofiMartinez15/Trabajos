import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class tpfinal extends PApplet {

Aventura aventura;

SoundFile sonido;
String estado; //variable global
public void setup() {
  
  surface.setResizable(true);
  aventura = new Aventura();
  estado="presentacion";
  sonido = new SoundFile(this, "ambiente.mp3");
  sonido.loop();
  sonido = new SoundFile(this, "ratas.mp3");
}
public void draw() {
  aventura.dibujar();
  if (estado=="llaves2"&&keyCode==ENTER) { //empieza en el juego
    sonido.loop();
  }
  if (estado=="Final1") {
    sonido.pause();
  }
}
public void keyPressed() {
  aventura.presionar();
  aventura.presionar2();
}
public void mousePressed() {
  aventura.clickear();
}
class Aventura {
  Botones boton; //declarar
  Imagenes secuencia;
  Juego juego;

  String[] textos= {"Elena, una joven de 17 años se muda a Centfor\n con su familia. La casa es antigüa, de dos plantas\n y elegante con muebles de madera", "Presione la BARRA ESPACIADORA para continuar", 
    "(Haga click en la opción que desee elegir)", "Entrar", "Ir hacia el auto", "Mientras bajan las maletas del auto\n Elena se acerca a la casa y escucha una voz\nque la llama hacia adentro", 
    "Elena sube las escaleras y se dirige a un \n pasillo, siente una brisa en el pelo,\n se encuentra con dos habitaciones", "A la izquierda", "A la derecha", 
    "Sin darle importancia, Elena ayuda a desempacar\n las maletas del auto. La hora pasa y oscurece.\n Luego de cenar se dirige a su habitación", "La puerta está cerrada con\n llave, Elena siente curiosidad", 
    "La habitación de Elena,\n bastante amplia pero oscura", "Vuelve afuera y ayuda a sus padres\n a desempacar, cae la noche y es hora\n de la cena, luego se dirigen a sus\n habitaciones para dormir", 
    "Cuando estaba por apagar la luz\nescucha una voz en el pasillo, ve que\n la habitación del frente está semiabierta", "Agarrar palo de madera", "Agarrar vela", 
    "Ella entra, la vela se apaga con una brisa, la ventana\n estaba cerrada, se queda inmóvil, algo la empuja por\n la espalda y se golpea la cabeza con un mueble.\n Elena se desangra en el suelo", 
    "(Presione LEFT para volver atrás)", "Ella entra, por la ventana se ilumina la\n habitación, alguien le susurra al oído y\n se da la vuelta, ve una silueta humana\n y empieza a gritar del miedo", 
    "La silueta se mueve velozmente a su espalda, ella\n reacciona y le pega con el palo, pero él lo agarra y lo\n parte por la mitad, arrojándolo hacia la puerta", 
    "Elena se da cuenta de todo, la brisa\n en el pelo, la velocidad y la fuerza del\n VAMPIRO", "Intentar salir corriendo", "Quedarse quieta", "El vampiro clava sus filosos colmillos\n en el cuello de la chica y absorbe\n su sangre hasta dejarla sin vida", 
    "El vampiro cierra la puerta trabándola\n y le muestra su colmillos, ella se asusta\n y empieza a gritar. Los padres y su\n hermano la escuchan y suben", 
    "Una vez detrás de la puerta, el padre desesperado \n intenta tirarla abajo pero no lo logra.\n Adentro el vampiro se abalanza sobre Elena \n e intenta morderle el cuello", 
    "¿Qué hacer para abrir la puerta?", "Agarrar palanca", "Agarrar llavero", "El padre agarra su llavero pero se le cae\n de  las manos debido a la desesperación \n y los gritos", 
    "Finalmente la puerta se abre pero gracias a\n Elena, o mejor dicho a su fuerza vampírica.\n Ella mira a su familia pero su corazón es\n demasiado frío y su humanidad ya no existe.", "Terminar", 
    "Justo en ese momento, el padre logra abrir\nla puerta y entra, reconoce al vampiro por\n sus colmillos y le clava en la espalda el\n  palo de madera roto", 
    "El vampiro deja a la chica pero no muere, se\n saca el palo y se cura rápidamente, todos se\n sorprenden. El vampiro enojado se dirige hacia \n el padre y le muerde el cuello absorbiendo su sangre", 
    "Elena toma la otra mitad del palo y le grita\n al vampiro, este deja al padre tirado en el\n suelo y se da la vuelta, en ese  instante Elena \n se apresura y le clava el palo con punta:", 
    "En el corazón", "En el pecho", "Así, el vampiro muere. Elena, su madre y su\n hermano, que estaban en shock, se dirigen hacia \n el padre, pero lamentablemente ya había muerto", 
    "El vampiro se saca el palo y se ríe,\n luego muerde a Elena y corre detrás\n de la madre y del hermano alcanzándolos", "Días después del funeral deciden empacar\n e irse de la casa y de Centfor", 
    "Trabajo Final\n\nTecnología Multimedial 1\n\n Alumna: Sofía Martínez\n\n Legajo: 85061/8\n\n Comisión: 1 - 8:00 AM\n\n Profesor: José Luis Bugiolachi\n\n Inspirado en: The Vampire Diaries\n\nFDA\n\n2020", "Reiniciar: ENTER "}; 

  Aventura() { //constructor
    boton=new Botones();
    secuencia=new Imagenes();
    juego = new Juego();
  }

  public void dibujar() {
    println("estado es:" + estado );
    println("X es:" + mouseX ); 
    println("Y es:"+ mouseY ); 

    secuencia.imagen("presentacion", 0); //pantalla inicial
    //......................................................
    secuencia.imagen("comienzo", 1);
    boton.dibujarbotoncentro("comienzo", width/4.70f, height/2.18f, width/1.73f, height/6, textos[0], width/2, height/1.94f);
    boton.dibujarbotontexto("comienzo", width/4.21f, height/1.12f, width/1.90f, height/12, textos[1], width/2, height-height/17.14f, 0, 170);
    //...................................................
    secuencia.imagen("voz", 2);
    secuencia.escribirtexto("voz", textos[2], width/2, height-height/3, 0);
    boton.dibujarbotontexto("voz", width/2.66f, height/1.41f, width/4, height/12, textos[3], width/2, height-height/4.13f, 0, 170);
    boton.dibujarbotontexto("voz", width/2.66f, height/1.23f, width/4, height/12, textos[4], width/2, height-height/7.05f, 0, 170); //derecha
    boton.dibujarbotoncentro("voz", width/4.70f, height/2.18f, width/1.73f, height/6, textos[5], width/2, height/1.94f);
    //...................................................
    secuencia.imagen("pasillo", 3); //si decide entrar
    boton.dibujarbotoncentro("pasillo", width/4.70f, height/2.18f, width/1.73f, height/6, textos[6], width/2, height/1.94f);
    boton.dibujarbotontexto("pasillo", 0, height/1.14f, width/4, height/12, textos[7], width/8, height-height/13.33f, 0, 170);
    boton.dibujarbotontexto("pasillo", width/1.33f, height/1.14f, width/4, height/12, textos[8], width-width/8, height-height/13.33f, 0, 170); //derecha
    //...................................................
    secuencia.imagen("desempacando", 4); //si decide ir al auto
    secuencia.escribirtexto("desempacando", textos[9], width/2, height/16, 255);
    secuencia.escribirtexto("desempacando", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("izquierda", 5); //camino de entrar
    secuencia.escribirtexto("izquierda", textos[10], width/2, height/2, 255);
    secuencia.escribirtexto("izquierda", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("derecha", 6);
    boton.dibujarbotoncentro("derecha", width/3.07f, height/2.22f, width/2.85f, height/8.57f, textos[11], width/2, height/2);
    secuencia.escribirtexto("derecha", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("cena", 7); 
    boton.dibujarbotoncentro("cena", width/3.80f, height/2.22f, width/2.10f, height/5, textos[12], width/2, height/2);
    secuencia.escribirtexto("cena", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("puertaS2", 8); 
    secuencia.escribirtexto("puertaS2", textos[13], width/2, height/16, 255);
    boton.dibujarbotontexto("puertaS2", 0, height/1.14f, width/4, height/12, textos[14], width/8, height-height/13.33f, 255, 20);
    boton.dibujarbotontexto("puertaS2", width/1.33f, height/1.14f, width/4, height/12, textos[15], width-width/8, height-height/13.33f, 255, 20); //derecha
    //...................................................
    secuencia.imagen("finaltragico", 9); 
    secuencia.escribirtexto("finaltragico", textos[16], width/2, height-height/1.71f, 255);
    secuencia.escribirtexto("finaltragico", textos[17], width/2, height-height/4, 255);
    //...................................................
    secuencia.imagen("siluetahombre", 10); 
    secuencia.escribirtexto("siluetahombre", textos[18], width/2, height/2, 255);
    secuencia.escribirtexto("siluetahombre", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("partido", 11); 
    boton.dibujarbotoncentro("partido", width/5, height/2.18f, width/1.66f, height/6, textos[19], width/2, height/1.96f);
    secuencia.escribirtexto("partido", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("vampiro", 12); 
    secuencia.escribirtexto("vampiro", textos[20], width/2, height/12, 255);
    boton.dibujarbotontexto("vampiro", 0, height/1.14f, width/4, height/12, textos[21], width/8, height-height/13.33f, 255, 20);
    boton.dibujarbotontexto("vampiro", width/1.33f, height/1.14f, width/4, height/12, textos[22], width-width/8, height-height/13.33f, 255, 20);
    //...................................................
    secuencia.imagen("mordida", 13); 
    secuencia.escribirtexto("mordida", textos[23], width/2, height/14, 255);
    secuencia.escribirtexto("mordida", textos[17], width/2, height-height/4, 255);
    //...................................................
    secuencia.imagen("colmillos", 14); 
    secuencia.escribirtexto("colmillos", textos[24], width/2, height/2.03f, 255);
    secuencia.escribirtexto("colmillos", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("puertacerrada", 15); 
    secuencia.escribirtexto("puertacerrada", textos[25], width/2, height-height/1.71f, 255);
    secuencia.escribirtexto("puertacerrada", textos[26], width/2, height-height/6, 255);
    boton.dibujarbotontexto("puertacerrada", 0, height/1.14f, width/4, height/12, textos[27], width/8, height-height/13.33f, 0, 170);
    boton.dibujarbotontexto("puertacerrada", width/1.33f, height/1.14f, width/4, height/12, textos[28], width-width/8, height-height/13.33f, 0, 170);
    //...................................................
    secuencia.imagen("llaves", 16); 
    boton.dibujarbotoncentro("llaves", width/4.70f, height/2.18f, width/1.73f, height/6.66f, textos[29], width/2, height/2);
    secuencia.escribirtexto("llaves", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("Final1", 17); //termina el final 1
    secuencia.escribirtexto("Final1", textos[30], width/2, height/2, 255);
    boton.dibujarbotontexto("Final1", width/1.33f, height/1.14f, width/4, height/12, textos[31], width-width/8, height-height/13.33f, 255, 20);
    //...................................................
    secuencia.imagen("padre", 18); 
    secuencia.escribirtexto("padre", textos[32], width/2, height-height/1.84f, 255);
    secuencia.escribirtexto("padre", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("sangre", 19); 
    secuencia.escribirtexto("sangre", textos[33], width/2, height/16, 255);
    secuencia.escribirtexto("sangre", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("palo", 20); 
    secuencia.escribirtexto("palo", textos[34], width/2, height-height/1.71f, 255);
    boton.dibujarbotontexto("palo", 0, height/1.14f, width/4, height/12, textos[35], width/8, height-height/13.33f, 255, 20);
    boton.dibujarbotontexto("palo", width/1.33f, height/1.14f, width/4, height/12, textos[36], width-width/8, height-height/13.33f, 255, 20);
    //...................................................
    secuencia.imagen("muertes", 21);
    secuencia.escribirtexto("muertes", textos[37], width/2, height/2, 255);
    secuencia.escribirtexto("muertes", textos[1], width/2, height-height/17.14f, 255);
    //...................................................
    secuencia.imagen("error", 22);
    secuencia.escribirtexto("error", textos[38], width/4, height/2, 255);
    secuencia.escribirtexto("error", textos[17], width/4, height-height/5, 255);
    //...................................................
    secuencia.imagen("Final2", 23);
    boton.dibujarbotoncentro("Final2", width/4.21f, height/18.75f, width/1.90f, height/9.23f, textos[39], width/2, height/10);
    boton.dibujarbotontexto("Final2", 0, height/1.14f, width/4, height/12, textos[31], width/8, height-height/13.33f, 0, 170);
    //...................................................
    secuencia.imagen("creditos", 24);
    secuencia.escribirtexto("creditos", textos[40], width/2, height/4, 255);
    secuencia.escribirtexto("creditos", textos[41], width-width/8, height-height/13.33f, 255);
    //...................................................
    secuencia.imagen("Instrucciones", 25);

    if (estado=="llaves2") { //estado del juego
      juego.dibujartodo();
      if (keyPressed) {
        juego.movermano();
      }
    }
  }
  public void presionar2() {
    if (estado=="llaves2") {
      if (keyCode==' ') {
        juego.presionar(' '); //agarrar llaves
        juego.desaparecerLlave();
      }
      juego.reiniciar();
    }
  }
  public void presionar() {
    boton.presionartecla("presentacion", "comienzo", ENTER);
    boton.presionartecla("comienzo", "voz", ' ');
    boton.presionartecla("desempacando", "puertaS2", ' ');
    boton.presionartecla("izquierda", "cena", ' ');
    boton.presionartecla("derecha", "cena", ' ');
    boton.presionartecla("cena", "puertaS2", ' ');
    boton.presionartecla("finaltragico", "puertaS2", LEFT);

    if (key== ' '&&estado=="siluetahombre") { //Caso excepcional para que no saltee una pantalla
      estado="partido";
    } else if (key==' '&&estado=="partido") {
      estado="vampiro";
    }
    boton.presionartecla("mordida", "vampiro", LEFT);
    boton.presionartecla("colmillos", "puertacerrada", ' ');
    boton.presionartecla("llaves", "Instrucciones", ' '); 
    boton.presionartecla("Instrucciones", "llaves2", ENTER); //cambia al juego
    if (key==' '  &&estado=="padre") {  //Caso excepcional
      estado="sangre";
    } else if (key==' ' &&estado=="sangre") {
      estado="palo";
    }
    boton.presionartecla("muertes", "Final2", ' ');
    boton.presionartecla("error", "palo", LEFT);
    boton.presionartecla("creditos", "presentacion", ENTER);
  }

  public void clickear() {
    boton.click(width/2.66f, height/1.41f, width/4, height/12, "voz", "pasillo"); //izq- entrar
    boton.click(width/2.66f, height/1.23f, width/4, height/12, "voz", "desempacando"); // der- auto
    boton.click(0, height/1.14f, width/4, height/12, "pasillo", "izquierda"); 
    boton.click(width/1.33f, height/1.14f, width/4, height/12, "pasillo", "derecha");
    boton.click(0, height/1.14f, width/4, height/12, "puertaS2", "siluetahombre"); //cuando hago click en el botón del "palo de madera"
    boton.click(0, height/1.14f, width/4, height/12, "puerta", "siluetahombre");
    boton.click(width/1.33f, height/1.14f, width/4, height/12, "puertaS2", "finaltragico"); //cuando hago click en el botón de la "vela"
    boton.click(width/1.33f, height/1.14f, width/4, height/12, "vampiro", "mordida");
    boton.click(0, height/1.14f, width/4, height/12, "vampiro", "colmillos");
    boton.click(0, height/1.14f, width/4, height/12, "puertacerrada", "padre");
    boton.click(width/1.33f, height/1.14f, width/4, height/12, "puertacerrada", "llaves");
    boton.click(width/1.33f, height/1.14f, width/4, height/12, "palo", "error"); //cuando hago click en el botón de "en el pecho"
    boton.click(0, height/1.14f, width/4, height/12, "palo", "muertes");  //cuando hago click en el botón de "en el corazón"
    boton.click(width/1.33f, height/1.14f, width/4, height/12, "Final1", "creditos"); 
    boton.click(0, height/1.14f, width/4, height/12, "Final2", "creditos");
  }
}
class Botones {
  PFont titulo, textos; 

  Botones() {
    textos=loadFont("Historia.vlw");
  }
  public void dibujarbotoncentro(String actual, float px, float py, float ptamx, float ptamy, String texto, int tx, float ty) { //dibujar botón de fondo de textos
    if (estado==actual) {
      fill(0, 170);
      rect(px, py, ptamx, ptamy);
      textAlign(CENTER);
      textFont(textos, 20);
      fill(255);
      text(texto, tx, ty);
    }
  }
  public void dibujarbotontexto(String actual, float px, float py, float ptamx, int ptamy, String texto, float tx, float ty, int f, int transparencia) { //dibujar botón con su texto
    if (estado==actual) {
      fill(f, transparencia);
      rect(px, py, ptamx, ptamy);
      fill(255);
      textAlign(CENTER);
      textFont(textos, 17);
      text(texto, tx, ty);
    }
  }
  public void presionartecla(String actual, String ir, int tecla) {
    if (keyCode==tecla &&estado==actual) {
      estado=ir;
    }
  }
  public void click(float px, float py, int tamx, int tamy, String estoy, String voy) {
    if (mouseX>=px&&mouseX<=px+tamx&&mouseY>=py&&mouseY<=py+tamy&&estado==estoy) {
      estado=voy;
    }
  }
}
class Imagenes {
  PImage[] fotos=new PImage[26];
  PFont  textos;
  Imagenes() {

    textos=loadFont("Historia.vlw");
    for (int i=0; i<fotos.length; i++) {
      fotos[i]= loadImage( "Foto " + i + ".jpg");
    }
  }
  public void imagen(String actual, int imagen) {  
    if (estado==actual) {
      image(fotos[imagen], 0, 0, width, height);
    }
  }
  public void escribirtexto(String actual, String texto, float tx, float ty, int tcolor) { //para textos sin botón que indican una acción
    if (estado==actual) {
      fill(tcolor);
      textAlign(CENTER);
      textFont(textos, 18);
      text(texto, tx, ty);
    }
  }
}
class Juego {
  int contadorllaves, heridas;
  Mano personaje;
  Rata2[] enemigo2=new Rata2[4];
  Fondo madera;
  Llaves[] llaves=new Llaves[5];

  Juego() { //constructor
    personaje = new Mano();
    madera = new Fondo();
    for (int i=0; i<4; i++) {
      enemigo2[i]= new Rata2();//cargamos los enemigos
    }
    for (int i=0; i<5; i++) {
      llaves[i]=new Llaves();
    }
  }
  public void dibujartodo() { //método

    madera.dibujarpiso();
    for (int i=0; i<5; i++) { 
      llaves[i].dibujarllave();
    }        
    for (int i=0; i<4; i++) { //dibujamos/duplicamos con for las ratas
      enemigo2[i].dibujarata2();
      enemigo2[i].moverRata2();
    }
    sacarsombra();
    personaje.dibujaroscuridad();
    personaje.dibujarmano();
    perder();
    ganar();
    vidasperdidas();

    textAlign(LEFT);
    textSize(25);
    fill(88, 170, 255);
    text("Llaves agarradas:"+ contadorllaves + "/5", width/40, height/12);
    fill(255, 0, 0);
    text("Heridas: " + heridas+ "/5", width/40, height/6);
  }
  public void presionar(int tecla) {
    personaje.agarrar(tecla);
  }
  public void movermano() {
    personaje.mover(keyCode);
    personaje.limites();
  }
  public void desaparecerLlave() { //desaparecer llaves y contador
    for (int i=0; i<5; i++) {
      float contacto = dist(personaje.px, personaje.py, llaves[i].px, llaves[i].py);

      if (contacto<=llaves[i].tam && personaje.agarre == true) { 
        llaves[i].px = llaves[i].px+20000;
        contadorllaves+=1;
      }
    }
  }
  public void vidasperdidas() { //contacto con ratas y heridas
    for (int i=0; i<2; i++) {
      float contacto = dist(personaje.px, personaje.py, enemigo2[i].px, enemigo2[i].py);
      if (contacto<=enemigo2[i].tam == true) { 
        heridas+=1;
        enemigo2[i].px=random(width/40, width/1.33f);
        enemigo2[i].py=random(height/12, height/1.33f);
      }
    }
  }
  public void perder() {
    if (heridas==5) {
      textAlign(CENTER);
      textSize(35);
      fill(255, 0, 0);
      text("Te lastimaste mucho, inténtalo de nuevo", width/2, height/2);
      noLoop();
      personaje.sombra = true;
    }
  }
  public void reiniciar() {
    if (keyCode==CONTROL) {
      heridas=0; 
      contadorllaves=0;
      personaje.sombra = true;
      loop();
      for (int i=0; i<5; i++) {
        llaves[i].px = random(width/40, width/1.23f);
        llaves[i].py = random(height/12, height/1.33f);
      }
    }
  }
  public void ganar() {
    if (contadorllaves==5) {
      textAlign(CENTER);
      textSize(35);
      fill(0, 255, 0);
      text("¡Bien! recogiste todas las llaves\n\n Presiona ENTER para continuar", width/2, height/2);
      personaje.sombra = false;
    }
    if (contadorllaves==5&&keyCode==ENTER) { //salir del juego y reiniciarlo
      estado="Final1";
      contadorllaves=0;
      heridas=0;
      personaje.sombra = true;
      for (int i=0; i<5; i++) {
        llaves[i].px = random(width/40, width/1.23f);
        llaves[i].py = random(height/12, height/1.33f);
      }
    }
  }  
  public void sacarsombra() {
    if (contadorllaves==5) {
      personaje.sombra = false;
    }
  }
}
class Fondo {
  int px, py;
  PImage fondo;
  Fondo() { //valores iniciales
    fondo=loadImage("piso.jpg");
  }
  public void dibujarpiso() {
    imageMode(CORNER);
    image(fondo, px, py, width, height);
  }
}
class Llaves {
  float px, py;
  int tam;
  PImage llave;

  Llaves() { //valores iniciales
    px=random(width/40, width/1.23f);
    py=random(height/12, height/1.33f);
    tam=width/8;

    llave = loadImage("llave2.png");
  }

  public void dibujarllave() {
    image(llave, px, py, tam, tam);
  }
}
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

  public void dibujarmano() {
    image(mano, px, py, tam, tam*2);
  }
  public void dibujaroscuridad() {
    if (sombra) {
      imageMode(CENTER);
      image(negro, px, py);
    }
  }

  public void mover(int tecla) {
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
  public void limites() { //Limites de la mano en la ventana
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

  public void agarrar (int tecla) {
    if (tecla==' ') {
      agarre=true;
    } else {
      agarre=false;
    }
  }
}
class Rata2 {
  float px, py, tam;

  PImage rata2;
  boolean mover;

  Rata2() { //valores iniciales
    rata2 = loadImage("rata2.png");
    tam= width/10.66f;
    px= random(width/40, width-tam);
    py= random(height/15, height-tam);
  }
  public void dibujarata2() {
    image(rata2, px, py, tam*2, tam);
    if (mover) {
      px+=2;
    } else {
      px-=2;
    }
  }
  public void moverRata2() {
    if (px<0) {
      mover=true;
    }
    if (px>width-width/5.71f) {
      mover= false;
    }
  }
}
  public void settings() {  size(800, 600); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "tpfinal" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
