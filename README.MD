*******************************
#DESCRIPTION
*******************************
TexasHoldemApp is an algorithm to find best possible combinations of the game written in JAVA using stdin/stdout.

The input is read from the standard input in the form of:
<5 board cards> <hand 1> <hand 2> <...> <hand N>
... where:
• <5 board cards> is a 10 character string where each 2 characters encode a card
• <hand X> is a 4 character string where each 2 characters encode a card, with 2 cards per hand
• <card> is a 2 character string with the first character representing the rank (one of "A", "K", "Q",
"J", "T", "9", "8", "7", "6", "5", "4", "3", "2") and the second character representing the suit (one of
"h", "d", "c", "s") .

The output is written to standard output using the format:
<hand block 1> <hand block 2> <...> <hand block n>
... where:
• <hand block 1> is the hand block with the weakest value
• <hand block 2> is the hand block with the second weakest value
• <hand block n> is the hand block with the strongest value
• Each hand block consists of one or multiple hands (each represented by 4 character string with 2
characters to encode a card, with 2 cards per hand) with equal strength
• In case there are multiple hands with the same value on the same board they are ordered
alphabetically and separated by "=" signs
• The order of the cards in each hand should remains the same as in the input, no reordering of hand cards implemented.

**********************************
#REQUEREMENTS
**********************************
Project requires Java 1.8 as minimal version

**********************************
#BUILD
**********************************
Run command: *mvn install*

**********************************
#RUN
**********************************
To run the project:
1. Using linux CLI:
*java -jar TexasHoldemAppDep.jar < file*
where file = file to read

2. Using linux CLI to read one line:
*echo 'line' | java -jar TexasHoldemAppDep.jar*

3. Running from the IDE terminal:
*Run main method*
*Paste input*


where TexasHoldemAppDep.jar = jar file name

