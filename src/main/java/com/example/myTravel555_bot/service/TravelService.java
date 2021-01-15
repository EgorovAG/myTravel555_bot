package com.example.myTravel555_bot.service;

import com.example.myTravel555_bot.model.Travel;

import java.util.List;

public interface TravelService {

    String getAnswerMessageService(String message);

    void deleteTravelService(String message);

    boolean addTravelService(Travel travel);

    void updateTravelService(Travel travel);

    List<Travel> getTravelService();

    boolean checkTravel(Travel travel);

}
