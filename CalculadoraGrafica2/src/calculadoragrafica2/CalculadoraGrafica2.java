// Barrera Correa Yolanda Michel
package calculadoragrafica2;

import java.awt.Font;           
import java.awt.GridLayout;   
import javax.swing.JButton;    
import javax.swing.JFrame;     
import javax.swing.JLabel;      
import javax.swing.JPanel;      
import javax.swing.JTextField;  


public class CalculadoraGrafica2 extends JFrame {

    // Campos de texto donde el usuario ingresa los números
    JTextField n1, n2;

    // Botones de operaciones
    JButton btnSum, btnRes, btnDiv, btnMul;

    // Etiqueta donde se mostrará el resultado
    JLabel txtRes;

    // Fuente grande para los textos y botones
    Font fuente = new Font("Courier", 1, 60);

    // Constructor
    public CalculadoraGrafica2() {
        setTitle("casio");                  // Título de la ventana
        setSize(400, 400);                  // Tamaño de la ventana
        setDefaultCloseOperation(3);        // Cierra la aplicación al cerrar la ventana
        setLayout(new GridLayout(4, 1));   // Distribuye los componentes en 4 filas

        // Inicializa los campos de texto
        n1 = new JTextField();
        n1.setFont(fuente);  // Asigna la fuente grande
        n2 = new JTextField();
        n2.setFont(fuente);

        // Panel para los botones de operaciones
        JPanel pOpciones = new JPanel(new GridLayout(1, 4)); // 1 fila, 4 columnas

        // Crea los botones y asigna la fuente
        btnSum = new JButton("+");
        btnSum.setFont(fuente);
        btnRes = new JButton("-");
        btnRes.setFont(fuente);
        btnMul = new JButton("*");
        btnMul.setFont(fuente);
        btnDiv = new JButton("/");
        btnDiv.setFont(fuente);

        // Agrega los botones al panel
        pOpciones.add(btnSum);
        pOpciones.add(btnRes);
        pOpciones.add(btnMul);
        pOpciones.add(btnDiv);

        // Crea la etiqueta para mostrar el resultado y le asigna la fuente
        txtRes = new JLabel("0");
        txtRes.setFont(fuente);

        // Lambda para el botón de suma (+)
        btnSum.addActionListener(e -> {
            // Convierte el texto de los campos a números
            double num1 = Double.parseDouble(n1.getText());
            double num2 = Double.parseDouble(n2.getText());

            // Usa la clase Calculadora para sumar
            Calculadora cc = new Calculadora();
            txtRes.setText(String.valueOf(cc.sumar(num1, num2))); // Muestra el resultado
        });

        // Lambda para el botón de multiplicación (*)
        btnMul.addActionListener(e -> {
            double num1 = Double.parseDouble(n1.getText());
            double num2 = Double.parseDouble(n2.getText());

            // Método estático para multiplicar
            txtRes.setText(String.valueOf(Calculadora.multiplicar(num1, num2)));
        });

        // Lambda para el botón de resta, llama al método calcular (-)
        btnRes.addActionListener(e -> calcular("-"));

        // Lambda para el botón de división, llama al método calcular (/)
        btnDiv.addActionListener(e -> calcular("/"));

        // Agrega los componentes a la ventana principal
        add(n1);           // Primer campo de texto
        add(n2);           // Segundo campo de texto
        add(pOpciones);    // Panel con los botones
        add(txtRes);       // Etiqueta del resultado
    } 

    // Método que realiza la resta o división según el operador
    public void calcular(String operador) {
        // Convierte el texto de los campos a números
        double num1 = Double.parseDouble(n1.getText());
        double num2 = Double.parseDouble(n2.getText());
        double resultado = 0;

        // Dependiendo del operador hace la operación
        switch (operador) {
            case "-":
                resultado = num1 - num2;
                break;
            case "/":
                resultado = num1 / num2;
                break;
        }

        // Muestra el resultado en la etiqueta
        txtRes.setText(String.valueOf(resultado));
    }

    // Método principal para ejecutar la aplicación
    public static void main(String[] args) {
        CalculadoraGrafica2 cc2 = new CalculadoraGrafica2(); // Crea la ventana
        cc2.setVisible(true); // Hace visible la ventana
    }

}
