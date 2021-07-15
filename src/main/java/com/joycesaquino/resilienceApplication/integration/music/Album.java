package com.joycesaquino.resilienceApplication.integration.music;

import lombok.Data;

import java.time.Duration;

@Data
public class Album {

    //TODO Artist id 145 Album 244223
    Long id;
    String title;
    Duration duration;
    String link;
    Long fans;
}
