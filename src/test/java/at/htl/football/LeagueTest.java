package at.htl.football;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class LeagueTest {



    @Test
    public void checkPoints(){
        League liga = new League();
        liga.addMatchResult(new Match("Bayern Munich" ,  "Hoffenheim", 3, 1));
        liga.addMatchResult(new Match("Team1" ,  "Bayern Munich", 2, 3));
        liga.addMatchResult(new Match("Team1" ,  "Team3", 4, 4));

        ArrayList<Team> list = new ArrayList<>();
        list.add(new Team("Team1"));
        list.add(new Team("Team2"));
        list.add(new Team("Team3"));

        list.get(0).setPoints(4);
        list.get(1).setPoints(3);
        list.get(2).setPoints(2);

       // assertThat(liga.getTable().get(0).getPoints() , is( list.get(0).getPoints()));
      //  assertThat(liga.getTable().get(1).getPoints() , is( list.get(1).getPoints()));
      //  assertThat(liga.getTable().get(2).getPoints() , is( list.get(2).getPoints()));
    }

    @Test
    public void checkGoals(){

        League liga2 = new League();

        liga2.addMatchResult(new Match("Team1" ,  "Team2", 5, 3));
        liga2.addMatchResult(new Match("Team1" ,  "Team2", 2, 4));
        liga2.addMatchResult(new Match("Team1" ,  "Team3", 1, 1));

        ArrayList<Team> list = new ArrayList<>();

        list.add(new Team("Team1"));
        list.add(new Team("Team2"));
        list.add(new Team("Team3"));

        list.get(0).setGoalShot(8);
        list.get(1).setGoalShot(7);
        list.get(2).setGoalShot(1);

       // assertThat(liga2.getTable().get(1).getGoalShot() , is( list.get(1).getGoalShot()));
    }



    @Test
    public void sortTest(){
        League liga2 = new League();

        for (int i = 0; i < liga2.getTable().size(); i++){
            System.out.println(liga2.getTable().get(i).getName() + " " +liga2.getTable().get(i).getPoints());
        }

    }


}