package com.example.myTravel555_bot.service;

import com.example.myTravel555_bot.model.Travel;
import com.example.myTravel555_bot.repository.DefaultTravelRepository;
import com.example.myTravel555_bot.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultTravelService implements TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Transactional
    @Override
    public String getAnswerMessageService(String message) {
        Travel travel = travelRepository.getAnswerMessageRep(message);
        List<Travel> travelRep = travelRepository.getTravelRep();
        if (message.equals("/start"))
            return "Hello, enter cities";
        if (travel == null) {
            return "There is no such city in the database \n Choose a city from this list: \n" +
                    travelRep.stream().map(Travel::getCity).collect(Collectors.toList());
        } else {
            return travel.getDescription();
        }
    }

    @Transactional
    @Override
    public void deleteTravelService(String city) {
        travelRepository.deleteTravelRep(city);
    }

    @Transactional
    @Override
    public boolean addTravelService(Travel travel) {
        return travelRepository.addTravelRep(travel);
    }

    @Transactional
    @Override
    public void updateTravelService(Travel travel) {
        travelRepository.updateTravelRep(travel);
    }

    @Transactional
    @Override
    public List<Travel> getTravelService() {
        return travelRepository.getTravelRep();
    }

    @Transactional
    @Override
    public boolean checkTravel(Travel travel) {
        Travel travelRes = travelRepository.checkTravelRep(travel);
        return travelRes != null;
    }
}

