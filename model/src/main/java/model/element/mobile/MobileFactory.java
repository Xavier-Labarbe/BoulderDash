package model.element.mobile;

import java.util.ArrayList;

import model.PlayableMap;

public class MobileFactory {
    static int x = 0;
    static int y = 0;

    private final ArrayList<Mobile> mobile = new ArrayList<Mobile>();

    private final Diamond diamond;

    private final Monster monster;
    private final Rock rock;
    private final Player player;

    private PlayableMap playableMap = null;

    public MobileFactory(final PlayableMap map) {
        this.playableMap = map;
        this.diamond = new Diamond(x, y, this.playableMap);
        this.mobile.add(this.diamond);
        this.monster = new Monster(x, y, this.playableMap);
        this.mobile.add(this.monster);
        this.rock = new Rock(x, y, this.playableMap);
        this.mobile.add(this.rock);
        this.player = new Player(x, y, this.playableMap);
        this.mobile.add(this.player);
    }

    public Mobile createDiamond(final int x, final int y, final PlayableMap playableMap) {
        return new Diamond(x, y, playableMap);
    }

    public Mobile createMonster(final int x, final int y, final PlayableMap playableMap) {
        return new Monster(x, y, playableMap);
    }

    public Mobile createPlayer(final int x, final int y, final PlayableMap playableMap) {
        return new Player(x, y, playableMap);
    }

    public Mobile createRock(final int x, final int y, final PlayableMap playableMap) {
        return new Rock(x, y, playableMap);
    }

    public Mobile getFromFileSymbol(final String fileSymbol, final int x, final int y, final PlayableMap playableMap) {
        for (final Mobile mobile : this.mobile) {
            if (mobile.getSprite().getConsoleImage().equals(fileSymbol)) {
                mobile.setX(x);
                mobile.setY(y);
                mobile.setMap(playableMap);
                return mobile;
            }
        }
        return null;
    }
}