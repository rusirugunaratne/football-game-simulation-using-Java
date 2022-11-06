package com.football;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        String[] teamOnePlayersNames = {
                "Liam", "Noah", "William", "Mason", "James",
                "Benji", "Jacob", "Michael", "Elijah", "Ethan", "Alex"
        };
        String[] teamTwoPlayersNames = {
                "Oliver", "Daniel", "Lucas", "Matthew", "Aiden",
                "Jackson", "Logan", "David", "Joseph", "Samuel", "Henry"
        };

        String[] teamNames = {"Phantom Bulls", "Cheetah Colonels"};

        Team teamOne = new Team();
        teamOne.addTeamMembers(teamOnePlayersNames, teamNames[0]);
        Team teamTwo = new Team();
        teamTwo.addTeamMembers(teamTwoPlayersNames, teamNames[1]);


        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.setTeamOne(teamOne);
        scoreBoard.setTeamTwo(teamTwo);


        GameTasks gameTasks = new GameTasks();
        System.out.println("+------------------------------+");
        System.out.println("+      FOOTBALL SIMULATOR      +");
        System.out.println("+------------------------------+");
        //toss to select the first playing team
        System.out.println("+------------------------------+");
        System.out.println("+          TOSS                +");
        System.out.println("+------------------------------+");
        int teamNumber = gameTasks.selectTeam();
        if (teamNumber == 0) {
            System.out.println(teamNames[0] + " won the TOSS");
            scoreBoard.setCurrentPlayer(teamOne.getPlayers().get(0));
            scoreBoard.setLastPlayer(teamTwo.getPlayers().get(0));
        } else {
            System.out.println(teamNames[1] + " won the TOSS");
            scoreBoard.setLastPlayer(teamOne.getPlayers().get(0));
            scoreBoard.setCurrentPlayer(teamTwo.getPlayers().get(0));
        }

        //first half
        System.out.println("+------------------------------+");
        System.out.println("+          First-Half          +");
        System.out.println("+------------------------------+");
        gameTasks.playGame(scoreBoard, "First Half", 45.0);
        //interval
        System.out.println("+------------------------------+");
        System.out.println("+          Interval            +");
        System.out.println("+------------------------------+");
        sleep(2000);
        //second half
        System.out.println("+------------------------------+");
        System.out.println("+          Second-Half         +");
        System.out.println("+------------------------------+");
        gameTasks.playGame(scoreBoard, "Second Half", 45.0);
        //extra time
        //if equal goals or both teams have no goals
        boolean sameGoals = scoreBoard.getTeamOne().getGoals() == scoreBoard.getTeamTwo().getGoals();
        boolean bothNoGoals = scoreBoard.getTeamOne().getGoals() == 0 && scoreBoard.getTeamTwo().getGoals() == 0;
        if (sameGoals && bothNoGoals) {
            sleep(2000);
            System.out.println("+------------------------------+");
            System.out.println("+          Extra-Time          +");
            System.out.println("+------------------------------+");
            gameTasks.playGame(scoreBoard, "Second Half", 15.0);
        }
        //still a tie?
        if (scoreBoard.getTeamOne().getGoals() == scoreBoard.getTeamTwo().getGoals()) {
            sleep(2000);
            System.out.println("+------------------------------+");
            System.out.println("+          Extra-Round         +");
            System.out.println("+------------------------------+");
            gameTasks.finalTake(scoreBoard);
        }
        sleep(2000);
        //check the finals
        System.out.println("+------------------------------+");
        System.out.println("+         END OF THE GAME      +");
        System.out.println("+------------------------------+");
        gameTasks.findWinner(scoreBoard);
        try {
            gameTasks.printPlayerMarks(scoreBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
