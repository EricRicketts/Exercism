public class Blackjack{
    public int  parseCard(String card) {
        int cardValue;
        switch (card) {
            case "ace" -> cardValue = 11;
            case "king", "queen", "jack", "ten" -> cardValue = 10;
            case "nine" -> cardValue = 9;
            case "eight" -> cardValue = 8;
            case "seven" -> cardValue = 7;
            case "six" -> cardValue = 6;
            case "five" -> cardValue = 5;
            case "four" -> cardValue = 4;
            case "three" -> cardValue = 3;
            case "two" -> cardValue = 2;
            default -> cardValue = 0;
        }
        return cardValue;
    }

    public boolean isBlackjack(String card1, String card2) {
        final int BLACKJACK = 21;
        return parseCard(card1) + parseCard(card2) == BLACKJACK;
    }

    public String largeHand(boolean isBlackjack, int dealerScore) {
        String play;
        if (isBlackjack && (dealerScore == 10 || dealerScore == 11)) {
            play = "S";
        } else if (isBlackjack && dealerScore < 10) {
            play = "W";
        } else {
            play = "P";
        }
        return play;
    }

    public String smallHand(int handScore, int dealerScore) {
        String play;
        if (handScore >= 17) {
            play = "S";
        } else if (handScore <= 11) {
            play = "H";
        } else if (dealerScore >= 7 ) {
            play = "H";
        } else {
            play = "S";
        }
        return play;
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) 
            return largeHand(isBlackjack(card1, card2), dealerScore);
        
        else
            return smallHand(handScore, dealerScore);
    }
}
