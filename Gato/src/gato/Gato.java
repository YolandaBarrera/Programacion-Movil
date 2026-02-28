// Barrera Correa Yolanda Michel
package gato;

import java.awt.BorderLayout; // organizar paneles (NORTE, SUR, CENTRO)
import java.awt.Font;         // cambiar el tamaño y tipo de letra de los botones
import java.awt.GridLayout;   // organizar botones en cuadrícula
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  // para responder a los clics
import javax.swing.JButton;            // para crear botones
import javax.swing.JFrame;             // ventana principal
import javax.swing.JPanel;             // paneles para organizar componentes
import javax.swing.JOptionPane;        // panel para mensaje de ganador

public class Gato extends JFrame implements ActionListener {

    JButton botones[] = new JButton[9]; // 9 botones para el tablero
    JButton btnReinciar;                // botón para reiniciar 
    boolean turnoX = true;              // X empieza el turno
    Font fuente = new Font("Arial", 1, 60);  // Fuente grande para las X y O
    JPanel pJuego, pOpciones;                // Panel para el tablero y para opciones
    String letra;                            // Guarda la letra que se pondrá (X o O)

    // Constructor
    public Gato() {
        setTitle("Gato");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Creamos el panel del tablero y lo ponemos en 3x3
        pJuego = new JPanel();
        pJuego.setLayout(new GridLayout(3, 3));
        
        // Creamos los 9 botones del tablero
        for (int i = 0; i < botones.length; i++) {
            botones[i] = new JButton("");       // cada botón inicia vacío
            botones[i].setFont(fuente);         // fuente grande
            botones[i].addActionListener(this); // cada botón escuchará los clics
            pJuego.add(botones[i]);             // añadimos el botón al panel
        }

        add(pJuego, BorderLayout.CENTER);       // pone el panel en el centro

         // botón para reiniciar el juego
        btnReinciar = new JButton("Reiniciar Juego");
        pOpciones = new JPanel();           // Panel para el botón de reinicio
    
        // Funcionalidad del botón:
        btnReinciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ex) {
                // Limpia todos los botones y los habilita de nuevo
                for (int i = 0; i < botones.length; i++) {
                    botones[i].setText("");       // Quita X, O
                    botones[i].setEnabled(true);  // Habilita otra vez
                }
                turnoX = true;                    // Reinicia el turno a X
            }
        });

        pOpciones.add(btnReinciar);           // Añade el botón al panel de opciones
        add(pOpciones, BorderLayout.SOUTH);   // Pone el panel abajo de la ventana
    }
    // inicia la aplicación y muestra la ventana del juego
    public static void main(String a[]) {
        Gato g = new Gato();        // Crea la ventana del juego
        g.setVisible(true);         // La hace visible
    }
    
    // Método que responde a los clics de los botones del tablero
    @Override
    public void actionPerformed(ActionEvent btnApretado) {
        if (turnoX) {
            letra = "X";
            turnoX = false;     // Cambiamos el turno a O
        } else {
            letra = "O";
            turnoX = true;      // Cambiamos el turno a X
        }
        
        // Recorre todos los botones para ver cual fue presionado
        for (int i = 0; i < botones.length; i++) {
            if (btnApretado.getSource() == botones[i]) {
                botones[i].setText(letra);          // pone la letra
                botones[i].setEnabled(false);       // deshabilita el botón
                validarGanador();                   // llama al método de validacion
            }
        }
    }
    
    // Método para validar ganador
    // Matriz de combinaciones ganadoras. Cada subarreglo representa los índices
    // de los botones que forman una línea horizontal, vertical o diagonal
    public void validarGanador() {

        int[][] g = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Horizontales
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Verticales
            {0, 4, 8}, {2, 4, 6}             // Diagonales
        };
        // Recorre todas las combinaciones
        for (int i = 0; i < g.length; i++) {
            int a = g[i][0];
            int b = g[i][1];
            int c = g[i][2];
            
            // Si los tres botones tienen la misma letra y no están vacíos:
            if (!botones[a].getText().equals("") &&
                botones[a].getText().equals(botones[b].getText()) &&
                botones[a].getText().equals(botones[c].getText())) {

                // muestra mensaje de quién ganó
                JOptionPane.showMessageDialog(this, "¡Gana " + botones[a].getText() 
                        + "!", "Ganador", JOptionPane.INFORMATION_MESSAGE); 

                // deshabilita todos los botones al terminar el juego
                for (int j = 0; j < botones.length; j++) {
                    botones[j].setEnabled(false);
                }
                // Sale del bucle, ya tenemos un ganador
                break;
            }
        }
    }
}