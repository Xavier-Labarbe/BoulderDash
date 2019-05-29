package model.element.mobile;

import contract.Permeability;
import contract.iSprite;
import model.PlayableMap;
import model.element.Sprite;
import model.element.motionless.Tunnel;

public class Monster extends AliveMobile implements IAliveMobile, IMonster {
    private static iSprite SPRITE = new Sprite('M', "Monster.jpg");
    private static Permeability PERMEABILITY = Permeability.PENETRABLE;
    private static Boolean EXPLOSABLE = true;
    private static StrategyMove STRATEGY_MOVE = new MoveAuto();
    private Boolean alive;

    public Monster(final int x, final int y, final PlayableMap map) {
        super(SPRITE, PERMEABILITY, EXPLOSABLE, x, y, STRATEGY_MOVE);
        this.setMap(map);
        this.getMap().setXYElement(x, y, this);
        this.getMap().addMobiles(this);
    }

    @Override
    public void createDiamonds() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable() == true) {
                    System.out.println(i + " " + j);

                    if (this.getMap().getXYElement(i, j) instanceof Mobile) {
                        this.getMap().addwaitingMobilesForRemoving((Mobile) this.getMap().getXYElement(i, j));
                    }
                    this.getMap().addwaitingMobilesForCreation(new Diamond(i, j, this.getMap(), 0));

                }
            }
        }
    }

    @Override
    public void explose() {
        final int x = this.getX();
        final int y = this.getY();
        for (int i = x - 1; i < ((3 + x) - 1); i++) {
            for (int j = y - 1; j < ((3 + y) - 1); j++) {
                if (this.getMap().getXYElement(i, j).isExplosable() == true) {
                    this.getMap().setXYElement(i, j, new Tunnel());
                }
            }
        }
    }

    @Override
    public Boolean isAlive() {
        // TODO Auto-generated method stub
        return this.alive;
    }

    @Override
    public void setAlive(final Boolean alive) {
        this.alive = alive;

    }

}
