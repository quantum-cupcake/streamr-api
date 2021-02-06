package ye.golovnya.streamr.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import ye.golovnya.streamr.dtos.OpenApiResults;

@FeignClient(name = "utelly", url = "https://utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com")
public interface UtellyOpenApiClient {

    @GetMapping("/lookup")
    OpenApiResults lookup(@RequestHeader(name = "x-rapidapi-key") String apiKey, @RequestParam("term") String term);

}
