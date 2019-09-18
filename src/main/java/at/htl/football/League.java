package at.htl.football;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.Collection.*;
import java.io.IOException;
import java.nio.file.Paths;


public class League  {


    private List<Team> teams = new ArrayList<>();

    public League(){
        //File einlesen
        Path path = Paths.get("bundesliga-1819.csv");
        try{
         List lines = Files.readAllLines(path);
         String[] splitter;

         for(int i = 1; i < lines.size() ; i++){
             splitter = lines.get(i).toString().split(";");
             this.addMatchResult(new Match(splitter[1], splitter[2], Integer.parseInt(splitter[3]), Integer.parseInt(splitter[4])));
         }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addMatchResult(Match matches) {

        findOrCreateTeam(matches.getHomeName()).addMatch(matches);
        findOrCreateTeam(matches.getGuestName()).addMatch(matches);
    }

    private Team findOrCreateTeam(String teamName){
        // Liste der Teams wird durchsucht
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
