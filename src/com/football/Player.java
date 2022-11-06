package com.football;

public class Player {
    private String name;
    private String teamName;
    private int goals = 0;
    private int winProbability;
    private String playerType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getWinProbability() {
        return winProbability;
    }

    public void setWinProbability(int winProbability) {
        this.winProbability = winProbability;
    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }

    public void incrementGoal() {
        this.goals++;
    }
}
