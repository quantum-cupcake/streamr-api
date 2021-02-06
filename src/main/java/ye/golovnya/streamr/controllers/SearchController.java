package ye.golovnya.streamr.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ye.golovnya.streamr.controllers.urls.SearchUrlConstants;
import ye.golovnya.streamr.dtos.SearchRequestDto;
import ye.golovnya.streamr.dtos.SearchResponseDto;
import ye.golovnya.streamr.services.SearchService;

@RestController
@RequestMapping(SearchUrlConstants.SEARCH)
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @PostMapping
    public ResponseEntity<SearchResponseDto> searchShows(@RequestBody SearchRequestDto searchRequestDto) {
        return ResponseEntity.ok(searchService.search(searchRequestDto.getSearchTerms()));
    }
}
