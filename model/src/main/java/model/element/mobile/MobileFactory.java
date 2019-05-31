package model.element.mobile;

import contract.IDiamond;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.IRock;

public class MobileFactory {
    static int x = 0;
    static int y = 0;
    static IPlayableMap playableMap;
    private static IDiamond diamond = new Diamond(x, y, playableMap);
    private static Monster monster = new Monster(x, y, playableMap);
    private static IRock rock = new Rock(x, y, playableMap);
    private static IPlayer player = new Player(x, y, playableMap);
    private static IMobile[] mobile = { diamond, monster, rock, player, };

    public static IMobile getFromFileSymbol(final char fileSymbol, final int x, final int y,
            final IPlayableMap playableMap) {
        for (final IMobile mobile : mobile) {
            if (mobile.getSprite().getConsoleImage() == fileSymbol) {
                mobile.setX(x);
                mobile.setY(y);
                mobile.setMap(playableMap);
                return mobile;
            }
        }
        return null;
    }

    public MobileFactory(final IPlayableMap map) {
        MobileFactory.playableMap = map;
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
}