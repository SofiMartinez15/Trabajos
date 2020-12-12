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

  void dibujar() {
    println("estado es:" + estado );
    println("X es:" + mouseX ); 
    println("Y es:"+ mouseY ); 

    secuencia.imagen("presentacion", 0); //pantalla inicial
    //......................................................
    secuencia.imagen("comienzo", 1);
    boton.dibujarbotoncentro("comienzo", width/4.70, height/2.18, width/1.73, height/6, textos[0], width/2, height/1.94);
    boton.dibujarbotontexto("comienzo", width/4.21, height/1.12, width/1.90, height/12, textos[1], width/2, height-height/17.14, 0, 170);
    //...................................................
    secuencia.imagen("voz", 2);
    secuencia.escribirtexto("voz", textos[2], width/2, height-height/3, 0);
    boton.dibujarbotontexto("voz", width/2.66, height/1.41, width/4, height/12, textos[3], width/2, height-height/4.13, 0, 170);
    boton.dibujarbotontexto("voz", width/2.66, height/1.23, width/4, height/12, textos[4], width/2, height-height/7.05, 0, 170); //derecha
    boton.dibujarbotoncentro("voz", width/4.70, height/2.18, width/1.73, height/6, textos[5], width/2, height/1.94);
    //...................................................
    secuencia.imagen("pasillo", 3); //si decide entrar
    boton.dibujarbotoncentro("pasillo", width/4.70, height/2.18, width/1.73, height/6, textos[6], width/2, height/1.94);
    boton.dibujarbotontexto("pasillo", 0, height/1.14, width/4, height/12, textos[7], width/8, height-height/13.33, 0, 170);
    boton.dibujarbotontexto("pasillo", width/1.33, height/1.14, width/4, height/12, textos[8], width-width/8, height-height/13.33, 0, 170); //derecha
    //...................................................
    secuencia.imagen("desempacando", 4); //si decide ir al auto
    secuencia.escribirtexto("desempacando", textos[9], width/2, height/16, 255);
    secuencia.escribirtexto("desempacando", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("izquierda", 5); //camino de entrar
    secuencia.escribirtexto("izquierda", textos[10], width/2, height/2, 255);
    secuencia.escribirtexto("izquierda", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("derecha", 6);
    boton.dibujarbotoncentro("derecha", width/3.07, height/2.22, width/2.85, height/8.57, textos[11], width/2, height/2);
    secuencia.escribirtexto("derecha", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("cena", 7); 
    boton.dibujarbotoncentro("cena", width/3.80, height/2.22, width/2.10, height/5, textos[12], width/2, height/2);
    secuencia.escribirtexto("cena", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("puertaS2", 8); 
    secuencia.escribirtexto("puertaS2", textos[13], width/2, height/16, 255);
    boton.dibujarbotontexto("puertaS2", 0, height/1.14, width/4, height/12, textos[14], width/8, height-height/13.33, 255, 20);
    boton.dibujarbotontexto("puertaS2", width/1.33, height/1.14, width/4, height/12, textos[15], width-width/8, height-height/13.33, 255, 20); //derecha
    //...................................................
    secuencia.imagen("finaltragico", 9); 
    secuencia.escribirtexto("finaltragico", textos[16], width/2, height-height/1.71, 255);
    secuencia.escribirtexto("finaltragico", textos[17], width/2, height-height/4, 255);
    //...................................................
    secuencia.imagen("siluetahombre", 10); 
    secuencia.escribirtexto("siluetahombre", textos[18], width/2, height/2, 255);
    secuencia.escribirtexto("siluetahombre", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("partido", 11); 
    boton.dibujarbotoncentro("partido", width/5, height/2.18, width/1.66, height/6, textos[19], width/2, height/1.96);
    secuencia.escribirtexto("partido", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("vampiro", 12); 
    secuencia.escribirtexto("vampiro", textos[20], width/2, height/12, 255);
    boton.dibujarbotontexto("vampiro", 0, height/1.14, width/4, height/12, textos[21], width/8, height-height/13.33, 255, 20);
    boton.dibujarbotontexto("vampiro", width/1.33, height/1.14, width/4, height/12, textos[22], width-width/8, height-height/13.33, 255, 20);
    //...................................................
    secuencia.imagen("mordida", 13); 
    secuencia.escribirtexto("mordida", textos[23], width/2, height/14, 255);
    secuencia.escribirtexto("mordida", textos[17], width/2, height-height/4, 255);
    //...................................................
    secuencia.imagen("colmillos", 14); 
    secuencia.escribirtexto("colmillos", textos[24], width/2, height/2.03, 255);
    secuencia.escribirtexto("colmillos", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("puertacerrada", 15); 
    secuencia.escribirtexto("puertacerrada", textos[25], width/2, height-height/1.71, 255);
    secuencia.escribirtexto("puertacerrada", textos[26], width/2, height-height/6, 255);
    boton.dibujarbotontexto("puertacerrada", 0, height/1.14, width/4, height/12, textos[27], width/8, height-height/13.33, 0, 170);
    boton.dibujarbotontexto("puertacerrada", width/1.33, height/1.14, width/4, height/12, textos[28], width-width/8, height-height/13.33, 0, 170);
    //...................................................
    secuencia.imagen("llaves", 16); 
    boton.dibujarbotoncentro("llaves", width/4.70, height/2.18, width/1.73, height/6.66, textos[29], width/2, height/2);
    secuencia.escribirtexto("llaves", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("Final1", 17); //termina el final 1
    secuencia.escribirtexto("Final1", textos[30], width/2, height/2, 255);
    boton.dibujarbotontexto("Final1", width/1.33, height/1.14, width/4, height/12, textos[31], width-width/8, height-height/13.33, 255, 20);
    //...................................................
    secuencia.imagen("padre", 18); 
    secuencia.escribirtexto("padre", textos[32], width/2, height-height/1.84, 255);
    secuencia.escribirtexto("padre", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("sangre", 19); 
    secuencia.escribirtexto("sangre", textos[33], width/2, height/16, 255);
    secuencia.escribirtexto("sangre", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("palo", 20); 
    secuencia.escribirtexto("palo", textos[34], width/2, height-height/1.71, 255);
    boton.dibujarbotontexto("palo", 0, height/1.14, width/4, height/12, textos[35], width/8, height-height/13.33, 255, 20);
    boton.dibujarbotontexto("palo", width/1.33, height/1.14, width/4, height/12, textos[36], width-width/8, height-height/13.33, 255, 20);
    //...................................................
    secuencia.imagen("muertes", 21);
    secuencia.escribirtexto("muertes", textos[37], width/2, height/2, 255);
    secuencia.escribirtexto("muertes", textos[1], width/2, height-height/17.14, 255);
    //...................................................
    secuencia.imagen("error", 22);
    secuencia.escribirtexto("error", textos[38], width/4, height/2, 255);
    secuencia.escribirtexto("error", textos[17], width/4, height-height/5, 255);
    //...................................................
    secuencia.imagen("Final2", 23);
    boton.dibujarbotoncentro("Final2", width/4.21, height/18.75, width/1.90, height/9.23, textos[39], width/2, height/10);
    boton.dibujarbotontexto("Final2", 0, height/1.14, width/4, height/12, textos[31], width/8, height-height/13.33, 0, 170);
    //...................................................
    secuencia.imagen("creditos", 24);
    secuencia.escribirtexto("creditos", textos[40], width/2, height/4, 255);
    secuencia.escribirtexto("creditos", textos[41], width-width/8, height-height/13.33, 255);
    //...................................................
    secuencia.imagen("Instrucciones", 25);

    if (estado=="llaves2") { //estado del juego
      juego.dibujartodo();
      if (keyPressed) {
        juego.movermano();
      }
    }
  }
  void presionar2() {
    if (estado=="llaves2") {
      if (keyCode==' ') {
        juego.presionar(' '); //agarrar llaves
        juego.desaparecerLlave();
      }
      juego.reiniciar();
    }
  }
  void presionar() {
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

  void clickear() {
    boton.click(width/2.66, height/1.41, width/4, height/12, "voz", "pasillo"); //izq- entrar
    boton.click(width/2.66, height/1.23, width/4, height/12, "voz", "desempacando"); // der- auto
    boton.click(0, height/1.14, width/4, height/12, "pasillo", "izquierda"); 
    boton.click(width/1.33, height/1.14, width/4, height/12, "pasillo", "derecha");
    boton.click(0, height/1.14, width/4, height/12, "puertaS2", "siluetahombre"); //cuando hago click en el botón del "palo de madera"
    boton.click(0, height/1.14, width/4, height/12, "puerta", "siluetahombre");
    boton.click(width/1.33, height/1.14, width/4, height/12, "puertaS2", "finaltragico"); //cuando hago click en el botón de la "vela"
    boton.click(width/1.33, height/1.14, width/4, height/12, "vampiro", "mordida");
    boton.click(0, height/1.14, width/4, height/12, "vampiro", "colmillos");
    boton.click(0, height/1.14, width/4, height/12, "puertacerrada", "padre");
    boton.click(width/1.33, height/1.14, width/4, height/12, "puertacerrada", "llaves");
    boton.click(width/1.33, height/1.14, width/4, height/12, "palo", "error"); //cuando hago click en el botón de "en el pecho"
    boton.click(0, height/1.14, width/4, height/12, "palo", "muertes");  //cuando hago click en el botón de "en el corazón"
    boton.click(width/1.33, height/1.14, width/4, height/12, "Final1", "creditos"); 
    boton.click(0, height/1.14, width/4, height/12, "Final2", "creditos");
  }
}
