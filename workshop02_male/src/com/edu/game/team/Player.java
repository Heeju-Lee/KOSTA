package com.edu.game.team;

public class Player {
    //=======================
    private int totalGameCnt;
    private int winCondition;
    //========================
    private int currentGameCnt;
    private int currentWinCnt;
    private int currentLoseCnt;
    private int currentTieCnt;

    public Player(int totalGameCnt, int winCondition) {
        this.totalGameCnt = totalGameCnt;
        this.winCondition = winCondition;
    }

    //====================================
    public int getCurrentWinCnt() {
        return currentWinCnt;
    }

    public int getCurrentLoseCnt() {
        return currentLoseCnt;
    }
    //====================================

    public int getCurrentTieCnt() {
        return currentTieCnt;
    }

    public int getTotalGameCnt() {
        return totalGameCnt;
    }

    public void increaseCurrentGameCnt() {
        currentGameCnt++;
    }

    public void increaseCurrentWinCnt() {
        currentWinCnt++;
    }

    public void increaseCurrentLoseCnt() {
        currentLoseCnt++;
    }

    public void increaseCurrentTieCnt() {
        currentTieCnt++;
    }

    // 계속 실행하는 조건 : true -> 계속 실행, false -> 실행 종료
    public boolean gameExitLogic() {
        return currentGameCnt < totalGameCnt && currentWinCnt < winCondition && currentLoseCnt < winCondition;
    }
}
