/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author DELL
 */
public class Player {
  private  String name;
  private int score;
  private Card[]card=new Card[11]; 
  int size = 0;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Player(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Card[] getCard() {
        return card;
    }

    public void setCard(Card[] card) {
        this.card = card;
    }
    
    public void addCard(Card c){
        if(size<11){
            card[size]=c;
            size++;
            score=score+c.getValue();
        }
    }
    
}
