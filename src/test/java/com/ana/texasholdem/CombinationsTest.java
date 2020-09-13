package com.ana.texasholdem;

import com.ana.texasholdem.model.Card;
import com.ana.texasholdem.model.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ana on 8/23/2020
 */
public class CombinationsTest {

    @Test
    public void testRemoveDuplicates() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AsAdKsQsJsTdTs");
        List<Card> actualCards = comb.removeDuplicateRanks(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("AsKsQsJsTs");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }

    @Test
    public void testRemoveDuplicates2() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AsAdKsQsTcTdTs");
        List<Card> actualCards = comb.removeDuplicateRanks(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("AsKsQsTs");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }
    @Test
    public void testRemoveDuplicates3() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AsAdAcKsKdQsTcTdTs");
        List<Card> actualCards = comb.removeDuplicateRanks(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("AsKsQsTs");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }

    @Test
    public void testRemoveDuplicates4() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdAsAcAhKsKdQsTcTdTs");
        List<Card> actualCards = comb.removeDuplicateRanks(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("AsKsQsTs");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }


    @Test
    public void testThreeOfAKind() {
        Combinations comb = new Combinations();
        Player player = new Player();
        List<Card> handCards = TexasHoldemApp.getListOfCards("Td7s");

        player.setHandCards(handCards);
        List<Card> allCards = TexasHoldemApp.getListOfCards("QcJdJcJhTd7c5s");

        comb.isPairOrThree(player, allCards);
        List<Card> actualCards = player.getBestCombination();

        List<Card> expectedCards = TexasHoldemApp.getListOfCards("JdJcJhQcTd");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());
    }

    @Test
    public void testFullHouse() {
        Combinations comb = new Combinations();
        Player player = new Player();
        List<Card> handCards = TexasHoldemApp.getListOfCards("Td7s");
        player.setHandCards(handCards);

        List<Card> allCards = TexasHoldemApp.getListOfCards("QcJdJcJhTd7c7s");
        comb.isPairOrThree(player, allCards);
        List<Card> actualCards = player.getBestCombination();

        List<Card> expectedCards = TexasHoldemApp.getListOfCards("JdJcJh7c7s");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }

    @Test
    public void testTwoPairs() {
        Combinations comb = new Combinations();
        Player player = new Player();
        List<Card> handCards = TexasHoldemApp.getListOfCards("Td7s");
        player.setHandCards(handCards);
        List<Card> allCards = TexasHoldemApp.getListOfCards("QcJdJcThTd7c7s");
        comb.isPairOrThree(player, allCards);

        List<Card> actualCards = player.getBestCombination();

        List<Card> expectedCards = TexasHoldemApp.getListOfCards("JdJcThTdQc");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }

    @Test
    public void testGetOnePair() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdQc9d8s8h7c5d");
        List<Card> actualCards = comb.getPair(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("8s8h");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }

    @Test
    public void testGetThreeCombination() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdQc8d8s8h7c5d");

        List<Card> actualCards = comb.getThreeCombination(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("8d8s8h");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());
    }

    @Test
    public void testIsFourOfKindFromThirdCard() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdQc8d8s8h8c5d");

        List<Card> actualCards = comb.isFourOfKind(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("8d8s8h8cAd");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());


    }

    @Test
    public void testIsNotFourOfKind() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdQc8d8s8h7c5d");

        List<Card> actualCards = comb.isFourOfKind(inputCard);
        List<Card> expectedCards = new ArrayList<>();

        assertEquals("List not empty", expectedCards.isEmpty(), actualCards.isEmpty());

    }

    @Test
    public void testIsFourOfKindFromSecondCard() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("Qc8d8s8h8c7d5d");

        List<Card> actualCards = comb.isFourOfKind(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("8d8s8h8cQc");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());

    }

    @Test
    public void testIsDiamondFlush() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdQdJd5d4d3c2d");

        List<Card> actualCards = comb.isFlush(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("AdQdJd5d4d");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());
    }

    @Test
    public void testIsNotFlush() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdQdJd4c2d");

        List<Card> actualCards = comb.isFlush(inputCard);
        List<Card> expectedCards = new ArrayList<>();
        assertEquals("List not Empty", expectedCards.size(),actualCards.size());
    }

    @Test
    public void isStraight() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("KdKcQdJsTh9c8s");

        List<Card> actualCards = comb.isStraight(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("KdQdJsTh9c");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());
    }

    @Test
    public void isLowestStraight() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdKcTd5s4s3h2c");

        List<Card> actualCards = comb.isStraight(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("Ad5s4s3h2c");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());
    }

    @Test
    public void isStraightFromSix() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdKc6d5s4s3h2c");

        List<Card> actualCards = comb.isStraight(inputCard);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("6d5s4s3h2c");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());
    }

    @Test
    public void testDefineRoyalFlash() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdKdQdJdTd");

        String expectedType = "Royal Flush";
        String actualType = comb.defineStraightType(inputCard);
        assertEquals("Not defining Royal Flush",expectedType,actualType);

    }

    @Test
    public void testDefineStraight() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("AdKdQdJdTc");

        String expectedType = "Straight";
        String actualType = comb.defineStraightType(inputCard);
        assertEquals("Not defining Royal Flush",expectedType,actualType);
    }

    @Test
    public void testDefineStraightFlush() {
        Combinations comb = new Combinations();
        List<Card> inputCard = TexasHoldemApp.getListOfCards("8c7c6c5c4c");
        String expectedType = "Straight Flush";
        String actualType = comb.defineStraightType(inputCard);
        assertEquals("Not defining Royal Flush",expectedType,actualType);
    }

}