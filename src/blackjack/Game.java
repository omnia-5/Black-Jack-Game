/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author DELL
 */
public class Game {
    Player[]players=new Player[4];
    Card []Cards=new Card[52];
    int PlayerScore[]=new int[4];
      int highscore=0;
        
    public void cardDeck(){
        int deck=0;
            for(int suit=0;suit<4;suit++){
                for(int rank=0;rank<13;rank++){
                        if (rank>=10){
                            int x=rank+1;
                            x=10;
                        Cards[deck]=new Card(suit,rank,x);
                        deck++;
                       }
                        else{
                            Cards[deck]=new Card(suit,rank,rank+1);
                            deck++;
                        }
                    
                
                    
                }
            }
    }
    
    public Card draw(){
        Random rand =new Random();
        Card c;
        
       while (true){
          int r =rand.nextInt(52);
                    if(Cards[r]!=null){
                        c=Cards[r];
                        Cards[r]=null;
                     break;
                    }
               } 
        return c;
    }
    
    public void set_information(){
        Scanner player=new Scanner(System.in);
        for(int i=0;i<4;i++){
            int x=i+1;
            System.out.print("Enter The Name Of Player "+ x + ":");
            String name=player.next();
            players[i]=new Player(name);
            players[i].addCard(draw());
            players[i].addCard(draw());
        }
    }
    
    public void update_score(){
        for(int i=0;i<4;i++){
            PlayerScore[i]=players[i].getScore();
            if(PlayerScore[i]<=21){
             PlayerScore[i]= players[i].getScore();
            }else{
                PlayerScore[i]=0;
            }
        }
    }
    
    public void getMaxScore(){
        for(int i=0;i<4;i++){
            if(highscore < PlayerScore[i] && PlayerScore[i]<=21){
                highscore=PlayerScore[i];
            }
        }
    }
    }
    

