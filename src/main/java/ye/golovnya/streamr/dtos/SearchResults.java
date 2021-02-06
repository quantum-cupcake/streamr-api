package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

import java.net.URI;

@Immutable
@Value
public class SearchResults {

    String title;
    String serviceName;
    URI image;

    @JsonCreator
    public SearchResults(@JsonProperty("title") String title,
                         @JsonProperty("serviceName") String serviceName,
                         @JsonProperty("image") URI image) {
        this.title = title;
        this.serviceName = serviceName;
        this.image = image;
    }

}
