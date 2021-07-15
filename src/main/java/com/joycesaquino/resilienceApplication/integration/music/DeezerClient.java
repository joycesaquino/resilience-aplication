package com.joycesaquino.resilienceApplication.integration.music;

import com.joycesaquino.resilienceApplication.model.Artist;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Component
public interface DeezerClient {
    @GetMapping("/album")
    Album getAlbum(Long id);

    default Optional<Album> getAlbumFallback(Long id, Artist artist) {

        return artist.getAlbums()
                .entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(id))
                .map(entry -> {
                    var album = new Album();
                    album.setId(entry.getKey());
                    album.setTitle(entry.getValue());
                    return album;
                }).findAny();
    }

}
