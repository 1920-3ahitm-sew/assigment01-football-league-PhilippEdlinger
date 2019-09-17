package at.htl.football;

import java.util.Collection;
import java.util.List;

public class Main {



    private void printTable(List<Team> teams){
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s %5s \n","Team", "Pts", "W", "D", "L","GF","GA", "GD");
        for (int i = 0; i < teams.size(); i++){

            System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s %5s \n",teams.get(i).getName() , teams.get(i).getPoints(),teams.get(i).getWins(), teams.get(i).getDraws(), teams.get(i).getDefeats(),teams.get(i).getGoalShot(),teams.get(i).getGoalsReceived(), teams.get(i).getGoalsDifference());

        }
    }

    public static void main(String[] args) {
        League liga = new League();
        new Main().printTable(liga.getTable());
    }
}
