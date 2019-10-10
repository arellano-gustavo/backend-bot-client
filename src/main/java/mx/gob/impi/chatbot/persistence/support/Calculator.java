package mx.gob.impi.chatbot.persistence.support;

public class Calculator {
    /**
     * Divisón "entera" de dos enteros.
     * Se encarga del comportamiento cuando el divisor es cero
     * y se las ingenia para contestar algo descente en ese caso.
     *
     * @param a Entero Dividendo
     * @param b Entero Divisor
     *
     * @return La división entera
     */
    public int divide(int a, int b) {
        if(b==0) {
            return 0;
        } else {
            return a/b;
        }
    }
}
