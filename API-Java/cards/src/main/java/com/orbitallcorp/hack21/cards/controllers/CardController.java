package com.orbitallcorp.hack21.cards.controllers;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class CardController {

    @Autowired
    private CardService cardService;

    @PostMapping //insert data in database h2-console, the id key its not necessary !
    public ResponseEntity<Card> saveCard(@RequestBody Card card) {
        Card savedCards = cardService.saveCard((card));

        return new ResponseEntity(savedCards, HttpStatus.CREATED);
    }

    @GetMapping // give you all the registers of database
    public ResponseEntity<List<Card>> findAll() {
        List<Card> cards = cardService.findAll();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}") // get an specific register by id, just put the id in endpoint
    public Optional<Card> findCardById(@PathVariable(value = "id") long id) {
        return cardService.findCardById(id);
    }

    @DeleteMapping("/{id}") // delete without return ! More easy  |>.<|. id is necessary in the endpoint
    public void deleteCardById(@PathVariable(value = "id") long id) {
        cardService.deleteCardById(id);
    }

    @PutMapping("/{id}")
    public Card alterProduct (@RequestBody Card card, @PathVariable(value = "id") long id) {
        return cardService.alterCardById(card);
    }
}
