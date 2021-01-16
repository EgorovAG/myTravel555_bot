package com.example.myTravel555_bot.repository;

import com.example.myTravel555_bot.model.Travel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class DefaultTravelRepository implements TravelRepository {

    private static final Logger log = LoggerFactory.getLogger(DefaultTravelRepository.class);

    @Autowired
    private TravelJpaRepository travelJpaRepository;

    @Override
    public Travel getAnswerMessageRep(String message) {
        try {
            Travel travel = travelJpaRepository.findByCity(message).orElseThrow(() -> new Exception("Travel not found"));
            log.info("Travel with city {} read", message);
            return travel;
        } catch (Exception e) {
            log.info("Fail to read Travel");
            return null;
        }
    }

    @Override

    public void deleteTravelRep(String city) {
        try {
            travelJpaRepository.deleteByCity(city);
            log.info("Travel with city {} deleted", city);
        } catch (Exception e) {
            log.error("Fail to delete Travel");
        }
    }

    @Override
    public boolean addTravelRep(Travel travel) {
        try {
            travelJpaRepository.save(travel);
            log.info("Travel with city {} added", travel.getCity());
            return true;
        } catch (Exception e) {
            log.error("Fail to add Travel with city {} ", travel.getCity());
            return false;
        }
    }

    @Override
    public void updateTravelRep(Travel travel) {
        try {
            travelJpaRepository.update(travel.getDescription(), travel.getCity());
            log.info("Travel with city {} updated", travel.getCity());
        } catch (Exception e) {
            log.error("Fail to update Travel with city {} ", travel.getCity());
        }
    }

    @Override
    public List<Travel> getTravelRep() {
        try {
            List<Travel> travels = travelJpaRepository.findAll();
            log.info("List<Travel> read");
            return travels;
        } catch (Exception e) {
            log.error("Fail to get List<Travel> ");
            return null;
        }
    }

    @Override
    public Travel checkTravelRep(Travel travel) {
        try {
            Travel travel1 = travelJpaRepository.findByCity(travel.getCity()).orElseThrow(() -> new Exception("Travel not found"));
            log.info("Travel with city {} read", travel.getCity());
            return travel1;
        } catch (Exception e) {
            log.info("Fail to read Travel");
            return null;
        }
    }
}

