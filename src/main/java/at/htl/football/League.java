package at.htl.football;

import java.util.*;
import java.util.Collection.*;
import java.io.IOException;
import java.nio.file.Paths;


public class League  {

    private List<Team> teams = new ArrayList<>();

    public League(){

        try (Scanner scanner = new Scanner(Paths.get("bundesliga-1819.csv"))){
            scanner.nextLine();
            do{
                String [] splitter = new String[5];
                splitter = scanner.nextLine().split(";");
                 this.addMatchResult(new Match(splitter[1], splitter[2], Integer.parseInt(splitter[3]), Integer.parseInt(splitter[4])));

            } while (scanner.hasNextLine());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMatchResult(Match matches) {

        findOrCreateTeam(matches.getHomeName()).addMatch(matches);
        findOrCreateTeam(matches.getGuestName()).addMatch(matches);
    }

    private Team findOrCreateTeam(String teamName){

        for (int  i = 0; i < teams.size(); i++){
            if (teamName.equals(teams.get(i).getName())){
                return teams.get(i);
            }
        }

        Team team = new Team(teamName);
        teams.add(team);

        return team;
    }

    public List<Team> getTable(){
        Collections.sort(teams);
       return teams;
    }

}
