package at.htl.football;

import java.util.List;

public class Main {



    private void printTable(List<Team> teams){
        System.out.printf("%-20s %-10s %-8s %-8s %-8s %-8s %-8s %2s \n","Team", "Pts", "W", "D", "L","GF","GA", "GD");
        for (int i = 0; i < teams.size(); i++){
            System.out.printf("%-20s %-10s %-8s %-8s %-8s %-8s %-8s %2s \n",teams.get(i).getName() , teams.get(i).getPoints(),teams.get(i).getWins(), teams.get(i).getDraws(), teams.get(i).getDefeats(),teams.get(i).getGoalShot(),teams.get(i).getGoalsReceived(), teams.get(i).getGoalsDifference());
        }

        System.out.println("\nPTS...Points, W...Won, D...Drawn, L...Lost" +
                        "\nGF...Goals for, GA...Goals against, GD...Goal difference");
    }

    public static void main(String[] args) {
        League liga = new League();
        new Main().printTable(liga.getTable());
    }
}
