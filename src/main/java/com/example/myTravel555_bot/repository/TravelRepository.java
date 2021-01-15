package com.example.myTravel555_bot.repository;

import com.example.myTravel555_bot.model.Travel;

import java.util.List;

public interface TravelRepository {

    Travel getAnswerMessageRep(String message);

    void deleteTravelRep(String message);

    boolean addTravelRep(Travel travel);

    void updateTravelRep(Travel travel);

    List<Travel> getTravelRep();

    Travel checkTravelRep(Travel travel);
}
