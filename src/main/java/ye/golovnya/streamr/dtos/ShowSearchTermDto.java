package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

import javax.validation.constraints.NotNull;
import java.time.Year;

@Immutable
@Value
public class ShowSearchTermDto {

    String partialTitle;
    Year releaseYear;

    public ShowSearchTermDto(@JsonProperty("partialTitle") @NotNull String partialTitle,
                             @JsonProperty("releaseYear") Year releaseYear) {
        this.partialTitle = partialTitle;
        this.releaseYear = releaseYear;
    }
}
