package com.edu.game.team;

import java.util.Scanner;

public class Player {

    int playerInput;
    int winCnt;
    int loseCnt;

    public Player() {}

    public int getWinCnt() {return winCnt;}
    public int getLoseCnt() {return loseCnt;}

    public void addWinCnt() {this.winCnt++;}//setter
    public void addLoseCnt() {this.loseCnt++;}//setter

    public int getPlayerInput() {return playerInput;}
    public void setPlayerInput(String str) {//setter 

        if (str.equals("가위")) {
            this.playerInput = 1;
        }
        else if (str.equals("바위")) {
            this.playerInput = 2;
        }
        else if (str.equals("보")) {
            this.playerInput = 3;
        }
        else {
        	System.out.println("잘못 선택했습니다.");
        	this.playerInput = 0;
        }
      
    }

}
