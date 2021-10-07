package com.joycesaquino.resilienceApplication.integration.music;

import feign.Feign;
import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class DeezerFeign {

    @Bean
    DeezerClient deezerClient(@Value("${api.deezer.url}") String deezerURL) {
        return Feign.builder()
                .options(new Request.Options(150, TimeUnit.MILLISECONDS, 90, TimeUnit.MILLISECONDS, true))
                .target(DeezerClient.class, deezerURL);
    }

}