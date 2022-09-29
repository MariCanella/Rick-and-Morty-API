package com.webclient.rickandmortyapi.cliente;

import com.webclient.rickandmortyapi.resposta.RespostaChar;
import com.webclient.rickandmortyapi.resposta.RespostaEpisodio;
import com.webclient.rickandmortyapi.resposta.RespostaLocais;
import com.webclient.rickandmortyapi.resposta.RespostaNomeChar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@Slf4j
public class Cliente {
    private final WebClient webClient;

    public Cliente(WebClient.Builder builder){
        webClient = builder.baseUrl("https://rickandmortyapi.com/api").build();
    }

    public Mono<RespostaChar> findAndCharacterById(String id) {
        log.info("Buscando o personagem com o id [{}]", id);
        return webClient
                .get()
                .uri("/character/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error-> Mono.error(new RuntimeException(("Verifique os parametros informados"))))
                .bodyToMono(RespostaChar.class);
    }
    public Mono<RespostaLocais> findAndLocationById(String id) {
        log.info("Buscando a localização com o id [{}]", id);
        return webClient
                .get()
                .uri("/location/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(RespostaLocais.class);
    }
    public Mono<RespostaEpisodio> findAndEpisodioById(String id) {
        log.info("Buscando o episodio com o id [{}]", id);
        return webClient
                .get()
                .uri("/episode/" + id)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(RespostaEpisodio.class);
    }
    public Mono<RespostaNomeChar> findAndCharacterByName(String name) {
        log.info("Buscando o episodio com o nome [{}]", name);
        return webClient
                .get()
                .uri("/character/" + name)
                .accept(APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, error -> Mono.error(new RuntimeException("Verifique os parâmetros informados")))
                .bodyToMono(RespostaNomeChar.class);
    }
}
