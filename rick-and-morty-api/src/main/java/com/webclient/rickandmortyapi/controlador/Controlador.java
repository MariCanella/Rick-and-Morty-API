package com.webclient.rickandmortyapi.controlador;

import com.webclient.rickandmortyapi.cliente.Cliente;
import com.webclient.rickandmortyapi.resposta.RespostaChar;
import com.webclient.rickandmortyapi.resposta.RespostaEpisodio;
import com.webclient.rickandmortyapi.resposta.RespostaLocais;
import com.webclient.rickandmortyapi.resposta.RespostaNomeChar;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/webClient")
public class Controlador {
    Cliente cliente;

    @GetMapping("/characters/{id}")
    public Mono<RespostaChar> getCharacterById(@PathVariable String id){
        return cliente.findAndCharacterById(id);
    }
    @GetMapping("/location/{id}")
    public Mono<RespostaLocais> getLocationById(@PathVariable String id){
        return cliente.findAndLocationById(id);
    }
    @GetMapping("/episode/{id}")
    public Mono<RespostaEpisodio> getEpisodioById(@PathVariable String id){
        return cliente.findAndEpisodioById(id);
    }
    @GetMapping("/characters/name/{name}")
    public Mono<RespostaNomeChar> getCharacterByName(@PathVariable String name) {
        return cliente.findAndCharacterByName(name);
    }

}
