package model.element.motionless;

import contract.DoorState;
import contract.IExit;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Exit.
 */
public class Exit extends Motionless implements IExit {
    
    /** The sprite. */
    private static ISprite sprite = new Sprite("E", "exit.png");
    
    /** The breakable. */
    private static Boolean breakable = false;
    
    /** The premeability. */
    private static Permeability premeability = Permeability.OPENABLE;
    
    /** The explosable. */
    private static Boolean explosable = false;
    
    /** The door state. */
    private DoorState doorState;

    /**
     * Instantiates a new exit.
     *
     * @param map the map
     */
    public Exit(final IPlayableMap map) {
        super(sprite, premeability, explosable, breakable);
        this.setDoorState(DoorState.CLOSE);
        map.setExit(this);
    }

    /**
     * Gets the door state.
     *
     * @return the door state
     */
    @Override
    public DoorState getDoorState() {
        return this.doorState;
    }

    /**
     * Open.
     */
    @Override
    public void open() {
        this.setDoorState(DoorState.OPEN);
    }

    /**
     * Sets the door state.
     *
     * @param doorState the new door state
     */
    private void setDoorState(final DoorState doorState) {
        this.doorState = doorState;
    }

}
