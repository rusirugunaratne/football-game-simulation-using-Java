package com.football;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GameTasks {
    public int selectTeam() {
        Random random = new Random();
        return random.nextInt(2);
    }

    private int selectPlayer() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    private int selectGameTask() {
        Random random = new Random();
        return random.nextInt(100)+1;
    }

    public static void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printPlayerMarks(ScoreBoard scoreBoard) throws Exception {
        FileWriter fileWriter = new FileWriter("PlayerEvaluation.txt");
        fileWriter.write("\n");
        System.out.println("");
        System.out.println("PLAYER EVALUATION");
        fileWriter.write("PLAYER EVALUATION\n");
        System.out.println("TEAM 1 - PLAYERS");
        fileWriter.write("TEAM 1 - PLAYERS\n");
        System.out.println("--------------------------------------------------------");
        fileWriter.write("--------------------------------------------------------\n");
        System.out.println("NAME\t\t\t\t\tROLE\t\t\t\t\tSCORE");
        fileWriter.write("NAME\t\t\t\t\tROLE\t\t\t\t\tSCORE\n");
        System.out.println("--------------------------------------------------------");
        fileWriter.write("--------------------------------------------------------\n");
        for(Player player:scoreBoard.getTeamOne().getPlayers()){
            sleep(500);
            if(player.getPlayerType().equals("Goalie")){
                System.out.println(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+"N/A");
                fileWriter.write(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+"N/A\n");
            }else{
                System.out.println(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+player.getGoals());
                fileWriter.write(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+player.getGoals()+"\n");
            }
            System.out.println("--------------------------------------------------------");
            fileWriter.write("--------------------------------------------------------\n");
        }
        fileWriter.write("\n");
        System.out.println("");
        System.out.println("TEAM 2 - PLAYERS");
        fileWriter.write("TEAM 2 - PLAYERS\n");
        System.out.println("--------------------------------------------------------");
        fileWriter.write("--------------------------------------------------------\n");
        System.out.println("NAME\t\t\t\t\tROLE\t\t\t\t\tSCORE");
        fileWriter.write("NAME\t\t\t\t\tROLE\t\t\t\t\tSCORE\n");
        System.out.println("--------------------------------------------------------");
        fileWriter.write("--------------------------------------------------------\n");
        for(Player player:scoreBoard.getTeamTwo().getPlayers()){
            sleep(500);
            if(player.getPlayerType().equals("Goalie")){
                System.out.println(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+"N/A");
                fileWriter.write(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+"N/A\n");
            }else{
                System.out.println(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+player.getGoals());
                fileWriter.write(player.getName()+"\t\t\t\t\t"+player.getPlayerType()+"\t\t\t\t\t"+player.getGoals()+"\n");
            }
            System.out.println("--------------------------------------------------------");
            fileWriter.write("--------------------------------------------------------\n");
        }
        fileWriter.close();
    }

    public void findWinner(ScoreBoard scoreBoard) {
        int teamOneScore = scoreBoard.getTeamOne().getGoals();
        int teamTwoScore = scoreBoard.getTeamTwo().getGoals();
        if (teamOneScore != teamTwoScore) {
            System.out.println("   +---------------+");
            System.out.println("   |||||||||||||||||");
            System.out.println("   |               |");
            System.out.println("    |             |");
            System.out.println("     |           |");
            System.out.println("       |       |");
            System.out.println("         |    |");
            System.out.println("         |    |");
            System.out.println("         |    |");
            System.out.println("       |        |");
            System.out.println("     |            |");
            System.out.println("     ||||||||||||||");
            System.out.println("     +------------+");


            if (teamOneScore > teamTwoScore) {
                System.out.println("Winner is : " + scoreBoard.getTeamOne().getTeamName());
            } else {
                System.out.println("Winner is : " + scoreBoard.getTeamTwo().getTeamName());
            }
        } else {
            System.out.println("No Winners");
        }
    }

    public void finalTake(ScoreBoard scoreBoard) {
        Random random = new Random();
        int teamOneScore = random.nextInt(4) + 1;
        for(int i=0; i<teamOneScore; i++){
            int playerIndex = random.nextInt(9)+2;
            scoreBoard.getTeamOne().getPlayers().get(playerIndex).incrementGoal();
        }
        int teamTwoScore = random.nextInt(4) + 1;
        for(int i=0; i<teamTwoScore; i++){
            int playerIndex = random.nextInt(9)+2;
            scoreBoard.getTeamTwo().getPlayers().get(playerIndex).incrementGoal();
        }
        scoreBoard.getTeamOne().addToGoals(teamOneScore);
        scoreBoard.getTeamTwo().addToGoals(teamTwoScore);
        System.out.println("Team " + scoreBoard.getTeamOne().getTeamName() + " Got : " + teamOneScore + " Goals");
        System.out.println("Team " + scoreBoard.getTeamOne().getTeamName() + " Final Score : " + scoreBoard.getTeamOne().getGoals() + " Goals");
        System.out.println("Team " + scoreBoard.getTeamTwo().getTeamName() + " Got : " + teamTwoScore + " Goals");
        System.out.println("Team " + scoreBoard.getTeamTwo().getTeamName() + " Final Score : " + scoreBoard.getTeamTwo().getGoals() + " Goals");


    }

    public void playGame(ScoreBoard scoreBoard, String period, double endTime) {
        scoreBoard.setPeriodOftheGame(period);
        scoreBoard.setTimeToEndtheGame(endTime);

        while (scoreBoard.getTimeToEndtheGame() > 0) {
            //sleep(1000);
            System.out.println("////////////////////////////////");
            System.out.println("+------------------------------+");
            System.out.println("////////////////////////////////");
            if (scoreBoard.getTimeToEndtheGame() < 0) {
                break;
            }
            int gameTask = selectGameTask();
            //giving 30% probability to shoot the ball to the goal
            if (gameTask > 30) {
                passTheBall(scoreBoard.getTeamOne(), scoreBoard.getTeamTwo(), period, scoreBoard);
            } else {
                makeAGoal(scoreBoard.getTeamOne(), scoreBoard.getTeamTwo(), scoreBoard);
            }

        }
    }

    public void passTheBall(Team teamOne, Team teamTwo, String period, ScoreBoard scoreBoard) {
        Team[] teams = {teamOne, teamTwo};
        Player lastPlayer = scoreBoard.getCurrentPlayer();
        int passedToTeam = selectTeam();
        int passedToPlayerNumber = selectPlayer();

        //this is going out of ground
        if (passedToPlayerNumber == 1 || passedToPlayerNumber == lastPlayer.getWinProbability()) {
            scoreBoard.setCurrentPlayer(lastPlayer);
            GameTimes gameTimes = new GameTimes();
            scoreBoard.setTimeToEndtheGame(scoreBoard.getTimeToEndtheGame() - gameTimes.outFieldTime());
            scoreBoard.setBallinOrOut("Out the filed");
            scoreBoard.setGoalOrStoppped("N/A");

        //this is passing to another player
        } else {
            Player passedToPlayer = teams[passedToTeam].getPlayers().get(passedToPlayerNumber);
            scoreBoard.setCurrentPlayer(passedToPlayer);
            scoreBoard.setLastPlayer(lastPlayer);
            GameTimes gameTimes = new GameTimes();

            scoreBoard.setTimeToEndtheGame(scoreBoard.getTimeToEndtheGame() - gameTimes.passTime());
            scoreBoard.setBallinOrOut("In the Field");
            scoreBoard.setGoalOrStoppped("N/A");
            scoreBoard.printScoreBoard();
        }
    }

    public void makeAGoal(Team teamOne, Team teamTwo, ScoreBoard scoreBoard) {
        int goalProbability = selectPlayer();
        GameTimes gameTimes = new GameTimes();
        scoreBoard.setBallinOrOut("In the field");
        scoreBoard.setTimeToEndtheGame(scoreBoard.getTimeToEndtheGame() - gameTimes.goalTime());

        //if goal is met
        if (goalProbability == scoreBoard.getCurrentPlayer().getWinProbability() && scoreBoard.getCurrentPlayer().getWinProbability() != 1) {
            if (scoreBoard.getCurrentPlayer().getTeamName().equals(teamOne.getTeamName())) {
                scoreBoard.getTeamOne().incrementGoal();
                scoreBoard.setCurrentPlayer(teamOne.getPlayers().get(0));
                scoreBoard.getTeamOne().getPlayers().get(goalProbability).incrementGoal();
            } else {
                scoreBoard.getTeamTwo().incrementGoal();
                scoreBoard.setCurrentPlayer(teamTwo.getPlayers().get(0));
                scoreBoard.getTeamTwo().getPlayers().get(goalProbability).incrementGoal();
            }
            scoreBoard.setGoalOrStoppped("Goal");
        } else {
            scoreBoard.setGoalOrStoppped("Stopped");


            if (selectTeam() == 0) {
                scoreBoard.setLastPlayer(scoreBoard.getCurrentPlayer());
                scoreBoard.setCurrentPlayer(teamOne.getPlayers().get(goalProbability));
            } else {
                scoreBoard.setLastPlayer(scoreBoard.getCurrentPlayer());
                scoreBoard.setCurrentPlayer(teamTwo.getPlayers().get(goalProbability));
            }

        }
        scoreBoard.printScoreBoard();
    }
}
