package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class ModelTest {
	PlayableMap playableMap;
	private Model model = new Model();
	
	@Test
    public void setPlayableMapTest() {
        this.model.setPlayableMap(playableMap);
        assertEquals(playableMap, this.model.getPlayableMap());
    }

    @Test
    public void getIsRunningTest() {
        assertEquals(playableMap, this.model.getPlayableMap());
    }
}
