package com.ana.texasholdem;

import com.ana.texasholdem.model.Card;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ana on 8/23/2020
 */
public class TexasHoldemAppTest {

    @Test
    public void testReturnCorrectNumberOfPlayers() {
        String input = "4cKs4h8s7s Ad4s Ac4d As9s KhKd 10d6d";
        int expected = 5;
        int actual = TexasHoldemApp.getNumberOfPlayers(input);
        assertEquals("Cannot count number of players", expected, actual);
    }

    @Test
    public void testSpacesAndTensRemoved() {
        String input = "4c10s4h10s7s  Ad4s  Ac4d   10hKd";
        String expected = "4c1s4h1s7s Ad4s Ac4d 1hKd";
        String actual = TexasHoldemApp.removeSpacesAndTens(input);
        assertEquals("Not able to remove spaces and tens", expected, actual);
    }

    @Test
    public void testSpacesAndTensNotRemoved() {
        String input = "4c10s4h10s7s  Ad4s  Ac4d   10hKd";
        String expected = "4c1s4h1s7s Ad4s  Ac4d 1hKd";
        String actual = TexasHoldemApp.removeSpacesAndTens(input);
        assertNotEquals("Not able to remove spaces and tens", expected, actual);
    }

    @Test
    public void testInsertTens() {
        String input = "4c1s4h1s7s Ad4s 1c4d";
        String expected = "4c10s4h10s7s Ad4s 10c4d";
        String actual = TexasHoldemApp.insertTens(input);
        assertEquals("Not able to insert tens", expected, actual);
    }

    @Test
    public void testGettingListOfCards() {
        String input = "AcAdQc1s9h";
        List<Card> actualCards = TexasHoldemApp.getListOfCards(input);
        List<Card> expectedCards = new ArrayList<>();
        expectedCards.add(new Card("c", 14));
        expectedCards.add(new Card("d", 14));
        expectedCards.add(new Card("c", 12));
        expectedCards.add(new Card("s", 10));
        expectedCards.add(new Card("h", 9));

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
    public void testReplaceRankToNumeric() {
        String input1 = "1";
        String actualOutput1 = TexasHoldemApp.replaceRankToNumeric(input1);
        String expectedOutput1 = "10";

        String input2 = "J";
        String actualOutput2 = TexasHoldemApp.replaceRankToNumeric(input2);
        String expectedOutput2 = "11";

        String input3 = "Q";
        String actualOutput3 = TexasHoldemApp.replaceRankToNumeric(input3);
        String expectedOutput3 = "12";

        String input4 = "K";
        String actualOutput4 = TexasHoldemApp.replaceRankToNumeric(input4);
        String expectedOutput4 = "13";

        String input5 = "A";
        String actualOutput5 = TexasHoldemApp.replaceRankToNumeric(input5);
        String expectedOutput5 = "14";


        assertEquals("Not able to convert rank to numeric value", expectedOutput1, actualOutput1);
        assertEquals("Not able to convert rank to numeric value", expectedOutput2, actualOutput2);
        assertEquals("Not able to convert rank to numeric value", expectedOutput3, actualOutput3);
        assertEquals("Not able to convert rank to numeric value", expectedOutput4, actualOutput4);
        assertEquals("Not able to convert rank to numeric value", expectedOutput5, actualOutput5);
    }

    @Test
    public void testReplaceNumericToRank() {
        String input1 = "11";
        String actualOutput1 = TexasHoldemApp.replaceNumericToRank(input1);
        String expectedOutput1 = "J";

        String input2 = "12";
        String actualOutput2 = TexasHoldemApp.replaceNumericToRank(input2);
        String expectedOutput2 = "Q";

        String input3 = "13";
        String actualOutput3 = TexasHoldemApp.replaceNumericToRank(input3);
        String expectedOutput3 = "K";

        String input4 = "14";
        String actualOutput4 = TexasHoldemApp.replaceNumericToRank(input4);
        String expectedOutput4 = "A";


        assertEquals("Not able to convert rank to numeric value", expectedOutput1, actualOutput1);
        assertEquals("Not able to convert rank to numeric value", expectedOutput2, actualOutput2);
        assertEquals("Not able to convert rank to numeric value", expectedOutput3, actualOutput3);
        assertEquals("Not able to convert rank to numeric value", expectedOutput4, actualOutput4);
    }
}