package com.example.myTravel555_bot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class MyTravelBot extends TelegramLongPollingBot {

    private final DefaultTravelService defaultTravelService;

    @Value("${myTravel555_bot.token}")
    private static final String TOKEN = "1523037892:AAFs72nuiGGGFjjOR1RVRmhPxF6o161g--E";

    @Value("${myTravel555_bot.username}")
    private static final String USERNAME = "myTravel555_bot";

    public MyTravelBot(DefaultTravelService defaultTravelService) {
        this.defaultTravelService = defaultTravelService;
    }

    public String getBotUsername() {
        return USERNAME;
    }

    public String getBotToken() {
        return TOKEN;
    }

    public void onUpdateReceived(Update update) {
        if (update.getMessage() != null && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();
            String message = update.getMessage().getText();
            String answerMessage = defaultTravelService.getAnswerMessageService(message);

            try {
                execute(new SendMessage(chat_id, answerMessage));
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
