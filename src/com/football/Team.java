package com.football;

import java.util.ArrayList;

public class Team {
    private ArrayList<Player> players = new ArrayList<>();

    private String teamName;
    private int goals = 0;


    public void addToGoals(int goals) {
        this.goals += goals;
    }

    public void incrementGoal() {
        goals++;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void addTeamMembers(String[] teamMemberNames, String teamName) {
        this.teamName = teamName;
        for (int i = 0; i < teamMemberNames.length; i++) {
            Player player = new Player();
            player.setName(teamMemberNames[i]);
            player.setPlayerType("Player");
            player.setTeamName(teamName);
            this.players.add(player);
        }
        this.players.get(0).setPlayerType("Goalie");
        addProbabilities();
    }

    public void printTeamMembers() {
        System.out.println(this.players.get(0).getTeamName());
        for (Player player : this.players) {
            System.out.println("Name: " + player.getName() + " Team: " + player.getTeamName() + " Prob: " + player.getWinProbability());
        }
    }

    private void addProbabilities() {
        int count = 1;
        for (Player player : this.players) {
            player.setWinProbability(count);
            count++;
        }
    }
}
