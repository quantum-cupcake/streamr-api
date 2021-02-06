package ye.golovnya.streamr.mappers;

import org.mapstruct.Mapper;
import ye.golovnya.streamr.dtos.OpenApiResults;
import ye.golovnya.streamr.dtos.SearchResults;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UtellyToSearchResultsMapper {

    default SearchResults apiToSearchResults(OpenApiResults openApiResults) {
        OpenApiResults.Result topResult = openApiResults.getResults().get(0);
        return new SearchResults(topResult.getName(), topResult.getLocations().get(0).getDisplayName(), topResult.getPicture());
    }

    List<SearchResults> apiResultsToSearchResult(Collection<OpenApiResults> openApiResults);
}
