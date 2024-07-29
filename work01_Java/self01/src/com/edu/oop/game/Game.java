package com.edu.oop.game;

import java.util.Scanner;

public class Game {
   	Player player;
 //   Player computer;//굳이
    int totalGame;
    
    //생성자 주입
    public Game(Player player, int totalGame) {
        this.player = player;
        this.totalGame = totalGame;
    }
    //게임을 시작하는 메소드
    public void playGame() {
        Scanner sc = new Scanner(System.in); // Scanner 객체 생성

        //필드 초기화
        int playerWin = 0;
        int playerLose = 0;
        int computerWin = 0;
        int computerLose = 0;

        for (int i = 0; i < totalGame; i++) {
            // 타입에 따라 승리 값에 도달하게 되면 정지
            if (totalGame == 5 && (playerWin == 3) | (computerWin == 3) ){
            	break;
            }else if (totalGame == 3 && (playerWin == 2) | (computerWin == 2)) { 
                break;
            }else if (totalGame == 1 && (playerWin == 1) | (computerWin == 1)) { 
                break;
            }else {
            	
            System.out.println("가위, 바위, 보 중 하나를 입력해주세요");
            String playerInput = sc.next(); // 플레이어가 입력함
            
            // 컴퓨터는 랜덤으로 결정 random 값 int로 캐스팅
            int computer = (int) (Math.random() * 3) + 1;

            // 플레이어 입력과 컴퓨터 랜덤값에 따라 승부 결정
            if (playerInput.equals("가위")) {
                if (computer == 2) {//주먹
                    System.out.println("Computer Win!");
                    computerWin++;
                } else if (computer == 3) {//보
                    System.out.println("You Win!");
                    playerWin++;
                } else {
                    System.out.println("Draw!");
                    i--; // 비긴 경우 for문에서 하나 감소
                }
            } else if (playerInput.equals("바위")) {
                if (computer == 3) {
                    System.out.println("Computer Win!");
                    computerWin++;
                } else if (computer == 1) {
                    System.out.println("You Win!");
                    playerWin++;
                } else {
                    System.out.println("Draw!");
                    i--; // 비긴 경우 for문에서 하나 감소
                }
            } else if (playerInput.equals("보")) {
                if (computer == 1) {
                    System.out.println("Computer Win!");
                    computerWin++;
                } else if (computer == 2) {
                    System.out.println("You Win!");
                    playerWin++;
                } else {
                    System.out.println("Draw!");
                    i--; // 비긴 경우 for문에서 하나 감소
                }
            } else {
                System.out.println("Value is incorrect!\nTry again.");
                i--; // 오류 메세지 반환
            }//바로위 else
            
            }//for문 근처 else

        }//for문 닫기

        // 최종 승자
        System.out.println("==========Game Result==========");
        if (playerWin > computerWin) {
            System.out.println("###Player Win!!\nCongratulation~~!!^^");
        } else
            System.out.println("###You Lose~~ㅜㅜ");
        System.out.println("===============================");
    }
    
}
