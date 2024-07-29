package com.edu.game.team;

public class Game {

    private Player player;
    private int computerPick;

    //게임 안내 기능
    public void gameInfo() {
        System.out.println(">>가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
        System.out.println("1. 5판 3승");
        System.out.println("2. 3판 2승");
        System.out.println("3. 1판 1승");
        System.out.print("번호를 입력하세요 >> ");
    }

    /*
        게임 타입 선택 검증
        ::
        return 값은 gameStatus 반환 -> 정상(true), 잘못된 값 입력(false)
     */
    public boolean gameTypeValidation(int value) {
        switch (value) {
            // V2 수정 -> player 객체 생성
            case 1:
                player = new Player(5, 3);
                return true;
            case 2:
                player = new Player(3, 2);
                return true;
            case 3:
                player = new Player(1, 1);
                return true;

            default:
                System.out.print("[에러] 1~3의 사이값으로 다시 입력해 주세요 : ");
                return false;
        }
    }

    //게임 시작 기능
    public void runGameInput() {
        //게임 실행
        computerPick = (int) (Math.random() * 3) + 1;
        System.out.print("1.가위 2.바위 3.보 중 하나 입력: ");
    }

    public boolean runGameOutput(int userPick) {
        //검증 :: if(user가 입력한 값이 잘못되었다면) true 리턴하여 다시 입력값을 요청
        if (userPickValidation(userPick)) {
            return true;
        }

        // 유저 vs 컴퓨터 승패 비교
        if (userPick + 1 == computerPick || userPick - 2 == computerPick) {
            //user 지는 거
            System.out.println("졌습니다 ㅠㅠ");
            player.increaseCurrentGameCnt();
            player.increaseCurrentLoseCnt();
        } else if (userPick == computerPick) {
            System.out.println("비겼습니다..");
            player.increaseCurrentGameCnt();
            player.increaseCurrentTieCnt();
        } else {
            // user 이기는 거
            System.out.println("이겼습니다!!");
            player.increaseCurrentGameCnt();
            player.increaseCurrentWinCnt();
        }

        // if(계속 실행 조건) else(게임 종료)
        if (player.gameExitLogic()) return true;
        else return false;
    }

    private boolean userPickValidation(int userPick) {
        if (userPick > 3 || userPick < 1) {
            System.out.println("[에러] 1.가위 2.바위 3.보의 값이 아닙니다.");
            return true;
        }
        return false;
    }

    //게임 결과
    public void gameResult() {
        System.out.println("================== 게임 종료 ==================");
        if (player.getCurrentWinCnt() > player.getCurrentLoseCnt())
            System.out.printf("승리 하셨습니다!! [전적:%d판 %d승 %d무 %d패]\n", player.getTotalGameCnt(), player.getCurrentWinCnt(), player.getCurrentTieCnt(), player.getCurrentLoseCnt());
        else if (player.getCurrentWinCnt() < player.getCurrentLoseCnt())
            System.out.printf("패배 하셨습니다 ㅠㅠ [전적:%d판 %d승 %d무 %d패]\n", player.getTotalGameCnt(), player.getCurrentWinCnt(), player.getCurrentTieCnt(), player.getCurrentLoseCnt());
        else
            System.out.printf("무승부입니다.. [전적:%d판 %d승 %d무 %d패]", player.getTotalGameCnt(), player.getCurrentWinCnt(), player.getCurrentTieCnt(), player.getCurrentLoseCnt());
    }
}