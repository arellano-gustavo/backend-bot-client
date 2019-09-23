package mx.gob.impi.chatbot.persistence.api.service;

public interface ChatbotMailSender {
    void sendMail(String from, String to, String subject, String body);
}
