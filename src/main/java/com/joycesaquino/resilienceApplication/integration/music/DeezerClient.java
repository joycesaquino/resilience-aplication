package com.joycesaquino.resilienceApplication.integration.music;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
public interface DeezerClient {
    @GetMapping("/album")
    Album getAlbum(Long id);

}
