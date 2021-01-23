package com.orbitallcorp.hack21.cards.services;

import com.orbitallcorp.hack21.cards.domains.Card;
import com.orbitallcorp.hack21.cards.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public Card saveCard(Card card) {  //POST
        return cardRepository.save((card));
    }

    public List<Card> findAll() { //GET all

        List<Card> cards = new ArrayList<>();
        for (Card card : cardRepository.findAll()) {
            cards.add(card);
        }

        return cards;
    }

    public Optional<Card> findCardById(Long id) { return cardRepository.findById(id); } //GET id

    public void deleteCardById(Long id) { cardRepository.deleteById(id); }

    public Card alterCardById(Card card) {
        return cardRepository.save((card));
    };

    public Page<Card> findAllSort() {
        int page = 0;
        int size = 10;
        PageRequest pageRequest = PageRequest.of(
                page,
                size,
                Sort.Direction.ASC,
                "customerName");
        return new PageImpl(
                Collections.singletonList(cardRepository.findAll()),
                pageRequest, size);
    }

}