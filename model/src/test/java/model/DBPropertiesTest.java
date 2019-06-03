package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBPropertiesTest {
	String expected = "bonjour";
	private DBProperties DBproperties = new DBProperties();
	
	@Test
    public void setURLTest() {
        this.DBproperties.setUrl(expected);
        assertEquals(expected, this.DBproperties.getUrl());
    }

    @Test
    public void getURLTest() {
        assertEquals("jdbc:mysql://localhost/jpublankproject?autoReconnect=true&useSSL=false", this.DBproperties.getUrl());
    }
    
    @Test
    public void setLoginTest() {
        this.DBproperties.setLogin(expected);
        assertEquals(expected, this.DBproperties.getLogin());
    }

    @Test
    public void getLoginTest() {
        assertEquals("root", this.DBproperties.getLogin());
    }
    
    @Test
    public void setPasswordTest() {
        this.DBproperties.setPassword(expected);
        assertEquals(expected, this.DBproperties.getPassword());
    }

    @Test
    public void getPasswordTest() {
        assertEquals("", this.DBproperties.getPassword());
    }
}
