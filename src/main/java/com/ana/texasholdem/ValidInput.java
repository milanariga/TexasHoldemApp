package com.ana.texasholdem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana on 8/30/2020
 */
public class ValidInput {

    private static final List<String> cards;

    static {
        cards = new ArrayList<>();
        cards.add("2s");
        cards.add("2d");
        cards.add("2c");
        cards.add("2h");
        cards.add("3s");
        cards.add("3d");
        cards.add("3c");
        cards.add("3h");
        cards.add("4s");
        cards.add("4d");
        cards.add("4c");
        cards.add("4h");
        cards.add("5s");
        cards.add("5d");
        cards.add("5c");
        cards.add("5h");
        cards.add("6s");
        cards.add("6d");
        cards.add("6c");
        cards.add("6h");
        cards.add("7s");
        cards.add("7d");
        cards.add("7c");
        cards.add("7h");
        cards.add("8s");
        cards.add("8d");
        cards.add("8c");
        cards.add("8h");
        cards.add("9s");
        cards.add("9d");
        cards.add("9c");
        cards.add("9h");
        cards.add("Ts");
        cards.add("Td");
        cards.add("Tc");
        cards.add("Th");
        cards.add("Js");
        cards.add("Jd");
        cards.add("Jc");
        cards.add("Jh");
        cards.add("Qs");
        cards.add("Qd");
        cards.add("Qc");
        cards.add("Qh");
        cards.add("Ks");
        cards.add("Kd");
        cards.add("Kc");
        cards.add("Kh");
        cards.add("As");
        cards.add("Ad");
        cards.add("Ac");
        cards.add("Ah");
    }
    public static boolean isValidCard(String card){
        return cards.contains(card);
    }
    public static String validateInput(String cardsCombination){
        for (String card : cards) {
            cardsCombination = cardsCombination.replaceAll(card,"");
        }
        cardsCombination = cardsCombination.replaceAll(" ", "");
        return cardsCombination;
    }
}
