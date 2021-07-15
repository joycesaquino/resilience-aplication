package com.joycesaquino.resilienceApplication.integration.music;

import com.joycesaquino.resilienceApplication.model.Artist;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public interface DeezerClient {
    @GetMapping("/album")
    @CircuitBreaker(name = "deezer", fallbackMethod = "getAlbumFallback")
    Album getAlbum(Long id);

    default Album getAlbumFallback(Long id, Artist artist) {
        var album = new Album();
        album.setId(id);
        album.setTitle(artist.getAlbums().get(id));
        return album;
    }

}
