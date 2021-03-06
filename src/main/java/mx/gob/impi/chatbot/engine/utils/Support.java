/*
 * Copyright (c) 2017 Qbits and/or its affiliates. All rights reserved. Kepler is a TradeMark.
 *
 * Licencia:    Este  código  se encuentra  bajo la protección que
 *              otorga la Ley Federal del Derecho de Autor vigente.
 *              Adicionalmente,  queda  estrictamente  prohibido:
 *              modificar, copiar, donar, vender y/o distribuir el
 *              presente  código por cualquier medio electrónico o
 *              impreso sin el  permiso explícito y por escrito de
 *              de su autor.
 *
 * Proyecto:    Kepler
 * Paquete:     mx.gob.impi.chatbot.engine
 * Modulo:      LcoUtils
 * Tipo:        clase
 * Autor:       Gustavo Arellano (GAA)
 * Fecha:       10/07/2017
 * Version:     0.0.1
 *
 * Historia:    OFG: Se incorpora documentación 20170710_1249
 *
 */
package mx.gob.impi.chatbot.engine.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Clase que contiene métodos útiles para el proyecto
 * @author gustavo
 *
 */
public final class Support {

    /**
     * Método constructor de la clase
     */
    private Support() {}

    /**
     * Valida que un dato tipo texto sea mayor y menor que dos valores
     * @param dato Dato a validar
     * @param a Valor mínimo
     * @param b Valor máximo
     * @return true, si dato es mayor que valor mínimo y menor que valor máximo
     */
    public static boolean verify(String dato, int a, int b) {
        int num = convert(dato);
        if(num<0) return false;
        return (a<=num && num<=b);
    }

    /**
     * Convierte un tipo de dato texto a valor numérico
     * @param dato Dato a convertir
     * @return Valor entero, -1 si es un dato que no puede convertirse
     */
    public static int convert(String dato) {
        try {
            return Integer.parseInt(dato);
        } catch (Exception e) {
            return -1;
        }
    }
    
    /**
     * Obtiene el valor de un json de una sola entrada
     * 
     * @param body
     * @return
     */
    public static String getChallenge(String body) {
        String[] parts = body.split(":");
        return parts[1].substring(1, parts[1].length()-2);
    }
    
    public static Properties loadProps() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = 
                    Support.
                    class.
                    getClassLoader().
                    getResourceAsStream("chat.properties"); 
            properties.load(inputStream);
            return properties;
        } catch (Exception e) { 
            e.printStackTrace();
            return null;
        }
    }
}
