package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

import java.net.URI;
import java.util.List;

@Immutable
@Value
public class OpenApiResults {

    List<Result> results;

    @JsonCreator
    public OpenApiResults(@JsonProperty("results") List<Result> results) {
        this.results = results;
    }

    @Immutable
    @Value
    public static class Result {
        @JsonCreator
        public Result(@JsonProperty("name") String name,
                      @JsonProperty("picture") URI picture,
                      @JsonProperty("locations") List<Location> locations) {
            this.name = name;
            this.picture = picture;
            this.locations = locations;
        }

        String name;
        URI picture;
        List<Location> locations;
    }

    @Immutable
    @Value
    public static class Location {
        String displayName;
        String id;

        @JsonCreator
        public Location(@JsonProperty("display_name") String displayName,
                        @JsonProperty("id") String id) {
            this.displayName = displayName;
            this.id = id;
        }
    }
}
