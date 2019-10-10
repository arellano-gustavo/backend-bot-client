package mx.gob.impi.chatbot.persistence.api.service;

import java.util.Calendar;
import java.util.Date;

import org.slf4j.*;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtManagerServiceImpl implements JwtManagerService {
    private static final Logger logger = LoggerFactory.getLogger(JwtManagerServiceImpl.class);
    private static final String ENCRYPT_KEY = "gustavo";
    
    @Override
    public String createToken(final String username) {
        byte[] key = ENCRYPT_KEY.getBytes();
        
        Calendar calendar = Calendar.getInstance();
        Date issued = calendar.getTime();
        
        calendar.add(Calendar.MINUTE, 50);// 50 minutes !!!!!!
        Date expiration = calendar.getTime();

        final JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuer("crypto-executor-jwtManager");
        jwtBuilder.setIssuedAt(issued);
        jwtBuilder.setSubject("Cool jwt Token on: " + System.currentTimeMillis());
        jwtBuilder.setId(username);
        jwtBuilder.setExpiration(expiration);
        String token = jwtBuilder.signWith(SignatureAlgorithm.HS256, key).compact();
        logger.debug("Token for '"+username+"' has been created: " + token);
        return token;
    }

    @Override
    public boolean verifyToken(String jwt, String user) {
        try {
            Claims claims = Jwts.parser()
               .setSigningKey(ENCRYPT_KEY.getBytes())
               .parseClaimsJws(jwt).getBody();
            logger.debug("ID: " + claims.getId());
            logger.debug("Subject: " + claims.getSubject());
            logger.debug("Issuer: " + claims.getIssuer());
            logger.debug("Expiration: " + claims.getExpiration());
            logger.debug("IssuedAt: " + claims.getIssuedAt());
            if(!user.equals(claims.getId())) {
            	logger.error("issuer not verfied !!!");
            	return false;
            }
        } catch(Exception e) {
            logger.error("Given token has not been verified. Error: " + e.getMessage());
            return false;
        }
        return true;
    }
}
