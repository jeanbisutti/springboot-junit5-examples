package football.dto;

import java.io.Serializable;

public class PlayerWithTeamName implements Serializable {

    private String firstName;

    private String lastName;

    private String team;

    public PlayerWithTeamName(String firstName, String lastName, String team) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.team = team;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTeam() {
        return team;
    }

}
