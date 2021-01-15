package com.example.myTravel555_bot.repository;

import com.example.myTravel555_bot.model.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class DefaultTravelRepository implements TravelRepository {

    @Autowired
    private TravelJpaRepository travelJpaRepository;

    @Override
    public Travel getAnswerMessageRep(String message) {
        return travelJpaRepository.findByCity(message).orElse(null);
    }

    @Override

    public void deleteTravelRep(String message) {
        travelJpaRepository.deleteByCity(message);
    }

    @Override
    public boolean addTravelRep(Travel travel) {
        try {
            travelJpaRepository.save(travel);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void updateTravelRep(Travel travel) {
        travelJpaRepository.update(travel.getDescription(), travel.getCity());
    }

    @Override
    public List<Travel> getTravelRep() {
        return travelJpaRepository.findAll();
    }

    @Override
    public Travel checkTravelRep(Travel travel) {
        return travelJpaRepository.findByCity(travel.getCity()).orElse(null);
    }
}

