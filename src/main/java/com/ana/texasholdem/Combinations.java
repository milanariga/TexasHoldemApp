package com.ana.texasholdem;

import com.ana.texasholdem.model.Card;
import com.ana.texasholdem.model.Player;
import com.ana.texasholdem.model.Table;

import java.text.ParseException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Ana on 8/22/2020
 */
public class Combinations {

    private Object object;
    private List<Card> tableCards;

    public Combinations(){
    }

    public Combinations(Object object){
        this.object = object;
    }


    public Combinations(Object object, List<Card> tableCards) {
        this.object = object;
        this.tableCards = tableCards;
    }


    public void findBestTableCombination(Table table, List<Card> tableCards) {
        List<Card> allCards = new ArrayList<>();
        String winState;
        allCards.addAll(tableCards);
        Collections.sort(allCards, Card.DESCENDING_ORDER);
        List<Card> winningComb = isStraight(allCards);
        if (!winningComb.isEmpty()){
            winState = defineStraightType(winningComb);
            if (winState.equals("Royal Flush")){
                table.setWinValue(PossibleValues.ROYAL_FLUSH);
                table.setBestCombination(winningComb);
            }
            else if (winState.equals("Straight Flush")){
                table.setWinValue(PossibleValues.STRAIGHT_FLUSH);
                table.setBestCombination(winningComb);
            }
            else if (winState.equals("Straight")){
                table.setWinValue(PossibleValues.STRAIGHT);
                table.setBestCombination(winningComb);
            }
        }
        else {
            winningComb = isFlush(allCards);
            if (!winningComb.isEmpty()){
                table.setWinValue(PossibleValues.FLUSH);
                table.setBestCombination(winningComb);
            }
            else {
                winningComb = isFourOfKind(allCards);
                if (!winningComb.isEmpty()){
                    table.setWinValue(PossibleValues.FOUR_OF_A_KIND);
                    table.setBestCombination(winningComb);
                }
                else {
                    isPairOrThree(table,tableCards);
                    if (table.getWinValue() == null){
                        table.setWinValue(PossibleValues.HIGHCARD);
                        table.setBestCombination(tableCards);
                    }
                }
            }
        }
    }

    public void findBestPlayerCombination(Player player, List<Card> tableCards) throws ParseException {
        List<Card> allCards = new ArrayList<>();
        String winState;
        allCards.addAll(tableCards);
        allCards.addAll(player.getHandCards());
        Collections.sort(allCards, Card.DESCENDING_ORDER);
        List<Card> winningComb = isStraight(allCards);
        if (!winningComb.isEmpty()){
            winState = defineStraightType(winningComb);
            if (winState.equals("Royal Flush")){
                player.setWinValue(PossibleValues.ROYAL_FLUSH);
                player.setBestCombination(winningComb);
            }
            else if (winState.equals("Straight Flush")){
                player.setWinValue(PossibleValues.STRAIGHT_FLUSH);
                player.setBestCombination(winningComb);
            }
            else if (winState.equals("Straight")){
                player.setWinValue(PossibleValues.STRAIGHT);
                player.setBestCombination(winningComb);
            }
        }
        else {
            winningComb = isFlush(allCards);
            if (!winningComb.isEmpty()){
                player.setWinValue(PossibleValues.FLUSH);
                player.setBestCombination(winningComb);
            }
            else {
                winningComb = isFourOfKind(allCards);
                if (!winningComb.isEmpty()){
                    player.setWinValue(PossibleValues.FOUR_OF_A_KIND);
                    player.setBestCombination(winningComb);
                }
                else {
                    isPairOrThree(player,allCards);
                    if (player.getWinValue() == null){
                        player.setWinValue(PossibleValues.HIGHCARD);
                        allCards.remove(6);
                        allCards.remove(5);
                        player.setBestCombination(allCards);
                    }
                }
            }
        }
    }

    public Object isPairOrThree(Object object, List<Card> input){

        boolean threeFlag = false;

        List<Card> returnCombination = new ArrayList<>();
        List<Card> returnThree = new ArrayList<>();
        List<Card> pairCards;
        List<Card> threeCards = new ArrayList<>();
        List<Card> inputAfterThree = new ArrayList<>();
        List<Card> inputAfterPair = new ArrayList<>();

        threeCards = getThreeCombination(input);
        if (!threeCards.isEmpty()){
            threeFlag = true;
            returnThree.addAll(threeCards);

            inputAfterThree.addAll(input);
            inputAfterThree.removeAll(threeCards);
        }

        if (threeFlag == true){
            pairCards = getPair(inputAfterThree);
            if (!pairCards.isEmpty()){
                returnCombination.addAll(threeCards);
                returnCombination.addAll(pairCards);
                if (object instanceof Table){
                    ((Table) object).setWinValue(PossibleValues.FULL_HOUSE);
                    ((Table) object).setBestCombination(returnCombination);
                    return object;
                }
                else if (object instanceof Player) {
                    ((Player) object).setWinValue(PossibleValues.FULL_HOUSE);
                    ((Player) object).setBestCombination(returnCombination);
                    return object;
                }
            }
            else {
                if (object instanceof Table){
                    ((Table) object).setWinValue(PossibleValues.THREE_OF_A_KIND);
                    threeCards.add(inputAfterThree.get(0));
                    threeCards.add(inputAfterThree.get(1));
                    ((Table) object).setBestCombination(threeCards);

                    return object;
                }
                else if (object instanceof Player) {
                    ((Player) object).setWinValue(PossibleValues.THREE_OF_A_KIND);
                    threeCards.add(inputAfterThree.get(0));
                    threeCards.add(inputAfterThree.get(1));
                    ((Player) object).setBestCombination(threeCards);
                    return object;
                }

            }
        } else {
            pairCards = getPair(input);
            if (!pairCards.isEmpty()) {
                if (pairCards.size() == 4){
                    inputAfterPair.addAll(input);
                    inputAfterPair.removeAll(pairCards);
                    returnCombination.addAll(pairCards);
                    returnCombination.add(inputAfterPair.get(0));
                    if (object instanceof Table) {
                        ((Table) object).setWinValue(PossibleValues.TWO_PAIRS);
                        ((Table) object).setBestCombination(returnCombination);
                        return object;
                    } else if (object instanceof Player) {
                        ((Player) object).setWinValue(PossibleValues.TWO_PAIRS);
                        ((Player) object).setBestCombination(returnCombination);
                        return object;
                    }
                } else if (pairCards.size() == 2){
                    inputAfterPair.addAll(input);
                    inputAfterPair.removeAll(pairCards);
                    returnCombination.addAll(pairCards);
                    returnCombination.add(inputAfterPair.get(0));
                    returnCombination.add(inputAfterPair.get(1));
                    returnCombination.add(inputAfterPair.get(2));
                    if (object instanceof Table) {
                        ((Table) object).setWinValue(PossibleValues.PAIR);
                        ((Table) object).setBestCombination(returnCombination);
                        return object;
                    } else if (object instanceof Player) {
                        ((Player) object).setWinValue(PossibleValues.PAIR);
                        ((Player) object).setBestCombination(returnCombination);
                        return object;
                    }
                }
            }
        }
        return object;
    }

    public List<Card> getPair(List<Card> input){
        List<Card> pair = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).getRank() == input.get(i+1).getRank()) {
                pair.add(input.get(i));
                pair.add(input.get(i+1));
            }
        }
        return pair;
    }

    public List<Card> getThreeCombination(List<Card> input){
        int count = 1;
        List<Card> threeCards = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).getRank() == input.get(i+1).getRank()) {
                count++;
                if (count==3){
                    threeCards.add(input.get(i-1));
                    threeCards.add(input.get(i));
                    threeCards.add(input.get(i+1));
                    return threeCards;
                }
            }
            else {
                count = 1;
            }
        }
        return threeCards;
    }

    public List<Card> isFourOfKind (List<Card> input){
        List<Card> fourOfKind = new ArrayList<>();
        if (input.get(0).getRank() == input.get(3).getRank()){
            fourOfKind.add(input.get(0));
            fourOfKind.add(input.get(1));
            fourOfKind.add(input.get(2));
            fourOfKind.add(input.get(3));
            fourOfKind.add(input.get(4));
        }
        else if (input.get(1).getRank() == input.get(4).getRank()){
            fourOfKind.add(input.get(1));
            fourOfKind.add(input.get(2));
            fourOfKind.add(input.get(3));
            fourOfKind.add(input.get(4));
            fourOfKind.add(input.get(0));
        }
        else if (input.size() > 5){
            if(input.get(2).getRank() == input.get(5).getRank()){
                fourOfKind.add(input.get(2));
                fourOfKind.add(input.get(3));
                fourOfKind.add(input.get(4));
                fourOfKind.add(input.get(5));
                fourOfKind.add(input.get(0));
            }
            else if(input.get(3).getRank() == input.get(6).getRank()){
                fourOfKind.add(input.get(3));
                fourOfKind.add(input.get(4));
                fourOfKind.add(input.get(5));
                fourOfKind.add(input.get(6));
                fourOfKind.add(input.get(0));
            }
        }
        return fourOfKind;
    }


    public List<Card> isFlush(List<Card> input){
        List<Card> flush = new ArrayList<>();
        List<Card> spades = input.stream()
                            .filter(c -> c.getSuit().equals("s"))
                            .collect(Collectors.toList());
        List<Card> clubs = input.stream()
                .filter(c -> c.getSuit().equals("c"))
                .collect(Collectors.toList());
        List<Card> hearts = input.stream()
                .filter(c -> c.getSuit().equals("h"))
                .collect(Collectors.toList());
        List<Card> diamonds = input.stream()
                .filter(c -> c.getSuit().equals("d"))
                .collect(Collectors.toList());
        if (spades.size() >= 5){
            return spades;
        }
        else if (clubs.size() >= 5){
            return clubs;
        }
        else if (diamonds.size() >= 5){
            return diamonds;
        }
        else if (hearts.size() >= 5){
            return hearts;
        } else {

            return flush;
        }
    }

    public List<Card> isStraight(List<Card> input){
        List<Card> straight = new ArrayList<>();
        int skippedCards = 0;
        removeDuplicateRanks(input);
        if (input.size() < 5){
            return straight;
        }
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).getRank()  == input.get(i+1).getRank() + 1 ||
                    (input.get(i).getRank() == 14 && input.get(i+1).getRank() == 5) ||
                    (input.get(i).getRank() == 14 && input.get(i+2).getRank() == 5) ||
                    (input.get(i).getRank() == 14 && input.get(i+3).getRank() == 5 && input.get(i+2).getRank() != 6)){
                if (straight.isEmpty()){
                    straight.add(input.get(i));
                    if (input.get(i).getRank() == 14 && input.get(i+1).getRank() == 5){
                        straight.add(input.get(i+1));
                    }
                    else if (input.get(i).getRank() == 14 && input.get(i+2).getRank() == 5){
                        straight.add(input.get(i+2));
                    }
                    else if (input.get(i).getRank() == 14 && input.get(i+3).getRank() == 5
                            && input.get(i+2).getRank() != 6){
                        straight.add(input.get(i+3));
                    }
                    else {
                        straight.add(input.get(i + 1));
                    }
                }
                else {
                    straight.add(input.get(i+1));
                }
            } else {
                skippedCards++;
                if (skippedCards > input.size() - 5){
                    straight.clear();
                    return straight;
                }
            }
            if (straight.size() == 5){
                return straight;
            }
        }
        return straight;

    }

    public String defineStraightType(List<Card> input){
        String straightType;
        if (input.get(0).getSuit().equals(input.get(1).getSuit()) &&
                input.get(1).getSuit().equals(input.get(2).getSuit()) &&
                input.get(2).getSuit().equals(input.get(3).getSuit()) &&
                input.get(3).getSuit().equals(input.get(4).getSuit())){
            if (input.get(0).getRank() == 14 && input.get(1).getRank() == 13){
                straightType = "Royal Flush";
            }
            else {
                straightType = "Straight Flush";
            }
        }
        else{
            straightType = "Straight";
        }
        return straightType;
    }

    public List<Card> removeDuplicateRanks(List<Card> input){
        List<Card> withoutDupl = new ArrayList<>();
        for (int i = 0; i < input.size() - 1; i++) {
            if (input.get(i).getRank() != input.get(i+1).getRank()){
                withoutDupl.add(input.get(i));
                if (i == input.size() - 2){
                    withoutDupl.add(input.get(i+1));
                }
            }
//            else if (input.get(i).getRank() == input.get(i+1).getRank()){
//                if (i != 0){
//                    if (input.get(i-1).getSuit() == input.get(i).getSuit()){
//                        Card tempCard = new Card(input.get(i).getSuit(), input.get(i).getRank());
//                        input.remove(i);
//                        input.add(i+1, tempCard);
//                    }
//                    else if (input.get(i-1).getSuit() == input.get(i+1).getSuit()){
//                        Card tempCard = new Card(input.get(i+1).getSuit(), input.get(i+1).getRank());
//                        input.remove(i);
//                        input.add(i, tempCard);
//                    }
//                }
//                else if (i==0){
//                    if (input.get(i).getSuit() == input.get(i+2).getSuit()){
//                        Card tempCard = new Card(input.get(i).getSuit(), input.get(i).getRank());
//                        input.remove(i);
//                        input.add(i+1, tempCard);
//                    }
//                }
//            }
            if (i == input.size() - 2) {
                withoutDupl.add(input.get(i));
            }
        }
        return withoutDupl;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public List<Card> getTableCards() {
        return tableCards;
    }

    public void setTableCards(List<Card> tableCards) {
        this.tableCards = tableCards;
    }

}
