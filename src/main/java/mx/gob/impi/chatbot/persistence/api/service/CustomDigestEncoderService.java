package mx.gob.impi.chatbot.persistence.api.service;

public interface CustomDigestEncoderService {
    /** 
     * Retorna una cadena hexadecimal asociada a la cadena 'source', pero 
     * con un 'salt' arbitrario.
     * 
     * @param source Cadena a hashear
     * @param salt Salt a inyectar
     * 
     * @return Cadena satlteada y hasheada
     */
    String digest(String source, String salt);
}
