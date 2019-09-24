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
 * Módulo:      MailEngine
 * Tipo:        clase
 * Autor:       Gustavo A. Arellano (GAA)
 * Fecha:       Viernes 20 de Septiembre de 2019 (13_41)
 * Version:     1.0-SNAPSHOT
 * .
 * Clase para el envio de mails 
 *
 * Historia:    .
 *              20190920_1341 Creación del tipo
 *
 *
 */
package mx.gob.impi.chatbot.persistence.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

/**
 * <p>Descripción:</p> Clase que implementa el servicio de mail.
 * 
 * @author Gustavo A. Arellano (GAA)
 * @version 1.1.56
 */
@Service
public final class MailEngine implements Serializable {

    /**
     * Representa el valor inicial de la version del serial
     */
    private static final long serialVersionUID = 1L;
    /**
     * Representa un objeto para el Log de mensajes
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MailEngine.class);
    /**
     * Representa una lista de mensajes MIME
     */
    private transient List<MimeMessage> mimeMessagesBag = new ArrayList<MimeMessage>();
    /**
     * Representa el motor de mensajeria
     */
    private static MailEngine instance = new MailEngine();
    /**
     * Representa el remitente del servicio de correo
     */
    @Autowired
    private transient JavaMailSender mailSender;
    /**
     * Indica si el servicio esta disponible
     */
    private boolean active;
    /**
     * Representa la dirección del remitente
     */
    private transient InternetAddress from;
    /**
     * Representa el contexto completo del mensaje
     */
    private static String fullContext;
    /**
     * Representa el valor máximo de mensajes en la cola
     */
    private static int maxQueueSize = 20;

    /**
     * En cumplimiento de la firma que el petrón Singleton demanda para el
     * constructor de la clase
     */
    private MailEngine() {
    }

    /**
     * Obtiene una única instancia de MailEngine.
     *
     * @param fullContext el full context
     * @param maxQueueSize el max queue size
     * @return única instancia de MailEngine
     */
    public static MailEngine getInstance(String fullContextParam, int maxQueueSizeParam) {
        if(instance!=null) {
            return instance;
        }
        fullContext = fullContextParam;
        if (maxQueueSize < 1) {
            LOGGER.warn("No se especificó el tamaño máximo de la bolsa de correos, se usará un buffer de {} como tamaño por defecto", maxQueueSize);
        } else {
            maxQueueSize = maxQueueSizeParam;
        }
        instance = new MailEngine();
        return instance;
    }

    public JavaMailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setFrom(InternetAddress from) {
        this.from = from;
    }

    public InternetAddress getFrom() {
        return this.from;
    }

    public boolean getActive() {
        return this.active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Agrega el message.
     *
     * @param to el to
     * @param subject el subject
     * @param text el text
     */
    public void addMessage(String to, String subject, String text) {
        addMessage(to, subject, text, new File[0]);
    }

    /**
     * Agrega el message.
     *
     * @param to []
     * @param subject el subject
     * @param text el text
     */
    public void addMessage(String[] to, String subject, String text) {
        addMessage(to, null, subject, text, new File[0]);
    }

    /**
     * Agrega el message.
     *
     * @param to el to
     * @param bcc el bcc
     * @param subject el subject
     * @param text el text
     */
    public void addMessage(String to, String bcc, String subject, String text) {
        addMessage(to, bcc, subject, text, new File[0]);
    }

    /**
     * Agrega el message.
     *
     * @param to el to
     * @param subject el subject
     * @param text el text
     * @param attachments [] archivos adjuntos.
     */
    public void addMessage(String to, String subject, String text, File... attachments) {
        String[] too = {to};
        addMessage(too, null, subject, text, attachments);
    }

    /**
     * Agrega el message.
     *
     * @param to []
     * @param bcc []
     * @param subject el subject
     * @param text el text
     * @param attachments []
     */
    public void addMessage(String to, String[] bcc, String subject, String text, File... attachments) {
        String[] too = {to};
        addMessage(too, bcc, subject, text, attachments);
    }

    /**
     * Agrega el message.
     *
     * @param to el to
     * @param bcc el bcc
     * @param subject el subject
     * @param text el text
     * @param attachments []
     */
    public void addMessage(String to, String bcc, String subject, String text, File... attachments) {
        String[] too = {to};
        String[] bccArray = {bcc};
        addMessage(too, bccArray, subject, text, attachments);
    }

    /**
     * Agrega el message.
     *
     * @param to []
     * @param bcc []
     * @param subject el subject
     * @param text el text
     * @param attachments []
     */
    public void addMessage(String[] to, String[] bcc, String subject, String text, File... attachments) {
        addMsg(to, bcc, subject, text, attachments);
    }

    /**
     * Envía un conjunto de correos que han sido almacenados en un contenedor
     * temporal administrado por spring.
     */
    public void sendAllMessages() {
        try {
            this.sendAllMessagesHelper();
        } catch (Exception ex) {
            LOGGER.error("Error en el servicio de envio de correos electronicos", ex);
        }
    }

    /**
     * Arma una cadena de un url adecuado y ajustado al contexto actual del
     * aplicativo que incluye un parámetro llamado 'sid' igualado a una llave
     * aleatoria.
     *
     * @param key el key
     * @param path el path
     * @param message el message
     * @return String : url armado acorde al contexto actua
     */
//    public static String forgotPasswordURL(String context, String key) {
//        return buildURL(context, key, "content/common/forgotPassword.jsf?sid=", "Recupera claves");
//    }
    /**
     * Arma una cadena de un url adecuado y ajustado al contexto actual del
     * aplicativo que incluye un parámetro llamado 'sid' igualado a una llave
     * aleatoria
     *
     * @param context
     * @param key
     * @return String : url armado acorde al contexto actua
     */
//    public static String solicitaRegistroURL(String context, String key) {
//        return buildURL(context, key, "content/common/registro/CompletaRegistro.jsf?sid=", "Completar registro");
//    }
    /**
     * Arma una cadena de un url adecuado y ajustado al contexto actual del
     * aplicativo que incluye un parámetro llamado 'sid' igualado a una llave
     * aleatoria
     *
     * @param key Clave de identificación
     * @param path Path del URL
     * @param message Mensaje asociado.
     * @return String : url armado acorde al contexto actua
     */
    public static String buildURL(String key, String path, String message) {
        StringBuilder url = new StringBuilder();
        url.append("<a href='http:/"); // con una sola diagonal, ya que abajo se pone la otra
        url.append(fullContext); // P ej "/localhost:8080/skeleton/"
        url.append(path);
        url.append(key);
        url.append("'>");
        url.append(message);
        url.append("</a>");
        return url.toString();
    }

    /**
     * Arma una cadena de un url adecuado y ajustado al contexto actual del
     * aplicativo que incluye un parámetro llamado 'sid' igualado a una llave
     * aleatoria.
     *
     * @param key el key
     * @return String : url armado acorde al contexto actua
     */
    public static String armaURLRegister(String key) {
        StringBuilder url = new StringBuilder();
        url.append("<a href='http:/"); // con una sola diagonal, ya que abajo se pone la otra
        url.append(fullContext); // P ej "/localhost:8080/skeleton/"
        url.append("content/common/registro/RegUsuario.jsf?sid=");
        url.append(key);
        url.append("'>Confirma registro</a>");
        return url.toString();
    }

    /*
     * Utilería que revisa si la estructura de una correo electrónico es
     * correcta o no. En caso negativo, dispara una Excepción con tal
     * notificación. En caso afirmativo, termina sin mas aviso.
     *
     * @param mailCandidate @throws Exception
     */
//    public static void checkMailStructure(String mailCandidate) throws Exception {
//        if(mailCandidate.trim().length()<5) {
//            throw new Exception("Un correo debe tener más de 4 caracteres");
//        }
//
//        if(!ContextUtils.evalMalformedMail(mailCandidate)) {
//            throw new Exception("Correo mal formado, revise la estructura de su correo");
//        }
//    }
    /**
     * Retorna el texto contenido en el archivo que le es pasado como parámetro
     * formal. Busca el archivo a partir de la raiz del proyecto WEB.
     *
     * @param filename el filename
     * @return El text
     */
    public static String getText(String filename) {
        StringBuilder sb = new StringBuilder();
        InputStreamReader reader = null;
        try {
            reader = FileUtils.getInputStream(filename);
            int n;
            while ((n = reader.read()) != -1) {
                sb.append((char) n);
            }
        } catch (FileNotFoundException ex) {
            LOGGER.error("Error al recuperar texto", ex);
        } catch (IOException ex) {
            LOGGER.error("Error al recuperar texto", ex);
        } finally {
            FileUtils.close(reader);
        }
        return sb.toString();
    }

    /**
     * Retorna el texto contenido en el archivo que le es pasado como parámetro
     * formal. Busca el archivo a partir de la raiz del proyecto WEB.
     *
     * OJO La ruta: 'fileToBeRead' debe venir SIN '/' al principio ya que
     * Starter.getRealPath() trae '/' al final.
     *
     * @param realPath el real path
     * @param fileToBeRead el file to be read
     * @return El text
     */
    public static String getText(String realPath, String fileToBeRead) {
        return getText(realPath + fileToBeRead);
    }

    /**
     * Utilería de apoyo al envío (posiblemente masivo) de mensajes de correo
     * electrónico. Detecta si es requerido enviar mensajes y no en función del
     * estado de la bolsa de mensajes encolados. Adicionalmente, si la bandera
     * de 'activo' está en falso, sólo imprime en el log lo que se hubiera
     * enviado por correo, pero realmente no ocurre tal envío.
     *
     * @throws Exception Excepción general
     */
    private void sendAllMessagesHelper() throws Exception {
        if (mimeMessagesBag != null && mimeMessagesBag.size() > 0) {
            MimeMessage[] mimeMessages = mimeMessagesBag.toArray(new MimeMessage[1]);
            if (active) {
                String fecha = formatearFecha(new Date(), "dd/MM/yyyy HH:mm:ss");
                LOGGER.info("Enviando: {} mensajes. Con fecha: {}", new Object[]{mimeMessages.length, fecha});
                mailSender.send(mimeMessages);
            } else {
                LOGGER.info("El servicio de notificación de correo electrónico está inactivo !!!");
                for (MimeMessage mimeMessage : mimeMessages) {
                    LOGGER.info("Subject: {}", mimeMessage.getSubject());
                    Address[] recipients = mimeMessage.getRecipients(RecipientType.TO);
                    for (Address addr : recipients) {
                        LOGGER.info("--->{}", addr.toString());
                    }
                }
            }
            mimeMessagesBag.clear();
            LOGGER.info("Mensajes enviados !!!!!!!!!");
        }
    }

    /**
     * Envío de email con varios attachments
     *
     * @param to correo electrónico del destinatario
     * @param bcc Con copia para los destinatarios.
     * @param subject asunto del mensaje
     * @param text cuerpo del mensaje
     * @param attachments ficheros que se anexarán al mensaje
     *
     * @throws RuntimeException Exception
     */
    private void addMsg(String[] to, String[] bcc, String subject, String text, File... attachments) {
        /* asegurando la trazabilidad
        if (LOGGER.isDebugEnabled()) {
            final boolean usingPassword = !"".equals(mailSender.get);

            StringBuilder sb = new StringBuilder();
            sb.append("Sending email to: '");
            for (String para : to) {
                sb.append(para);
                sb.append(", ");
            }
            sb.append("' [through host: '");
            sb.append(mailSender.getHost());
            sb.append(":");
            sb.append(mailSender.getPort());
            sb.append("', username: '");
            sb.append(mailSender.getUsername());
            sb.append("' usingPassword:");
            sb.append(usingPassword);
            sb.append("].");

            LOGGER.debug(sb.toString());
        }*/

        // plantilla para el envío de email
        final MimeMessage message = mailSender.createMimeMessage();

        try {
            // el flag a true indica que va a ser multipart
            final MimeMessageHelper helper = new MimeMessageHelper(message, true);

            // settings de los parámetros del envío
            //message.setContent(mensaje, "text/html; charset=\"big5\"");
            helper.setTo(to);
            if (bcc != null) {
                helper.setBcc(bcc);
            }
            helper.setSubject(subject);
            helper.setFrom("no-reply@kebblar.io");//getFrom());

            // Hola                                    <pic>content/themes/images/icon_twitter.png</pic> Mundo
            // <img src='http://www.gus.com:8080/aplicativo/content/themes/images/icon_twitter.png' />
            String reemplazo = text;
            reemplazo = reemplazo.replaceAll("<pic>", "<img src='http:/" + fullContext);
            reemplazo = reemplazo.replaceAll("</pic>", "' />");
            helper.setText(reemplazo, true);

            // adjuntando los archivos indicados
            if (attachments != null && attachments.length > 0) {
                for (int i = 0; i < attachments.length; i++) {
                    FileSystemResource file = new FileSystemResource(attachments[i]);
                    helper.addAttachment(attachments[i].getName(), file);
                    if (LOGGER.isDebugEnabled()) {
                        LOGGER.debug("File '{}' attached.", file);
                    }
                }
            }

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        mimeMessagesBag.add(message);

        if (mimeMessagesBag.size() >= maxQueueSize) {
            LOGGER.info("La bolsa de correos ha llegado al límite permitido por la aplicación, se iniciará el envío de correos");
            sendAllMessages();
        }
    }

    public static String formatearFecha(Date date, String formato) {
        String fecha;
        SimpleDateFormat formateador = new SimpleDateFormat(formato);
        if (date == null) {
            fecha = "\\N";
        } else {
            fecha = formateador.format(date);
        }
        return fecha;
    }
    
/* *********************************************** 
    
    @Value("${mail.protocol}")
    private String protocol;
    
    @Value("${mail.starttls.enable}")
    private String starttls;
    
    @Value("${mail.host}")
    private String host;
    
    @Value("${mail.port}")
    private int port;
    
    @Value("${mail.username}")
    private String username;
    
    @Value("${mail.password}")
    private String password;
    
    @Value("{mail.smtp.auth}$")
    private String smtpAuth;    
    
    public JavaMailSender javaMailService() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setHost(this.host);
        javaMailSender.setPort(this.port);

        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    private Properties getMailProperties() {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "ture");
        properties.setProperty("mail.smtp.starttls.enable", "");
        properties.setProperty("mail.debug", "false");
        return properties;
    }    
    */
}// ends class
