package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Tyler", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("Tylerraff", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_with_correct_name() {
        Team t = Developer.getTeam();
        assertEquals("f26-11", t.getName());
    }

    @Test
    public void getTeam_returns_with_Brandon() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Brandon S."), "Team should contain Brandon S.");
    }

    @Test
    public void getTeam_returns_with_Chazz() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Chazz"), "Team should contain Chazz.");
    }

    @Test
    public void getTeam_returns_with_David() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("David"), "Team should contain David.");
    }

    @Test
    public void getTeam_returns_with_Edward() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Edward"), "Team should contain Edward.");
    }  

    @Test
    public void getTeam_returns_with_Noah() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Noah R."), "Team should contain Noah R.");
    }

    @Test
    public void getTeam_returns_with_Tyler() {
        Team t = Developer.getTeam();
        assertTrue(t.getMembers().contains("Tyler"), "Team should contain Tyler.");
    }

    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
