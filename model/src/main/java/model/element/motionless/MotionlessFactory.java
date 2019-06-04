package model.element.motionless;

import model.PlayableMap;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Motionless objects.
 */
public abstract class MotionlessFactory {
    
    /** The border. */
    private static Border border = new Border();
    
    /** The explosable wall. */
    private static ExplosableWall explosableWall = new ExplosableWall();
    
    /** The dirt. */
    private static Dirt dirt = new Dirt();
    
    /** The tunnel. */
    private static Tunnel tunnel = new Tunnel();
    
    /** The Constant exit. */
    private static final Exit exit = new Exit(new PlayableMap(1, 1, 1));

    /** The Constant motionless. */
    private static final IMotionless[] motionless = { tunnel, dirt, exit, border, explosableWall };

    /**
     * Creates a new Motionless object.
     *
     * @return the i motionless
     */
    public static IMotionless createBorder() {
        return border;
    }

    /**
     * Creates a new Motionless object.
     *
     * @return the i motionless
     */
    public static IMotionless createDirt() {
        return dirt;
    }

    /**
     * Creates a new Motionless object.
     *
     * @return the i motionless
     */
    public static IMotionless createExit() {
        return MotionlessFactory.exit;
    }

    /**
     * Creates a new Motionless object.
     *
     * @return the i motionless
     */
    public static IMotionless createExplosableWall() {
        return explosableWall;
    }

    /**
     * Creates a new Motionless object.
     *
     * @return the i motionless
     */
    public static IMotionless createTunnel() {
        return tunnel;
    }

    /**
     * Gets the from file symbol.
     *
     * @param fileSymbol the file symbol
     * @param playableMap the playable map
     * @return the from file symbol
     */
    public static IMotionless getFromFileSymbol(final String fileSymbol, final PlayableMap playableMap) {
        for (final IMotionless motionless : motionless) {
            if (motionless.getSprite().getConsoleImage().equals(fileSymbol)) {
                if (motionless instanceof Exit) {
                    return new Exit(playableMap);
                } else {
                    return motionless;
                }
            }
        }
        return tunnel;
    }

}
