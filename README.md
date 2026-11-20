Taller 3 Programacion Orientada a Objetos

Juan Meza Alvarez 
21297106-5
Profesor Alejandro Paolini

1.- EXCPLICACION GENERAL
----------------------------------------------

Para realizar las tareas asignadas en el taller se estructurara el programa dividiendo la mayoria de tareas en diferentes clases, usando la clase Main principalmente para desplegar el menu y dar las instrucciones al resto de clases de que datos procesar, principalmente a una clase Systema, que se encargara de almacenar y procesar todos los datos recolectados en el main. 



2.- LISTA DE CLASES:
----------------------------------------------


Main: iniciara el programa, desplegara el menu, recolectara los datos leidos de los archivos y enviara instrucciones a las demas clases

Systema: almacenara los datos recolectados y realizara los calculos pedidos desde el main

Archivo: clase que se encargara de abrir, leer y escribir en los archivos de texto.
se separo la tarea de lectura y escritura de archivos en una clase separada para simplificar el proceso de leer y sobreescribir en el main a simples metodos


3.-DETALLES DE CLASES:
----------------------------------------------
©MAIN

Se inicializara la clase Systema

El main empezara pidiendo un nombre que estará dentro de un ciclo de comprobacion de que no sea un nombre vacio.
W,

Luego de eso leera todos los archivos, donde Sistema creara los objetos jugador y monstruos en arraylist, mientras ira comprobando si el nombre ingresado se encuentra en el archivo/lista.
Si se encuentra: muestra su record

Si no: se le registra como usuario nuevo "" write() ""

Se despliega el primer menu "" menuSelect("Jugar un minijuego,Ver catálogo de monstruos,Ver historial de la sesión,Ver ranking de jugadores,Terminar sesión,Salir", 6) "" que estara dentro de un while, haciendo que cuando se salga del while finaliza el programa

Para el despliegue de menu se usara un metodo menuSelect() que recibira un string con todas las opciones separadas por una coma y el valor string de la opcion que sera para salir de este menu para terminar devolvera la opcion seleccionada. 
en la funcion se creara un vector con el método split para determinar la cantidad de opciones que hay en el menu, con esa cantidad se desplegara mediante un for todas las opciones y se pedirá un input para ingresar la opcion del menu que se quiera escojer y con otro for se comprobara si la opcion ingresada esta dentro del intervalo de numeros de opciones excluyendo la opcion salir, estando estos 2 ciclos dentro de un ciclo do while, si en el ciclo de comprobacion la opcion ubgresada coincide con alguna de las disponibles (incluyendo la de salir), el método finalizara devolviendo la opcion ingresada, de lo contrario terminara el priner ciclo imprimiendo un mensaje de error pidiendo ingresar una opcion valida e iniciara de nuevo el ciclo while

Con un switch se identificara que hacer con las distintas opciones desplegabdo sus respectivos menus con opciones.

Opcion 1:
Desplegar menu + parametros que se convertiran a String "" menuSelect("Carrera del cementerio,Caza de calabazas,Lanzamiento de lapidas,Sobrevivir al amanecer,Volver", 0) ""



Opcion 2: 
desplegar el menu



Opcion 3:
Desplegar el menu

Opcion 5:
Se desplegara la funcion sesion()






PARA FINALIZAR SE ESCRIBIRA EL RECORD DEL USUARIO "" write() "" de la clase archivos


©SYSTEMA

La variable uso sera el objeto mounstro que sera instanciado cuando se elija que monstruo usar cuando se juegue un minijuego, todas las subclases tendran un metodo referente a hacer los calculos y desempeñarse en el minijuego de modo que no haya que especificar en el main o en sistema que hacer dependiendo de que monstruo se usara

Public  void AnalisisLinea( String linea, int largoLinea)
Este metodo va a comprobar que tipo de monstruo es comparando su indice 0
Dependiendo de cual sea su indice se le hara un analisis a las partes de la linea con el metodo analisisdatos(largoLista) que identificara si los datos pueden convertirse a los string e int correspondientes al formato de cada monstruo con un try catch y devolvera los datos convertidos dentro de un vector int para usarlos en el constructor.
En caso que todo sea comprobado y se devuelva un vector con el largo correspondiente (largo 6 para zombies y momias o largo 7 para vampiros y hombres lobo), se iniciara el constructor del respectivo monstruo, luego de eso se inspeccionara si el largo de la linea es mayor al largo del monstruo creado.
si ese el caso se iniciara de forma recursiva nuevamente el mismo metodo pero restandole a largoLinea el largo del monstruo que hayamos creado (ej si tenemos una linea de largo 10, y en esa creamos un zombie este tiene un largo de 6, la funcion recursiva iniciara su metodo con un largo de 10-6 (es decir 4). En caso de que el analisis atrape una excepcion de formato la opcion devolvera un vector de largo 1, y no se iniciara el constructor

Se tiene un segundo AnalisisLinea que se usara para leer los datos de los jugadores, este leera los archivos y ejecutara de forma similar pero en este caso al leer correctamente el formato este creara una instancia de jugador y la añadira a su arraylist de Jugador

RegistroJu(string nombre)
Este metodo revisara si el nombre registrado esta en el

