package com.ana.texasholdem;

import com.ana.texasholdem.model.Card;
import com.ana.texasholdem.model.Player;
import com.ana.texasholdem.model.Table;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ana on 8/23/2020
 */
public class CombinationsTest {
    @Test
    public void testRemoveDuplicateRanks() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<Card>();
        inputCard.add(new Card("s", 14));
        inputCard.add(new Card("s", 14));
        inputCard.add(new Card("s", 13));
        inputCard.add(new Card("s", 12));
        inputCard.add(new Card("s", 11));
        inputCard.add(new Card("s", 10));
        inputCard.add(new Card("s", 10));
        List<Card> actualCards = comb.removeDuplicateRanks(inputCard);
        List<Card> expectedCards = new ArrayList<Card>();
        expectedCards.add(new Card("s", 14));
        expectedCards.add(new Card("s", 13));
        expectedCards.add(new Card("s", 12));
        expectedCards.add(new Card("s", 11));
        expectedCards.add(new Card("s", 10));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

    }

//    @Test
//    public void testRemoveDuplicateRanksWithSuitsChecking() {
//        Combinations comb = new Combinations();
//        List<Card> inputCard = new ArrayList<Card>();
//        inputCard.add(new Card("s", 14));
//        inputCard.add(new Card("h", 14));
//        inputCard.add(new Card("s", 13));
//        inputCard.add(new Card("s", 12));
//        inputCard.add(new Card("s", 11));
//        inputCard.add(new Card("c", 10));
//        inputCard.add(new Card("s", 10));
//        List<Card> actualCards = comb.removeDuplicateRanks(inputCard);
//        List<Card> expectedCards = new ArrayList<Card>();
//        expectedCards.add(new Card("s", 14));
//        expectedCards.add(new Card("s", 13));
//        expectedCards.add(new Card("s", 12));
//        expectedCards.add(new Card("s", 11));
//        expectedCards.add(new Card("s", 10));
//
//        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
//        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
//        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
//        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
//        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
//        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());
//
//        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
//        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
//        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
//        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
//        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());
//    }

    @Test
    public void testThreeOfAKind() {
        Combinations comb = new Combinations();
        Player player = new Player();
        List<Card> handCards = new ArrayList<>();
        handCards.add(new Card("d", 10));
        handCards.add(new Card("s", 7));
        player.setHandCards(handCards);
        List<Card> allCards = new ArrayList<>();
        allCards.add(new Card("c", 12));
        allCards.add(new Card("d", 11));
        allCards.add(new Card("c", 11));
        allCards.add(new Card("h", 11));
        allCards.add(new Card("d", 10));
        allCards.add(new Card("c", 7));
        allCards.add(new Card("s", 5));
        comb.isPairOrThree(player, allCards);
        List<Card> actualCards = player.getBestCombination();

        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("d", 11));
        expectedCards.add(new Card("c", 11));
        expectedCards.add(new Card("h", 11));
        expectedCards.add(new Card("c", 12));
        expectedCards.add(new Card("d", 10));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());
    }

    @Test
    public void testFullHouse() {
        Combinations comb = new Combinations();
        Player player = new Player();
        List<Card> handCards = new ArrayList<>();
        handCards.add(new Card("d", 10));
        handCards.add(new Card("s", 7));
        player.setHandCards(handCards);
        List<Card> allCards = new ArrayList<>();
        allCards.add(new Card("c", 12));
        allCards.add(new Card("d", 11));
        allCards.add(new Card("c", 11));
        allCards.add(new Card("h", 11));
        allCards.add(new Card("d", 10));
        allCards.add(new Card("c", 7));
        allCards.add(new Card("s", 7));
        comb.isPairOrThree(player, allCards);
        List<Card> actualCards = player.getBestCombination();

        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("d", 11));
        expectedCards.add(new Card("c", 11));
        expectedCards.add(new Card("h", 11));
        expectedCards.add(new Card("c", 7));
        expectedCards.add(new Card("s", 7));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());
    }

    @Test
    public void testTwoPairs() {
        Combinations comb = new Combinations();
        Player player = new Player();
        List<Card> handCards = new ArrayList<>();
        handCards.add(new Card("d", 10));
        handCards.add(new Card("s", 7));
        player.setHandCards(handCards);
        List<Card> allCards = new ArrayList<>();
        allCards.add(new Card("c", 12));
        allCards.add(new Card("d", 11));
        allCards.add(new Card("c", 11));
        allCards.add(new Card("h", 11));
        allCards.add(new Card("d", 10));
        allCards.add(new Card("c", 7));
        allCards.add(new Card("s", 7));
        comb.isPairOrThree(player, allCards);
        List<Card> actualCards = player.getBestCombination();

        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("d", 11));
        expectedCards.add(new Card("c", 11));
        expectedCards.add(new Card("h", 11));
        expectedCards.add(new Card("c", 7));
        expectedCards.add(new Card("s", 7));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());
    }

    @Test
    public void testGetOnePair() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("c", 12));
        inputCard.add(new Card("d", 9));
        inputCard.add(new Card("s", 8));
        inputCard.add(new Card("h", 8));
        inputCard.add(new Card("c", 7));
        inputCard.add(new Card("d", 5));
        List<Card> actualCards = comb.getPair(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("s", 8));
        expectedCards.add(new Card("h", 8));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
    }

    @Test
    public void testGetTwoPairs(){
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("c", 12));
        inputCard.add(new Card("d", 12));
        inputCard.add(new Card("s", 8));
        inputCard.add(new Card("h", 8));
        inputCard.add(new Card("c", 7));
        inputCard.add(new Card("d", 5));
        List<Card> actualCards = comb.getPair(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("c", 12));
        expectedCards.add(new Card("d", 12));
        expectedCards.add(new Card("s", 8));
        expectedCards.add(new Card("h", 8));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
    }

    @Test
    public void testGetThreeCombination() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("c", 12));
        inputCard.add(new Card("d", 8));
        inputCard.add(new Card("s", 8));
        inputCard.add(new Card("h", 8));
        inputCard.add(new Card("c", 7));
        inputCard.add(new Card("d", 5));
        List<Card> actualCards = comb.getThreeCombination(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("d", 8));
        expectedCards.add(new Card("s", 8));
        expectedCards.add(new Card("h", 8));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
    }

    @Test
    public void testIsFourOfKindFromThirdCard() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("c", 12));
        inputCard.add(new Card("d", 8));
        inputCard.add(new Card("s", 8));
        inputCard.add(new Card("h", 8));
        inputCard.add(new Card("c", 8));
        inputCard.add(new Card("d", 5));
        List<Card> actualCards = comb.isFourOfKind(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("d", 8));
        expectedCards.add(new Card("s", 8));
        expectedCards.add(new Card("h", 8));
        expectedCards.add(new Card("c", 8));
        expectedCards.add(new Card("d", 14));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());

    }

    @Test
    public void testIsNotFourOfKind() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("c", 12));
        inputCard.add(new Card("d", 8));
        inputCard.add(new Card("s", 8));
        inputCard.add(new Card("h", 8));
        inputCard.add(new Card("c", 7));
        inputCard.add(new Card("d", 5));
        List<Card> actualCards = comb.isFourOfKind(inputCard);
        List<Card> expectedCards = new ArrayList<>();

        assertEquals("List not empty", expectedCards.isEmpty(), actualCards.isEmpty());

    }

    @Test
    public void testIsFourOfKindFromSecondCard() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();

        inputCard.add(new Card("c", 12));
        inputCard.add(new Card("d", 8));
        inputCard.add(new Card("s", 8));
        inputCard.add(new Card("h", 8));
        inputCard.add(new Card("c", 8));
        inputCard.add(new Card("d", 7));
        inputCard.add(new Card("d", 5));
        List<Card> actualCards = comb.isFourOfKind(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("d", 8));
        expectedCards.add(new Card("s", 8));
        expectedCards.add(new Card("h", 8));
        expectedCards.add(new Card("c", 8));
        expectedCards.add(new Card("c", 12));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());

    }

    @Test
    public void testIsDiamondFlush() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("d", 12));
        inputCard.add(new Card("d", 11));
        inputCard.add(new Card("d", 4));
        inputCard.add(new Card("d", 2));
        List<Card> actualCards = comb.isFlush(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("d", 14));
        expectedCards.add(new Card("d", 12));
        expectedCards.add(new Card("d", 11));
        expectedCards.add(new Card("d", 4));
        expectedCards.add(new Card("d", 2));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());
    }

    @Test
    public void testIsNotFlush() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("d", 12));
        inputCard.add(new Card("d", 11));
        inputCard.add(new Card("c", 4));
        inputCard.add(new Card("d", 2));
        List<Card> actualCards = comb.isFlush(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        assertEquals("List not Empty", expectedCards.size(),actualCards.size());
    }

    @Test
    public void isStraight() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("c", 14));
        inputCard.add(new Card("d", 13));
        inputCard.add(new Card("s", 12));
        inputCard.add(new Card("h", 11));
        inputCard.add(new Card("d", 10));
        inputCard.add(new Card("d", 2));
        List<Card> actualCards = comb.isStraight(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("c", 14));
        expectedCards.add(new Card("d", 13));
        expectedCards.add(new Card("s", 12));
        expectedCards.add(new Card("h", 11));
        expectedCards.add(new Card("d", 10));

        assertEquals("Size not equal", expectedCards.size(), actualCards.size());
        assertEquals("0 element rank not equal", expectedCards.get(0).getRank(), actualCards.get(0).getRank());
        assertEquals("1 element rank not equal", expectedCards.get(1).getRank(), actualCards.get(1).getRank());
        assertEquals("2 element rank not equal", expectedCards.get(2).getRank(), actualCards.get(2).getRank());
        assertEquals("3 element rank not equal", expectedCards.get(3).getRank(), actualCards.get(3).getRank());
        assertEquals("4 element rank not equal", expectedCards.get(4).getRank(), actualCards.get(4).getRank());

        assertEquals("0 element suit not equal", expectedCards.get(0).getSuit(), actualCards.get(0).getSuit());
        assertEquals("1 element suit not equal", expectedCards.get(1).getSuit(), actualCards.get(1).getSuit());
        assertEquals("2 element suit not equal", expectedCards.get(2).getSuit(), actualCards.get(2).getSuit());
        assertEquals("3 element suit not equal", expectedCards.get(3).getSuit(), actualCards.get(3).getSuit());
        assertEquals("4 element suit not equal", expectedCards.get(4).getSuit(), actualCards.get(4).getSuit());
    }

    @Test
    public void testDefineRoyalFlash() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("d", 13));
        inputCard.add(new Card("d", 12));
        inputCard.add(new Card("d", 11));
        inputCard.add(new Card("d", 10));
        String expectedType = "Royal Flush";
        String actualType = comb.defineStraightType(inputCard);
        assertEquals("Not defining Royal Flush",expectedType,actualType);

    }

    @Test
    public void testDefineStraight() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("d", 14));
        inputCard.add(new Card("d", 13));
        inputCard.add(new Card("d", 12));
        inputCard.add(new Card("d", 11));
        inputCard.add(new Card("c", 10));
        String expectedType = "Straight";
        String actualType = comb.defineStraightType(inputCard);
        assertEquals("Not defining Royal Flush",expectedType,actualType);
    }

    @Test
    public void testDefineStraightFlush() {
        Combinations comb = new Combinations();
        List<Card> inputCard = new ArrayList<>();
        inputCard.add(new Card("c", 8));
        inputCard.add(new Card("c", 7));
        inputCard.add(new Card("c", 6));
        inputCard.add(new Card("c", 5));
        inputCard.add(new Card("c", 4));
        String expectedType = "Straight Flush";
        String actualType = comb.defineStraightType(inputCard);
        assertEquals("Not defining Royal Flush",expectedType,actualType);
    }

    @Test
    public void removeDuplicateRanks() {
    }
}