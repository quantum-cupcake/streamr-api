package ye.golovnya.streamr.services.impl;

import org.springframework.stereotype.Service;
import ye.golovnya.streamr.config.ApplicationProperties;
import ye.golovnya.streamr.dtos.SearchResponseDto;
import ye.golovnya.streamr.dtos.ShowSearchTermDto;
import ye.golovnya.streamr.feign.UtellyOpenApiClient;
import ye.golovnya.streamr.mappers.UtellyToSearchResultsMapper;
import ye.golovnya.streamr.services.SearchService;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SearchServiceUtellyImpl implements SearchService {

    private final UtellyToSearchResultsMapper utellyToSearchResultsMapper;
    private final UtellyOpenApiClient utellyOpenApiClient;
    private final String apiKey;

    public SearchServiceUtellyImpl(UtellyToSearchResultsMapper utellyToSearchResultsMapper,
                                   UtellyOpenApiClient utellyOpenApiClient,
                                   ApplicationProperties applicationProperties) {
        this.utellyToSearchResultsMapper = utellyToSearchResultsMapper;
        this.utellyOpenApiClient = utellyOpenApiClient;
        this.apiKey = applicationProperties.getApiKey();
    }

    @Override
    public SearchResponseDto search(Collection<ShowSearchTermDto> shows) {
        var allResults = shows.stream()
                .map(ShowSearchTermDto::getPartialTitle)
                .map(term -> utellyOpenApiClient.lookup(apiKey, term))
                .collect(Collectors.toList());
        return new SearchResponseDto(utellyToSearchResultsMapper.apiResultsToSearchResult(allResults));
    }

}
