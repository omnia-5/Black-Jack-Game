/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;
import java.util.Scanner;

public class BlackJack {
    static int highscore=0;
    public static void hitOrStand(GUI gui){
        Scanner s=new Scanner(System.in);
    for(int i=0;i<3;i++){
        System.out.println("Player "+game.players[i].getName()+" Please Enter 1 for Hit or 2 for Stand");
            String input =s.next();
         
        while(input.equals("1")){
            CardsOfPlayer(i,gui);
            if(game.players[i].getScore()>=21){
                break;
            }
      System.out.println("Player "+game.players[i].getName()+" Please Enter 1 for Hit or 2 for Stand");
        input=s.next();
        
        }
    }
    }
    public static void CardsOfPlayer(int index,GUI gui){
        Card card=game.draw();
        game.players[index].addCard(card);
        gui.updatePlayerHand(card,index);
    }
    public static void dealer(GUI gui){
        boolean win=true;
        for (int i = 0; i < 3;i++) {

            if(game.PlayerScore[i] >= game.players[3].getScore()){
                win=false;
            }
            if(game.PlayerScore[i] > highscore){
                highscore=game.PlayerScore[i];
            }
        }
        if(!win){
            CardsOfDealer(gui,highscore);
        }else{
            return;
        }
    }
    public static void CardsOfDealer(GUI gui,int highscore){
        while(game.players[3].getScore()<highscore){
            Card card=game.draw();
            game.players[3].addCard(card);
            gui.updateDealerHand(card, game.Cards);
        }
    }
    public static void winOrLose(){
        
        int counter=0;
        boolean blackJack=false;
        boolean push=false;
        int winner=-1;
        boolean entered=false;
        for (int i = 0; i <4 ;i++){
                for(int j=1;j<4;j++){
                if(i==j){
                    continue;
                }else if(game.players[i].getScore()==game.players[j].getScore()&&game.players[j].getScore()==highscore&&game.players[i].getScore()<=21){  
                    blackJack=false;
                    push=true;
                    System.out.println("The Game Is Push Between "+game.players[i].getName()+" and "+game.players[j].getName());
                    entered=true;
                    break;
                    
                }
               
                }
                if(entered==true){
                    break;
                }
                
            
               if(game.players[i].getScore() == highscore){
                highscore=game.players[i].getScore();
                 winner=i;
                 push=false;
                if(highscore==21){
                    blackJack=true;
                }
                
                if(blackJack==false){
            System.out.println("The Winner Is : " + game.players[winner].getName());
        }else{
                  System.out.println("The Player "+ game.players[i].getName() +" Is BlackJack");   
                }
             
       } if(game.players[0].getScore()>21&&game.players[1].getScore()>21&&game.players[2].getScore()>21){
            System.out.println("The Player "+ game.players[3].getName()+" Is Winner");
            break;
           
       }
               
      else  if(game.players[i].getScore()>highscore){
                    System.out.println("The Player "+ game.players[i].getName()+" Is Busted");
            }

                
         }
    }
    static Game game=new Game();
      
   
    public static void main(String[] args) {
        GUI gui=new GUI();
        game.cardDeck();
        game.set_information();
       gui.runGUI(game.Cards ,game.players[0].getCard(),game.players[1].getCard(),game.players[2].getCard(),game.players[3].getCard());
       hitOrStand(gui);
       game.update_score();
       dealer(gui);
        game.update_score();
        game.getMaxScore();
        winOrLose();
    }
    
}
