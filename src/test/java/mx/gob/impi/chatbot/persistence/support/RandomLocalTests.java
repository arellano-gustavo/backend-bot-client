package mx.gob.impi.chatbot.persistence.support;

public class RandomLocalTests {
    private static String createSecurityToken() {
        String store = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
                      //123456789_123456789_123456789_123456789_123456789_123456789_12  // 62 caracteres
        String result = "";
        for(int i=0; i<50;i++) {
            double prev = Math.random()*62; // de 0 hasta 61
            int position = (int)prev;
            char data = store.charAt(position);
            result = result + data;
        }
        return result;
    }
    public static void main(String...argv) {
        for(int i=0;i<25;i++)
        System.out.println(createSecurityToken());
    }
}
