package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equal_returns_true_if_identical() {
        Team other = team;
        assertTrue(team.equals(other), "Team.equals() should return true when given itself");
    }

    @Test
    public void equal_returns_false_if_not_same_class() {
        String s = "";
        assertFalse(team.equals(s), "Team.equals() should return false when given a non-Team object");
    }

    @Test
    public void equal_returns_false_if_different_name() {
        Team other = new Team();
        other.setName("f00");
        other.setMembers(team.getMembers());
        assertFalse(team.equals(other), "Team.equals() should return false when team names are different");
    }

    @Test
    public void equal_returns_false_if_different_members() {
        Team other = new Team();
        other.setName(team.getName());
        other.addMember("new guy");
        assertFalse(team.equals(other), "Team.equals() should return false when member lists are different");
    }

    @Test
    public void equal_returns_true_if_equal() {
        Team other = new Team();
        other.setName(team.getName());
        other.setMembers(team.getMembers());
        assertTrue(team.equals(other), "Team.equals() should return true when teams are identical");
    }

    @Test
    public void hashCode_returns_correct_code() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(result, expectedResult);
    }
}
