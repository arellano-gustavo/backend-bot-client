/*
 * Licencia:    Este código se encuentra bajo la protección
 *              que otorga el contrato establecido entre
 *              Ultrasist SA de CV y su cliente, IMPI, por lo
 *              que queda estrictamente prohibido copiar, donar
 *              vender y/o distribuir el presente código por
 *              cualquier medio electrónico o impreso sin el
 *              permiso explícito y por escrito del cliente.
 *
 * Proyecto:    Chatbot AETI
 * Paquete:     mx.gob.impi.chatbot.persistence.support
 * Módulo:      CustomDigestEncoderServiceImpl
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Jueves 26 de Septiembre de 2019 (14_16)
 * Version:     1.0-SNAPSHOT
 * .
 * Clase para la digestión de cadenas pero con un 'salt' agregado.
 *
 * Historia:    .
 *              20190926_14_16 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.api.service;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Clase de soporte para generar el hash (SHA-256) de otra cadena pero con un 'salt' dado.
 * 
 * @author GAA (20190926_14_16)
 * @version 1.0
 */
@Service
public class CustomDigestEncoderServiceImpl implements CustomDigestEncoderService {
    private final static Logger logger = Logger.getLogger(CustomDigestEncoderServiceImpl.class);
    
    @Override
    public String digest(String source, String salt) {
        try {
            return toHexString(getSHA256(source, salt));
        } catch (NoSuchAlgorithmException e) {
            logger.error("This Wouldn't ocurr never ever..."); 
            logger.error(e.getMessage());
            return null;
        }
    }

    /**
     * Regresa un arreglo de bytes que es la digestión de un input dado y un 'salt' dado.
     * Generalmente, el 'salt' va a ser el usuario, para este caso de uso. (Auth)
     * 
     * @param source Cadena a digestar (Generalmente el password)
     * @param salt Cadena a incluir como 'salt' (Generalmente el Usuaio)
     * 
     * @return Areeglo de bytes con la composición digestada
     * 
     * @throws NoSuchAlgorithmException No va a pasar nunca, ya que el SHA-256 siempre exste
     */
    private byte[] getSHA256(String source, String salt) throws NoSuchAlgorithmException {
        // Create the 'input' String with a 'salt', generally, 
        String input = source + salt;
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
    
    /**
     * Convierte un arreglo de bytes en una cadena hexadecimal
     * @param hash Arreglo de bytes a ser convertido a cadena
     * @return Cadena asociada al arreglo dado
     */
    private String toHexString(byte[] hash) { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32) {
            hexString.insert(0, '0');  
        }
        
        // Show me the result, baby
        return hexString.toString();  
    } 
}