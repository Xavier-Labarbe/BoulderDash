package model.element.mobile;

import contract.IDiamond;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.IRock;

public class MobileFactory {
    static int x;
    static int y;

    private final IMobile[] mobile = new IMobile[4];

    private IDiamond diamond;

    private Monster monster;
    private IRock rock;
    private IPlayer player;

    private IPlayableMap playableMap = null;

    public MobileFactory(final IPlayableMap map) {
        this.playableMap = map;
        this.resetFactory(0, 0, map);
    }

    public IMobile createDiamond(final int x, final int y, final IPlayableMap playableMap) {
        return new Diamond(x, y, playableMap);
    }

    public IMobile createMonster(final int x, final int y, final IPlayableMap playableMap) {
        return new Monster(x, y, playableMap);
    }

    public IMobile createPlayer(final int x, final int y, final IPlayableMap playableMap) {
        return new Player(x, y, playableMap);
    }

    public IMobile createRock(final int x, final int y, final IPlayableMap playableMap) {
        return new Rock(x, y, playableMap);
    }

    public IMobile getFromFileSymbol(final String fileSymbol, final int x, final int y,
            final IPlayableMap playableMap) {
        this.resetFactory(x, y, playableMap);
        for (final IMobile mobile : this.mobile) {
            if (mobile.getSprite().getConsoleImage().equals(fileSymbol)) {
                mobile.setX(x);
                mobile.setY(y);
                mobile.setMap(playableMap);
                playableMap.addMobiles(mobile);
                return mobile;
            }
        }
        return null;
    }

    private void resetFactory(final int x, final int y, final IPlayableMap playableMap) {
        this.diamond = new Diamond(x, y, this.playableMap);
        this.mobile[0] = this.diamond;
        this.monster = new Monster(x, y, this.playableMap);
        this.mobile[1] = this.monster;
        this.rock = new Rock(x, y, this.playableMap);
        this.mobile[2] = this.rock;
        this.player = new Player(x, y, this.playableMap);
        this.mobile[3] = this.player;
        this.playableMap.addwaitingMobilesForRemoving(this.diamond);
        this.playableMap.addwaitingMobilesForRemoving(this.monster);
        this.playableMap.addwaitingMobilesForRemoving(this.rock);
        this.playableMap.addwaitingMobilesForRemoving(this.player);
    }
}