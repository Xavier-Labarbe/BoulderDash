package model.element.mobile;

import contract.IDiamond;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.IRock;
import model.PlayableMap;

public abstract class MobileFactory {

    private static IDiamond diamond = new Diamond(0, 0, new PlayableMap(2, 2, 2));
    private static Monster monster = new Monster(0, 0, new PlayableMap(2, 2, 2));
    private static IRock rock = new Rock(0, 0, new PlayableMap(2, 2, 2));
    private static IPlayer player = new Player(0, 0, new PlayableMap(2, 2, 2));
    private static final IMobile[] mobile = { diamond, monster, rock, player };

    public static IMobile createDiamond(final int x, final int y, final IPlayableMap playableMap) {
        return new Diamond(x, y, playableMap);
    }

    public static IMobile createDiamond(final int x, final int y, final IPlayableMap playableMap, final int notUse) {
        return new Diamond(x, y, playableMap, 0);
    }

    public static IMobile createMonster(final int x, final int y, final IPlayableMap playableMap) {
        return new Monster(x, y, playableMap);
    }

    public static IMobile createPlayer(final int x, final int y, final IPlayableMap playableMap) {
        return new Player(x, y, playableMap);
    }

    public static IMobile createRock(final int x, final int y, final IPlayableMap playableMap) {
        return new Rock(x, y, playableMap);
    }

    public static IMobile getFromFileSymbol(final String fileSymbol, final int x, final int y,
            final IPlayableMap playableMap) {
        for (final IMobile mobile : MobileFactory.mobile) {
            if (mobile.getSprite().getConsoleImage().equals(fileSymbol)) {
                switch (fileSymbol) {
                case "D":
                    return new Diamond(x, y, playableMap);
                case "P":
                    return new Player(x, y, playableMap);
                case "R":
                    return new Rock(x, y, playableMap);
                case "M":
                    return new Monster(x, y, playableMap);
                }
            }
        }
        return null;
    }

}