package model.element.mobile;

import contract.IDiamond;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.IRock;

public class MobileFactory {
    static int x = 0;
    static int y = 0;

    private final IMobile[] mobile = new IMobile[4];

    private final IDiamond diamond;

    private final Monster monster;
    private final IRock rock;
    private final IPlayer player;

    private IPlayableMap playableMap = null;

    public MobileFactory(final IPlayableMap map) {
        this.playableMap = map;
        this.diamond = new Diamond(x, y, this.playableMap);
        this.mobile[0] = this.diamond;
        this.monster = new Monster(x, y, this.playableMap);
        this.mobile[1] = this.diamond;
        this.rock = new Rock(x, y, this.playableMap);
        this.mobile[2] = this.diamond;
        this.player = new Player(x, y, this.playableMap);
        this.mobile[3] = this.diamond;
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
        for (final IMobile mobile : this.mobile) {
            if (mobile.getSprite().getConsoleImage() == fileSymbol) {
                mobile.setX(x);
                mobile.setY(y);
                mobile.setMap(playableMap);
                return mobile;
            }
        }
        return null;
    }
}