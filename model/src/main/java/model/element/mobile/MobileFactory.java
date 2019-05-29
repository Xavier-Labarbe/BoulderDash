package model.element.mobile;

import model.PlayableMap;

public class MobileFactory {
    static int x;
    static int y;
    static PlayableMap playableMap;
    private static Diamond diamond = new Diamond(x, y, playableMap);
    private static Monster monster = new Monster(x, y, playableMap);
    private static Rock rock = new Rock(x, y, playableMap);
    private static Player player = new Player(x, y, playableMap);
    private static Mobile[] mobile = { diamond, monster, rock, player, };

    public static Mobile getFromFileSymbol(final String fileSymbol, final int x, final int y,
            final PlayableMap playableMap) {
        for (final Mobile mobile : mobile) {
            if (mobile.getSprite().getConsoleImage() == fileSymbol) {
                mobile.setX(x);
                mobile.setY(y);
                mobile.setMap(playableMap);
                return mobile;
            }
        }
        return null;
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
}