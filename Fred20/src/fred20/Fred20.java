// Barrera Correa Yolanda Michel
package fred20;

// Importa la clase Color para poder usar colores en los botones
import java.awt.Color;
// Para organizar los botones en forma de cuadrícula
import java.awt.GridLayout;
// Random para generar números aleatorios
import java.util.Random;
// Para los botones
import javax.swing.JButton;
// Para crear una ventana
import javax.swing.JFrame;
// Para detectar cuando se presiona un botón
import java.awt.event.ActionListener;
//Evento de presionar un botón
import java.awt.event.ActionEvent;


public class Fred20 extends JFrame {

    // Arreglo que almacena los 4 botones del juego
    JButton casillas[] = new JButton[4];
    // Arreglo que guarda la secuencia aleatoria del juego (6 pasos)
    int[] secuencia = new int[6];
    // Objeto Random para generar números aleatorios
    Random r = new Random();

    // Arreglo que guarda los colores que tendrá cada botón cuando se encienda
    Color colores[] = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};
    // 0 = rojo
    // 1 = verde
    // 2 = azul
    // 3 = amarillo

    // Constructor de la clase
    public Fred20() {
        setTitle("Fred20");
        setSize(300, 300);
        setDefaultCloseOperation(3);
        // GridLayout(2,2) crea una cuadrícula de 2 filas y 2 columnas
        setLayout(new GridLayout(2, 2));


        // Ciclo que crea los 4 botones
        for (int i = 0; i < casillas.length; i++) {
            // Se crea un nuevo botón
            casillas[i] = new JButton();
            
            // Todos los botones comienzan con color gris claro: "apagados"
            casillas[i].setBackground(Color.LIGHT_GRAY);
            // Guarda el índice del botón
            int indice = i;

            // Se agrega un ActionListener al botón
            casillas[i].addActionListener(new ActionListener() {

                // Método que se ejecuta cuando el botón es presionado
                @Override
                public void actionPerformed(ActionEvent e) {

                    // Se crea un hilo para que el botón se ilumine sin congelar la interfaz
                    new Thread(new Runnable() {

                        public void run() {

                            try {

                                // Cambia el color del botón al color correspondiente,
                                // según su índice en el arreglo de colores
                                casillas[indice].setBackground(colores[indice]);

                                // El botón permanece encendido durante 500 milisegundos
                                Thread.sleep(500);

                                // Después de ese tiempo el botón vuelve a gris
                                casillas[indice].setBackground(Color.LIGHT_GRAY);

                            } catch (Exception ex) {

                                // Si ocurre un error se ignora
                            }

                        }

                    }).start(); // Se inicia el hilo

                }

            });

            // Se agrega el botón a la ventana
            add(casillas[i]);
        }


        // Se genera la secuencia aleatoria del juego
        crearSecuencia();

        // Se muestra la secuencia visualmente en los botones
        mostrarSecuencia();
    }



    // Método que genera la secuencia aleatoria
    public void crearSecuencia() {

        // Recorre el arreglo de la secuencia
        for (int i = 0; i < secuencia.length; i++) {

            // Genera un número aleatorio entre 0 y 3
            // Cada número representa uno de los botones
            secuencia[i] = r.nextInt(4);
        }


        // Este ciclo imprime la secuencia en la consola
        for (int x : secuencia) {

            System.out.print(x + " ");
        }
    }



    // Método que muestra visualmente la secuencia en los botones
    public void mostrarSecuencia() {

        // Se crea un hilo para mostrar la secuencia
        Thread hilo = new Thread(new Runnable() {

            @Override
            public void run() {

                // Recorre todos los elementos de la secuencia
                for (int i = 0; i < secuencia.length; i++) {

                    // Obtiene el número del botón que se debe encender
                    int indice = secuencia[i];

                    try {

                        // Enciende el botón con su color correspondiente
                        casillas[indice].setBackground(colores[indice]);

                        // Mantiene el botón encendido durante 1 segundo
                        Thread.sleep(1000);

                        // Apaga el botón regresándolo a gris
                        casillas[indice].setBackground(Color.LIGHT_GRAY);

                        // Espera 300 milisegundos antes de mostrar el siguiente botón
                        Thread.sleep(300);

                    } catch (Exception e) {

                        // Si ocurre algún error se ignora
                    }
                }

            }
        });

        // Inicia la ejecución del hilo
        hilo.start();
    }



    // Método principal para ejecutar el programa
    public static void main(String[] args) {

        // Se crea un objeto de la clase Fred20
        Fred20 f = new Fred20();

        // Hace visible la ventana en pantalla
        f.setVisible(true);

    }

}