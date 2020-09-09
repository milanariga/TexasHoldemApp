package com.ana.texasholdem;

import com.ana.texasholdem.model.Card;
import com.ana.texasholdem.model.Player;
import com.ana.texasholdem.model.Table;
import com.google.common.base.CharMatcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.*;

/**
 * @author Ana on 8/21/2020
 */
public class TexasHoldemApp {
    public static void main(String[] args) throws ParseException {
        try{
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(in);
            String line;

            while ((line = input.readLine()) != null){
                if (line.isEmpty()){
                    System.exit(0);
                }
                String validatedInput = ValidInput.validateInput(line);
                if (!validatedInput.isEmpty()){
                    System.out.println("Not acceptable symbols found in the input line");
                    continue;
                }
                List<Player> players = new ArrayList<>();
                line = removeSpaces(line);
                //System.out.println(line);
                int numOfPlayers = getNumberOfPlayers(line);

                Table table = new Table();
                List<Card> tableCards = getListOfCards(line.substring(0,10));
                Collections.sort(tableCards, Card.DESCENDING_ORDER);
                table.setTableCards(tableCards);
                Combinations comb = new Combinations();
                comb.findBestTableCombination(table,tableCards);
                System.out.println(table.getWinValue());
                System.out.println(table.getBestCombination().toString());

                for (int i = 0; i < numOfPlayers; i++) {
                    List<Card> playerCards = getListOfCards(line.substring(11 + 5*i, 11 + 5*i +4));
                    Player player = new Player();
                    player.setHandCards(playerCards);
                    comb.findBestPlayerCombination(player, table.getTableCards());
                    System.out.println(player.getWinValue());
                    System.out.println(player.getBestCombination());
                    players.add(player);
                }
                comparePlayerCombinations(players);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void comparePlayerCombinations(List<Player> allPlayers){

        Collections.sort(allPlayers, new Comparator<Player>(){
            @Override
            public int compare(Player o1, Player o2) {
                int i = o1.getWinValue().getValue() - o2.getWinValue().getValue();
                if (i==0){
                    if (o1.getWinValue() == PossibleValues.STRAIGHT
                            || o1.getWinValue() == PossibleValues.STRAIGHT_FLUSH
                            && (o1.getBestCombination().get(0).getRank() == 14
                                && o1.getBestCombination().get(1).getRank() == 5)){
                        i = 0 - o2.getBestCombination().get(0).getRank();
                    } else {
                        i = o1.getBestCombination().get(0).getRank() - o2.getBestCombination().get(0).getRank();
                        if (i == 0) {
                            i = o1.getBestCombination().get(1).getRank() - o2.getBestCombination().get(1).getRank();
                            if (i == 0) {
                                i = o1.getBestCombination().get(2).getRank() - o2.getBestCombination().get(2).getRank();
                                if (i == 0) {
                                    i = o1.getBestCombination().get(3).getRank() - o2.getBestCombination().get(3).getRank();
                                    if (i == 0) {
                                        i = o1.getBestCombination().get(4).getRank() - o2.getBestCombination().get(4).getRank();
                                    }
                                }
                            }
                        }
                    }
                }
                if (i==0){
                    o1.setLowerThenTable(true);
                    o2.setLowerThenTable(true);
                    i = o1.getHandCards().get(0).getRank() - o2.getHandCards().get(0).getRank();
                    if (i==0) {
                        i = o1.getHandCards().get(0).getSuit().compareTo(o2.getHandCards().get(0).getSuit());
                    }
                }
                return i;
            }
        });
        printResult(allPlayers);
    }

    public static void printResult(List<Player> allPlayers){
        String result = "";
        for (Player p : allPlayers){
            if (p.isLowerThenTable() == true){
                result = result + "=" + p.getHandCards().get(0).toString() + p.getHandCards().get(1).toString();
            } else {
                result = result + " " + p.getHandCards().get(0).toString() + p.getHandCards().get(1).toString();
            }
        }
        result = replaceNumericToRank(result);
        result = result.replaceFirst("=", " ");
        result = CharMatcher.whitespace().trimLeadingFrom(result);

        System.out.println(result);
    }

    public static int getNumberOfPlayers(String line){
        return CharMatcher.is(' ').countIn(line);
    }

    public static String removeSpaces(String input){
        return input.trim().replaceAll(" +", " ");
    }

    public static List<Card> getListOfCards(String input){
        List<Card> cards = new ArrayList<Card>();
        String card;
        for (int i = 0; i < input.length()/2; i++) {

            card = input.substring(i * 2, i * 2 + 2);
            String cardRank = card.substring(0,1);
            int replacedCardRank;
            if (cardRank.equals("T") ||
                    cardRank.equals("J") ||
                    cardRank.equals("Q") ||
                    cardRank.equals("K") ||
                    cardRank.equals("A")){
                replacedCardRank = Integer.parseInt(replaceRankToNumeric(cardRank));
            }
            else {
                replacedCardRank = Integer.parseInt(cardRank);
            }
            Card newCard = new Card(card.substring(1,2), replacedCardRank);
            cards.add(newCard);

        }
        return cards;
    }

    public static String replaceRankToNumeric(String inCard){
        String newElem = "";
        if (inCard.contains("T")){
            newElem = inCard.replace("T", "10");
        }
        else if (inCard.contains("J")){
            newElem = inCard.replace("J", "11");
        }
        else if (inCard.contains("Q")){
            newElem = inCard.replace("Q", "12");
        }
        else if (inCard.contains("K")){
            newElem = inCard.replace("K", "13");
        }
        else if (inCard.contains("A")){
            newElem = inCard.replace("A", "14");
        }
        return newElem;
    }

    public static String replaceNumericToRank(String inCard){
        if (inCard.contains("10")){
            inCard = inCard.replaceAll("10", "T");
        }
        if (inCard.contains("11")){
            inCard = inCard.replaceAll("11", "J");
        }
        if (inCard.contains("12")){
            inCard = inCard.replaceAll("12", "Q");
        }
        if (inCard.contains("13")){
            inCard = inCard.replaceAll("13", "K");
        }
        if (inCard.contains("14")){
            inCard = inCard.replaceAll("14", "A");
        }
        return inCard;
    }


}

