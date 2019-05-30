package model.element.motionless;

import contract.Permeability;
import contract.ISprite;
import model.IPlayableMap;
import model.element.Sprite;

public class Exit extends Motionless {
    private static ISprite sprite = new Sprite('E', "Exit.jpg");
    private static Boolean breakable = false;
    private static Permeability premeability = Permeability.OPENABLE;
    private static Boolean explosable = false;
    private DoorState doorState;

    public Exit(final IPlayableMap map) {
        super(sprite, premeability, explosable, breakable);
        this.setDoorState(DoorState.CLOSE);
        map.setExit(this);
    }

    public DoorState getDoorState() {
        return this.doorState;
    }

    public void open() {
        this.setDoorState(DoorState.OPEN);
    }

    private void setDoorState(final DoorState doorState) {
        this.doorState = doorState;
    }

}
