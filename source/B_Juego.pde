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
  void dibujartodo() { //método

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
  void presionar(int tecla) {
    personaje.agarrar(tecla);
  }
  void movermano() {
    personaje.mover(keyCode);
    personaje.limites();
  }
  void desaparecerLlave() { //desaparecer llaves y contador
    for (int i=0; i<5; i++) {
      float contacto = dist(personaje.px, personaje.py, llaves[i].px, llaves[i].py);

      if (contacto<=llaves[i].tam && personaje.agarre == true) { 
        llaves[i].px = llaves[i].px+20000;
        contadorllaves+=1;
      }
    }
  }
  void vidasperdidas() { //contacto con ratas y heridas
    for (int i=0; i<2; i++) {
      float contacto = dist(personaje.px, personaje.py, enemigo2[i].px, enemigo2[i].py);
      if (contacto<=enemigo2[i].tam == true) { 
        heridas+=1;
        enemigo2[i].px=random(width/40, width/1.33);
        enemigo2[i].py=random(height/12, height/1.33);
      }
    }
  }
  void perder() {
    if (heridas==5) {
      textAlign(CENTER);
      textSize(35);
      fill(255, 0, 0);
      text("Te lastimaste mucho, inténtalo de nuevo", width/2, height/2);
      noLoop();
      personaje.sombra = true;
    }
  }
  void reiniciar() {
    if (keyCode==CONTROL) {
      heridas=0; 
      contadorllaves=0;
      personaje.sombra = true;
      loop();
      for (int i=0; i<5; i++) {
        llaves[i].px = random(width/40, width/1.23);
        llaves[i].py = random(height/12, height/1.33);
      }
    }
  }
  void ganar() {
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
        llaves[i].px = random(width/40, width/1.23);
        llaves[i].py = random(height/12, height/1.33);
      }
    }
  }  
  void sacarsombra() {
    if (contadorllaves==5) {
      personaje.sombra = false;
    }
  }
}
