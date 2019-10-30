package mx.gob.impi.chatbot.persistence.support;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaginatorTest {
    private static final Logger logger = LoggerFactory.getLogger(PaginatorTest.class);
    @Test
    public void paginator() {
        logger.info("Tests de paginación");

        int[] result = null;
        // First test:
        result = getPage(createArray(236), 20, 4);
        assertTrue(result[0]==61 && result[19]==80);// p1:1-20, p2:21-40, p3:41-60, p4:61-80

        // Second test:
        result = getPage(createArray(131), 20001, 4);
        assertTrue(result.length==0);// pagina 4 empieza en 80004

        //Third test:
        result = getPage(createArray(97), 7, 4000);
        assertTrue(result.length==0);// la página 4000 está vacia

        //Fourth test:
        result = getPage(createArray(6971), 20, 20);
        assertTrue(result[0]==381 && result[19]==400);// la página 20 de longitud 20

        //Fifth test:
        result = getPage(createArray(6971), 0, 8);
        assertTrue(result.length==0);// la página 0 no existe

        result = getPage(createArray(6971), 1, -1);
        assertTrue(result.length==0);// la página 1 de longitud -1 no existe

        result = getPage(createArray(6971), -1, -1);
        assertTrue(result.length==0);// la página -1 no existe

        result = getPage(createArray(6971), 0, 0);
        assertTrue(result.length==0);// la página 0 no existe
        // We need to do more tests... a lot more...
    }

    /**
     * Algoritmo a probar
     *
     * @param originalArray
     * @param pageSize
     * @param pageNumber
     * @return
     */
    private int[] getPage(int[] originalArray, int pageSize, int pageNumber) {
        if(pageSize<1 || pageNumber<1) return new int[0];
        int a = pageSize * pageNumber - pageSize +1;
        int b = pageSize * pageNumber;
        int len = originalArray.length;
        if(a>len) return new int[0];
        if(b>len) b = originalArray.length;
        int newLen = b-a+1;
        int[] result = new int[newLen];
        for(int i = 0; i<newLen; i++) {
            result[i] = originalArray[a+i-1];
        }
        return result;
    }

    /**
     * Regresa un arreglo de enteros positivos numerados del 1 hasta el tamsño del arreglo.
     * Asi, si recibe un 123 el arreglo tiene dentro 1, 2, 3, ... hasta 123
     *
     * @param tam Tamaño del arreglo
     *
     * @return Arreglo de enteros
     */
    private int[] createArray(int tam) {
        int[] array = new int[tam];
        for(int i=0; i<tam; i++) {
            array[i] = i+1;
        }
        return array;
    }
}
