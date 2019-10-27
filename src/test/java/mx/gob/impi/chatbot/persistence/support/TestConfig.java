package mx.gob.impi.chatbot.persistence.support;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan("mx.gob.impi.chatbot.persistence")
@MapperScan("mx.gob.impi.chatbot.persistence.api.db")
@SpringBootConfiguration
@EnableEncryptableProperties
public class TestConfig {

}
