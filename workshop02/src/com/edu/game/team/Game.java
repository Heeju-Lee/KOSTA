package com.edu.game.team;

import java.util.Scanner;

public class Game {

    int gameType;
    int totalWinCnt;

    Player player;


    public Game(){
    	player = new Player();
    	
        while(true) {
        	Scanner sc = new Scanner(System.in);
        	gameType = sc.nextInt();
      
        	//게임 타입 입력
	        if (gameType == 1) {
	            totalWinCnt = 3;
	            break;
	        }
	        else if (gameType == 2) {
	            totalWinCnt = 2;
	            break;
	        }
	        else if (gameType == 3) {
	            totalWinCnt = 3;
	            break;
	        }
	        else {
	            System.out.println("1~3의 사이값으로 다시 입력해 주세요");;
	        }
        }
    }
    public void runGame(){

    	while(true) {
    		
    		if( (player.getWinCnt() >= totalWinCnt) || (player.getLoseCnt() >= totalWinCnt)) 
    			break;
    		
        	//player 입력
            System.out.print("가위바위보 중 하나 입력: ");
            
            //computer random하게 생성
            int comChoice;
            comChoice =(int) (Math.random() * 3) + 1;

            Scanner sc = new Scanner(System.in);
            player.setPlayerInput(sc.nextLine());
                        
            int playerChoice = player.getPlayerInput();


            if (comChoice == playerChoice) {
                System.out.println("비겼습니다!!!");
            } 
            else if ((comChoice == 1 && playerChoice == 2) || (comChoice == 2 && playerChoice == 3) || (comChoice == 3 && playerChoice == 1)) {
                System.out.println("이겼습니다!!!");
                player.addWinCnt();
            } 
            else if ( (comChoice ==1 && playerChoice ==3) || (comChoice ==2 && playerChoice ==1) || (comChoice ==3&& playerChoice ==2)) {
                System.out.println("졌습니다!!!");
                player.addLoseCnt();
            }
            
        }
    }

    public String resultPrint(){

        int win = player.getWinCnt();
        int lose = player.getLoseCnt();

        String result = "";
        if (win == lose) {
            result = "무승부";
        } else if (win > lose) {
            result = "컴퓨터 패";
        } else {
            result = "컴퓨터 승";
        }

        return "\n### " + result + "!!!";
    }

}
