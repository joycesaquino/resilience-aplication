package com.joycesaquino.resilienceApplication.integration.music;

import com.joycesaquino.resilienceApplication.model.Artist;
import feign.Param;
import feign.RequestLine;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;

@Component
public interface DeezerClient {
    @RequestLine("GET /album")
    @CircuitBreaker(name = "deezer", fallbackMethod = "getAlbumFallback")
    Album getAlbum(@Param Long id);

    default Album getAlbumFallback(Long id, Artist artist) {
        var album = new Album();
        album.setId(id);
        album.setTitle(artist.getAlbums().get(id));
        return album;
    }
}
