package com.example.demo.controller;

import com.example.demo.model.Card;
import com.example.demo.model.Person;
import com.example.demo.service.CardService;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/card")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Card> cardMono) {
        return cardService.insert(cardMono);
    }

    @GetMapping("/{id}")
    public Mono<Card> getCard(@PathVariable("id") String id) {
        return Mono.just(new Card());
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Card> cardMono) {
        return Mono.empty();
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") String id) {
        return Mono.empty();
    }

    @GetMapping
    public Flux<Card> list() {
        return cardService.listAll();
    }

    @GetMapping("/type/{type}")
    public Flux<Card> listByFilter(@PathVariable("type") String type) {
        return cardService.listAll().filter(el -> el.getType().equals(type));
    }
}
