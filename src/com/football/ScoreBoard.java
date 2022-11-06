package com.football;

public class ScoreBoard {
    private Team teamOne;
    private Team teamTwo;

    private String periodOftheGame = "N/A";
    private double timeToEndtheGame = 0;

    private String ballinOrOut = "N/A";
    private String goalOrStoppped = "N/A";

    private Player lastPlayer;
    private Player currentPlayer;

    public Team getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
    }

    public Player getLastPlayer() {
        return lastPlayer;
    }

    public void setLastPlayer(Player lastPlayer) {
        this.lastPlayer = lastPlayer;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }


    public String getPeriodOftheGame() {
        return periodOftheGame;
    }

    public void setPeriodOftheGame(String periodOftheGame) {
        this.periodOftheGame = periodOftheGame;
    }

    public double getTimeToEndtheGame() {
        return timeToEndtheGame;
    }

    public void setTimeToEndtheGame(double timeToEndtheGame) {
        this.timeToEndtheGame = timeToEndtheGame;
    }


    public String getBallinOrOut() {
        return ballinOrOut;
    }

    public void setBallinOrOut(String ballinOrOut) {
        this.ballinOrOut = ballinOrOut;
    }

    public String getGoalOrStoppped() {
        return goalOrStoppped;
    }

    public void setGoalOrStoppped(String goalOrStoppped) {
        this.goalOrStoppped = goalOrStoppped;
    }

    public void printScoreBoard() {
        timeToEndtheGame = timeToEndtheGame*100;
        timeToEndtheGame = Math.round(timeToEndtheGame);
        timeToEndtheGame = timeToEndtheGame/100;
        if (timeToEndtheGame < 0) {
            timeToEndtheGame = 0;
        }
        System.out.println("");
        System.out.println("+------------------------------+");
        System.out.println("+          Score Board         +");
        System.out.println("+------------------------------+");
        System.out.println("+ Team One       : " + teamOne.getTeamName());
        System.out.println("+ Team Two       : " + teamTwo.getTeamName());
        System.out.println("+ Team One Goals : " + teamOne.getGoals());
        System.out.println("+ Team Two Goals : " + teamTwo.getGoals());
        System.out.println("");
        System.out.println("+ Last Player ");
        System.out.println("+-----------------+");
        System.out.println("+         Name    : " + lastPlayer.getName());
        System.out.println("+         Team    : " + lastPlayer.getTeamName());
        System.out.println("");
        System.out.println("+ Period         : " + periodOftheGame);
        System.out.println("+ Time to End    : " + (timeToEndtheGame) + "minutes") ;
        System.out.println("");
        System.out.println("+ Current Player ");
        System.out.println("+-----------------+");
        System.out.println("+         Name    : " + currentPlayer.getName());
        System.out.println("+         Team    : " + currentPlayer.getTeamName());
        System.out.println("");
        System.out.println("+ Ball in the field : " + ballinOrOut);
        System.out.println("+ Goal or Stopped   : " + goalOrStoppped);
        System.out.println("+------------------------------+");
        System.out.println("");
    }


}
