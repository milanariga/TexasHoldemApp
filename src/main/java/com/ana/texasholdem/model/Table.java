package com.ana.texasholdem.model;

import com.ana.texasholdem.PossibleValues;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana on 8/21/2020
 */
public class Table {

    private List<Card> tableCards = new ArrayList<Card>();
    private PossibleValues winValue;
    private List<Card> bestCombination;

    public Table(){}

    public Table (List<Card> tableCards){
        this.tableCards =  tableCards;
    }

    public PossibleValues getWinValue() {
        return winValue;
    }

    public void setWinValue(PossibleValues winValue) {
        this.winValue = winValue;
    }

    public List<Card> getTableCards() {
        return tableCards;
    }

    public void setTableCards(List<Card> tableCards) {
        this.tableCards = tableCards;
    }

    public List<Card> getBestCombination() {
        return bestCombination;
    }

    public void setBestCombination(List<Card> bestCombination) {
        this.bestCombination = bestCombination;
    }
}
