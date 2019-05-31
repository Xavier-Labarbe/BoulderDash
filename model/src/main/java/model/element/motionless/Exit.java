package model.element.motionless;

import contract.DoorState;
import contract.IExit;
import contract.IPlayableMap;
import contract.ISprite;
import contract.Permeability;
import model.element.Sprite;

public class Exit extends Motionless implements IExit {
    private static ISprite sprite = new Sprite("E", "Exit.jpg");
    private static Boolean breakable = false;
    private static Permeability premeability = Permeability.OPENABLE;
    private static Boolean explosable = false;
    private DoorState doorState;

    public Exit(final IPlayableMap map) {
        super(sprite, premeability, explosable, breakable);
        this.setDoorState(DoorState.CLOSE);
        map.setExit(this);
    }

    @Override
    public DoorState getDoorState() {
        return this.doorState;
    }

    @Override
    public void open() {
        this.setDoorState(DoorState.OPEN);
    }

    private void setDoorState(final DoorState doorState) {
        this.doorState = doorState;
    }

}
