package com.edu.oop.game;

import java.util.Scanner;

public class GameTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
        System.out.println("1. 5판 3승");
        System.out.println("2. 3판 2승");
        System.out.println("3. 1판 1승");
        System.out.print("번호를 입력하세요.");

        int games = sc.nextInt(); //게임타입 int 입력
        while (!(games >= 1 && games <= 3)) { //게임타입이 다르면 아래출력 입력 재반환
            System.out.println("(1~3) 값으로 다시 입력해 주세요.");
            games = sc.nextInt();
        }

        int totalGame = -1; //총게임수 지정 "-1" *지정 이유 오류감지를 위함
        if (games == 1) totalGame = 5;
        else if (games == 2) totalGame = 3;
        else totalGame = 1;//게임타입 지정 시 총 게임횟수
        
        Player player = new Player("플레이어");//player name 객체
        Game game = new Game(player, totalGame);//게임객체생성 하면서 토탈 게임횟수 넣어줌
        game.playGame();

    }
}
