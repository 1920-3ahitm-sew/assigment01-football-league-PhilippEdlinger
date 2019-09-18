package at.htl.football;

public class Team implements Comparable<Team> {

    private String name;
    private int points = 0;
    private int wins = 0;
    private int  draws = 0;
    private int  defeats = 0;
    private int goalShot = 0;
    private int goalsReceived = 0;

    //region Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
       this.points += points;
    }

    public int getWins() {
        return wins;
    }

    public void setWins() {
        this.wins++;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws() {
        this.draws++;
    }

    public int getDefeats() {
        return defeats;
    }

    public void setDefeats() {
        this.defeats++;
    }

    public int getGoalShot() {
        return goalShot;
    }

    public void setGoalShot(int shots) {
        this.goalShot += shots;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goals) {
        this.goalsReceived += goals;
    }
    //endregion

    public Team(String teamInfo){
    setName(teamInfo);
    }

    public void addMatch(Match match){
        // Verteilung der Punkte
        if(match.getHomeName().equals( this.getName())){
            if(match.getHomeGoals() > match.getGuestGoals()){
                setPoints(3);
                setWins();
            }
            if(match.getHomeGoals() < match.getGuestGoals()){
                setPoints(0);
                setDefeats();
            }
            if(match.getHomeGoals() == match.getGuestGoals()){
                setPoints(1);
                setDraws();
            }

            setGoalShot(match.getHomeGoals());
            setGoalsReceived(match.getGuestGoals());
        }

        if(match.getGuestName().equals( this.getName())){
            if(match.getHomeGoals() < match.getGuestGoals()){
                setPoints(3);
                setWins();
            }
            if(match.getHomeGoals() > match.getGuestGoals()){
                setPoints(0);
                setDefeats();
            }
            if(match.getHomeGoals() == match.getGuestGoals()){
                setPoints(1);
                setDraws();
            }
            setGoalShot(match.getGuestGoals());
            setGoalsReceived(match.getHomeGoals());
        }
    }

    public int getGoalsDifference(){

        return getGoalShot() - getGoalsReceived();
    }


    @Override
    public int compareTo(Team o) {
        if (this.getPoints() < o.getPoints()){
            return 1;
        }
        if (this.getPoints() > o.getPoints()){
            return -1;
        }
        else {
            return 0;
        }
    }
}
