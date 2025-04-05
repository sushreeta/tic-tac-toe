package Strategies;

import Models.Level;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(Level level){
        BotPlayingStrategy botPlayingStrategy = new EasyBotPlayingStrategy();
        switch(level){
            case EASY: {
                botPlayingStrategy = new EasyBotPlayingStrategy();
                break;
            }
            case MEDIUM: {
                thow new IllegalArguementException();
                break;
            }
        }
        return botPlayingStrategy;
    }
}