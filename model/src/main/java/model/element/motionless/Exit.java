package model.element.motionless;

import contract.Permeability;
import contract.iSprite;
import model.element.Sprite;

public class Exit extends Motionless {
    private static iSprite SPRITE = new Sprite("E", "Exit.jpg");
    private static Boolean BREAKABLE = false;
    private static Permeability PERMEABILITY = Permeability.OPENABLE;
    private static Boolean EXPLOSABLE = false;
    private DoorState doorState;

    public Exit() {
        super(SPRITE, PERMEABILITY, EXPLOSABLE);
        this.setBreakable(BREAKABLE);
        this.setDoorState(DoorState.CLOSE);
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
