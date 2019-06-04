package model.element.motionless;

import model.PlayableMap;

public abstract class MotionlessFactory {
    private static Border border = new Border();
    private static ExplosableWall explosableWall = new ExplosableWall();
    private static Dirt dirt = new Dirt();
    private static Tunnel tunnel = new Tunnel();
    private static final Exit exit = new Exit(new PlayableMap(1, 1, 1));

    private static final IMotionless[] motionless = { tunnel, dirt, exit, border, explosableWall };

    public static IMotionless createBorder() {
        return border;
    }

    public static IMotionless createDirt() {
        return dirt;
    }

    public static IMotionless createExit() {
        return MotionlessFactory.exit;
    }

    public static IMotionless createExplosableWall() {
        return explosableWall;
    }

    public static IMotionless createTunnel() {
        return tunnel;
    }

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
