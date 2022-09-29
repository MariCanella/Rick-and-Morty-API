package com.webclient.rickandmortyapi.resposta;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class RespostaEpisodio {
    private String id;
    private String name;
    private String episode;
    private String air_date;
    private List<String> characters;
    private String url;
}
