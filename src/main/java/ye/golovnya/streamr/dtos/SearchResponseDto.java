package ye.golovnya.streamr.dtos;

import lombok.Value;
import org.springframework.data.annotation.Immutable;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Immutable
@Value
public class SearchResponseDto {

    List<SearchResults> searchResults;

    public SearchResponseDto(@NotNull List<SearchResults> searchResults) {
        this.searchResults = Collections.unmodifiableList(searchResults);
    }
}
