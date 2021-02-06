package ye.golovnya.streamr.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Validated
@Getter
@AllArgsConstructor
@ConstructorBinding
@ConfigurationProperties(prefix = "streamr.api")
public class ApplicationProperties {

    @NotEmpty
    private final String apiKey;
}
