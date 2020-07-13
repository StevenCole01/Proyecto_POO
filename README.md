# Proyecto_POO

## DUCK HUNT

### Proyecto final de Steven y Josue

Este es un proyecto de un videojuego programado en java, basado en la temática del clásico Duck Hunt pero con varios cambios y giros en las mecánicas de juego.

### Sobre las mecánicas del juego
El juego tiene mecánicas relativamente simples, se controla a una cazadora que tiene el objetivo de cazar todos los patos posibles,  esto utilizando el rifle que porta consigo, pero también tiene que cuidarse de los animales salvajes y para ello tiene que esquivarlos saltando por encima de ellos, de no hacerlo terminará siendo la cena de alguno de ellos, el objetivo es hacer la mayor cantidad de mayor de puntos eliminando patos y también sobrevivir el mayor tiempo posible.

### Sobre su funcionamiento

**Ventana**

Dentro del programa hay una ventana que se inicia al ejecutarlo y dentro de la misma nos podemos encontrar con cinco pantallas o paneles que estructuran la funcionalidad del juego.

**Paneles de carga, inicio y controles**

El primer panel muestra momentáneamente una pantalla de carga con el título del juego que desaparece haciendo visible el siguiente panel. En seguida se muestra el panel de inicio, el cual contiene tres botones que ejecutan una acción cada uno, silenciar el sonido, abrir un panel de instrucciones e iniciar el juego. El panel de instrucciones solo se abre cuando el usuario presiona el botón de instrucciones, este muestra el funcionamiento del juego, y este contiene un botón con el que se regresa a la pantalla de inicio para así poder empezar la partida. Al presionar el botón de jugar nos mandará al siguiente panel en el que iniciará el videojuego. 

**Panel de Juego e hilos**

En el panel de juego se encuentran todos los personajes que se mueven gracias a la implementación de hilos que se asignaron a cada personaje. En el caso de los patos, el hilo siempre corre un arreglo de patos que se mueven según una función aleatoria la cual puede ser lineal o senoidal. Para los enemigos se asignó un hilo que cada cierto tiempo aplica un random donde se decide si se correrá un personaje (Lobo, Zorro o Jabalí), para esto se genera un número aleatorio(entre 1 y 3) cada segundo y mueve a un personaje elegido aleatoriamente si el valor es 1. 
El personaje principal es una cazadora el cual tiene dos hilos, uno para saltar y otro para moverse horizontalmente por medio de teclas. También se agregó un hilo para el disparo y uno para la caída del pato al intersectar con la bala, el hilo del disparo se activa al presionar la tecla “Enter” y el hilo de la caída de patos se activa al intersectar el pato con la bala.

También se agregaron sonidos y música de fondo, el sonido de pato se activa al caer, el sonido de bala la presionar “Enter” y la música de fondo se inicia desde que empieza el programa.

**Fin de juego y panel final**

Si el personaje principal se intersecta con un enemigo se hace visible un gif y un botón para continuar y mandarnos al siguiente panel. En seguida, después de presionar el botón, se muestra el panel final que contiene las estadísticas del juego. Se conforma de cinco datos, el tiempo transcurrido durante el juego, la puntuación obtenida en el juego, los patos eliminados, el tiempo máximo y la puntuación máxima.

Para obtener los datos de tiempo y puntuación máxima se añadieron dos archivos en la carpeta de recursos que se modifican cada vez que el jugador supera sus estadísticas.


**Recursos**

La carpeta recursos está agregada al programa para su funcionamiento, está contiene cinco carpetas en donde se almacenan: imágenes de los botones y logos, los efectos de sonido, los archivos de texto de las puntuaciones, imágenes de los personajes e imágenes de los fondos.
