// Barrera Correa Yolanda Michel
package calculadoragrafica2;

// Clase que contiene métodos para realizar las operaciones
public class Calculadora {

    // Método para sumar dos números
    // Es un método de instancia, se debe crear un objeto de Calculadora para usarlo
    public double sumar(double n1, double n2){
        return n1 + n2;  // Retorna la suma de n1 y n2
    }

    // Método para restar dos números
    // También es de instancia, pero en vez de retornar el resultado, 
    // lo imprime directamente en consola
    public void restar(double n1, double n2){
        System.out.println(n1 - n2);  // Muestra la resta en la consola
    }

    // Método para multiplicar dos números
    // Es estático, se puede llamar directamente desde la clase sin crear un objeto
    public static double multiplicar(double n1, double n2){
        return n1 * n2;  // Retorna el resultado de n1 * n2
    }

    // Método para dividir dos números
    // Es estático, imprime el resultado en consola en lugar de retornarlo
    public static void dividir(double n1, double n2){
        System.out.println(n1 / n2);  // Muestra la división en la consola
    }

    // Método principal 
    public static void main(String[] args) {
        // Crea un objeto de la clase para usar métodos no estáticos
        Calculadora c = new Calculadora(); 

    }
}