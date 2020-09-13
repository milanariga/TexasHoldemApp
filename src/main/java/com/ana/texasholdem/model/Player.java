package com.ana.texasholdem.model;

import com.ana.texasholdem.PossibleValues;

import java.util.List;

/**
 * @author Ana on 8/21/2020
 */
public class Player {

    private List<Card> handCards;
    private List<Card> bestCombination;
    private PossibleValues winValue;
    private boolean equalWithPrevious = false;

    public Player(){}

    public Player (List<Card> handCards){
        this.handCards = handCards;
    }

    public boolean isEqualWithPrevious() {
        return equalWithPrevious;
    }

    public void setEqualWithPrevious(boolean equalWithPrevious) {
        this.equalWithPrevious = equalWithPrevious;
    }

    public PossibleValues getWinValue() {
        return winValue;
    }

    public void setWinValue(PossibleValues winValue) {
        this.winValue = winValue;
    }



    public List<Card> getHandCards() {
        return handCards;
    }

    public void setHandCards(List<Card> handCards) {
        this.handCards = handCards;
    }

    public List<Card> getBestCombination() {
        return bestCombination;
    }

    public void setBestCombination(List<Card> bestCombination) {
        this.bestCombination = bestCombination;
    }

}
