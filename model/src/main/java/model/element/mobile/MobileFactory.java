package model.element.mobile;

import contract.IDiamond;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;
import contract.IRock;
import model.PlayableMap;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Mobile objects.
 */
public abstract class MobileFactory {

    /** The diamond. */
    private static IDiamond diamond = new Diamond(0, 0, new PlayableMap(2, 2, 2));
    
    /** The monster. */
    private static Monster monster = new Monster(0, 0, new PlayableMap(2, 2, 2));
    
    /** The rock. */
    private static IRock rock = new Rock(0, 0, new PlayableMap(2, 2, 2));
    
    /** The player. */
    private static IPlayer player = new Player(0, 0, new PlayableMap(2, 2, 2));
    
    /** The Constant mobile. */
    private static final IMobile[] mobile = { diamond, monster, rock, player };

    /**
     * Creates a new Mobile object.
     *
     * @param x the x
     * @param y the y
     * @param playableMap the playable map
     * @return the i mobile
     */
    public static IMobile createDiamond(final int x, final int y, final IPlayableMap playableMap) {
        return new Diamond(x, y, playableMap);
    }

    /**
     * Creates a new Mobile object.
     *
     * @param x the x
     * @param y the y
     * @param playableMap the playable map
     * @param notUse the not use
     * @return the i mobile
     */
    public static IMobile createDiamond(final int x, final int y, final IPlayableMap playableMap, final int notUse) {
        return new Diamond(x, y, playableMap, 0);
    }

    /**
     * Creates a new Mobile object.
     *
     * @param x the x
     * @param y the y
     * @param playableMap the playable map
     * @return the i mobile
     */
    public static IMobile createMonster(final int x, final int y, final IPlayableMap playableMap) {
        return new Monster(x, y, playableMap);
    }

    /**
     * Creates a new Mobile object.
     *
     * @param x the x
     * @param y the y
     * @param playableMap the playable map
     * @return the i mobile
     */
    public static IMobile createPlayer(final int x, final int y, final IPlayableMap playableMap) {
        return new Player(x, y, playableMap);
    }

    /**
     * Creates a new Mobile object.
     *
     * @param x the x
     * @param y the y
     * @param playableMap the playable map
     * @return the i mobile
     */
    public static IMobile createRock(final int x, final int y, final IPlayableMap playableMap) {
        return new Rock(x, y, playableMap);
    }

    /**
     * Gets the from file symbol.
     *
     * @param fileSymbol the file symbol
     * @param x the x
     * @param y the y
     * @param playableMap the playable map
     * @return the from file symbol
     */
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