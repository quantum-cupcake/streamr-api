package ye.golovnya.streamr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ye.golovnya.streamr.config.ApplicationProperties;

@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties(ApplicationProperties.class)
public class StreamrApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreamrApplication.class, args);
    }

}
