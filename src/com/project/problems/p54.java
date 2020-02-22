package com.project.problems;

import com.project.base.ProblemBase;

import java.util.*;
import java.util.stream.Collectors;

public class p54 extends ProblemBase {

    static class Player {

        List<Card> cards = new ArrayList<>();
        HashMap<String, Integer> suitMap = new HashMap<>();
        HashMap<Integer, Integer> valueMap = new HashMap<>();

        public void printHand() {
            System.out.print("Cards: ");
            cards.stream().forEach(card -> System.out.print(" " + card.getValue() + card.getSuit()));
            System.out.println();
            System.out.print("Rank: " + getHandRank());
            System.out.println();
        }

        public void deal(List<Card> cards) {
            this.cards = cards;
            suitMap.clear();
            valueMap.clear();
            this.cards.sort(Comparator.comparingInt(Card::getValue));
            this.cards.forEach(card -> {
                int suitCount = suitMap.getOrDefault(card.getSuit(), 0);
                suitMap.put(card.getSuit(), suitCount + 1);

                int valueCount = valueMap.getOrDefault(card.getValue(), 0);
                valueMap.put(card.getValue(), valueCount + 1);
            });
        }

        public List<Integer> getCardsWithDuplicates(int duplicateCount) {
            List<Integer> cardRanks = valueMap.keySet().stream().filter(k -> valueMap.get(k) >= duplicateCount).collect(Collectors.toList());
            cardRanks.sort(Integer::compareTo);
            cardRanks.sort(Collections.reverseOrder());
            return cardRanks;
        }

        public boolean beats(Player opponent) {
            int myRank = getHandRank();
            int opponentRank = opponent.getHandRank();

            if(myRank != opponentRank) {
                return myRank > opponentRank;
            }

            if(valueMap.values().stream().anyMatch(v -> v > 1)) {
                List<Integer> myCardRanks = getCardsWithDuplicates(2);
                List<Integer> opponentCardRanks = opponent.getCardsWithDuplicates(2);

                for(int i = 0; i < myCardRanks.size(); i++) {
                    int myCardRank = myCardRanks.get(i);
                    int opponentCardRank = opponentCardRanks.get(i);
                    if(myCardRank != opponentCardRank) {
                        return myCardRank > opponentCardRank;
                    }
                }

            }

            for (int i = 4; i >= 0; i--) {
                int myCard = getCardValue(i);
                int opponentCard = opponent.getCardValue(i);
                if (myCard != opponentCard) {
                    return myCard > opponentCard;
                }
            }

            System.err.println("NO WINNER");
            return false;
        }

        public int getCardValue(int i) {
            return cards.get(i).getValue();
        }

        public int getHandRank() {
            if(hasRoyalFlush()) return 9;
            if(hasStraightFlush()) return 8;
            if(hasFourOfAKind()) return 7;
            if(hasFullHouse()) return 6;
            if(hasFlush()) return 5;
            if(hasStraight()) return 4;
            if(hasThreeOfAKind()) return 3;
            if(hasTwoPair()) return 2;
            if(hasOnePair()) return 1;
            return 0;
        }

        public boolean hasFlush() {
            return suitMap.containsValue(5);
        }

        public boolean hasStraight() {
            int start = cards.get(0).getValue();
            for(int i = 1; i < 5; i++) {
                if(cards.get(i).getValue() != start + i) {
                    return false;
                }
            }
            return true;
        }

        public boolean hasFullHouse() {
            return valueMap.containsValue(2) && valueMap.containsValue(3);
        }

        public boolean hasStraightFlush() {
            return hasFlush() && hasFlush();
        }

        public boolean hasRoyalFlush() {
            return hasStraightFlush() && valueMap.containsKey(14);
        }

        public boolean hasFourOfAKind() {
            return valueMap.containsValue(4);
        }

        public boolean hasThreeOfAKind() {
            return valueMap.containsValue(3);
        }

        public boolean hasTwoPair() {
            return valueMap.values().stream().filter(v -> v == 2).count() == 2;
        }

        public boolean hasOnePair() {
            return valueMap.values().stream().filter(v -> v == 2).count() == 1;
        }

    }

    static class Card {
        private int value;
        private String suit;
        public Card(String init) {
            String valueString = init.substring(0,1);
            switch (valueString) {
                case "T":
                    value = 10;
                    break;
                case "J":
                    value = 11;
                    break;
                case "Q":
                    value = 12;
                    break;
                case "K":
                    value = 13;
                    break;
                case "A":
                    value = 14;
                    break;
                default:
                    value = Integer.parseInt(valueString);
                    break;
            }
            suit = init.substring(1,2);
        }

        public int getValue(){
            return value;
        }

        public String getSuit() {
            return suit;
        }
    }

    private Player player1 = new Player();
    private Player player2 = new Player();

    public Long execute() {
        long wins = 0;
        for (String s : multiline) {
            deal(s, player1, player2);
            if (player1.beats(player2)) {
                wins++;
            }
        }
        return wins;

    }

    public void deal(String cardString, Player player1, Player player2) {
        List<Card> cards = Arrays.stream(cardString.split(" ")).map(Card::new).collect(Collectors.toList());
        player1.deal(cards.subList(0,5));
        player2.deal(cards.subList(5,10));
    }
}
