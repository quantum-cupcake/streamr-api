package ye.golovnya.streamr.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;
import org.springframework.data.annotation.Immutable;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Immutable
@Value
public class SearchRequestDto {

    List<ShowSearchTermDto> searchTerms;

    public SearchRequestDto(@JsonProperty("searchTerms") @NotNull List<ShowSearchTermDto> searchTerms) {
        this.searchTerms = Collections.unmodifiableList(searchTerms);
    }
}
