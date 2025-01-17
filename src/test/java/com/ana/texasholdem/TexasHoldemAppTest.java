package com.ana.texasholdem;

import com.ana.texasholdem.model.Card;
import org.junit.Assert;
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
        String input = "4cKs4h8s7s Ad4s Ac4d As9s KhKd Td6d";
        int expected = 5;
        int actual = TexasHoldemApp.getNumberOfPlayers(input);
        assertEquals("Cannot count number of players", expected, actual);
    }

    @Test
    public void testSpacesRemoved() {
        String input = "4cTs4hTs7s  Ad4s  Ac4d   ThKd";
        String expected = "4cTs4hTs7s Ad4s Ac4d ThKd";
        String actual = TexasHoldemApp.removeSpaces(input);
        assertEquals("Not able to remove spaces and tens", expected, actual);
    }

    @Test
    public void testSpacesNotRemoved() {
        String input = "4cTs4hTs7s  Ad4s  Ac4d   ThKd";
        String expected = "4cTs4hTs7s Ad4s  Ac4d ThKd";
        String actual = TexasHoldemApp.removeSpaces(input);
        assertNotEquals("Not able to remove spaces and tens", expected, actual);
    }

    @Test
    public void testGettingListOfCards() {
        String input = "AcAdQcTs9h";
        List<Card> actualCards = TexasHoldemApp.getListOfCards(input);
        List<Card> expectedCards = TexasHoldemApp.getListOfCards("AcAdQcTs9h");

        Assert.assertEquals(expectedCards.toString(),actualCards.toString());
    }

    @Test
    public void testReplaceRankToNumeric() {
        String input1 = "T";
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

        String input5 = "10";
        String actualOutput5 = TexasHoldemApp.replaceNumericToRank(input5);
        String expectedOutput5 = "T";


        assertEquals("Not able to convert rank to numeric value", expectedOutput1, actualOutput1);
        assertEquals("Not able to convert rank to numeric value", expectedOutput2, actualOutput2);
        assertEquals("Not able to convert rank to numeric value", expectedOutput3, actualOutput3);
        assertEquals("Not able to convert rank to numeric value", expectedOutput4, actualOutput4);
        assertEquals("Not able to convert rank to numeric value", expectedOutput5, actualOutput5);
    }
}