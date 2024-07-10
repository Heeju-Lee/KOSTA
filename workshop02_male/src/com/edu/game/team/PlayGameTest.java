package com.edu.game.team;

import com.edu.game.team.Game;

import java.util.Scanner;

public class PlayGameTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Game game = new Game();
        int gameType = 0;
        boolean gameLun = false;
        boolean gameStatus = false;
        int userPick = 0;

        //게임 설명 및 게임 타입 선택
        game.gameInfo();
        do {
            gameType = in.nextInt();
            gameLun = game.gameTypeValidation(gameType); //검증
        } while (!gameLun);

        //게임 실행
        do {
            game.runGameInput();
            userPick = in.nextInt();
            gameStatus = game.runGameOutput(userPick);
        } while (gameStatus);

        //게임 결과 확인
        game.gameResult();

    }
}