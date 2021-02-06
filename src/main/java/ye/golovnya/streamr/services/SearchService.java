package ye.golovnya.streamr.services;

import ye.golovnya.streamr.dtos.SearchResponseDto;
import ye.golovnya.streamr.dtos.ShowSearchTermDto;

import java.util.Collection;

public interface SearchService {

    SearchResponseDto search(Collection<ShowSearchTermDto> shows);
}
