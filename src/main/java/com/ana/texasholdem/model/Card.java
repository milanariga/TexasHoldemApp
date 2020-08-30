package com.ana.texasholdem.model;

import java.util.Comparator;

/**
 * @author Ana on 8/24/2020
 */
public class Card implements Comparable<Card> {

    private String suit;
    private Integer rank;

    public static final Comparator<Card> DESCENDING_ORDER = new Comparator<Card>() {
        public int compare(Card o1, Card o2) {
            return o2.getRank() - o1.getRank();
        }
    };

    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + suit;
    }

    public int compareTo(Card o) {
        return (this.getSuit()).compareTo(o.getSuit());
    }
}
