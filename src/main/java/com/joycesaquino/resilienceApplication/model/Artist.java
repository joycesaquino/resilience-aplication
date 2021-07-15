package com.joycesaquino.resilienceApplication.model;

import lombok.Data;

import java.util.Map;

@Data
public class Artist {
    //TODO Artist id 145

    Long id;
    String name;
    String picture;
    Map<Long, String> albums;
}
