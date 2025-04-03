package Strategies;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {
    Move suggestMove(Board board);
}