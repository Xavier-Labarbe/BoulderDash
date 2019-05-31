package model.element.motionless;

import contract.IPlayableMap;

public class MotionlessFactory {
    private static Border border = new Border();
    private static ExplosableWall explosableWall = new ExplosableWall();
    private static Dirt dirt = new Dirt();
    private static Tunnel tunnel = new Tunnel();

    public static IMotionless createBorder() {
        return border;
    }

    public static IMotionless createDirt() {
        return dirt;
    }

    public static IMotionless createExplosableWall() {
        return explosableWall;
    }

    public static IMotionless createTunnel() {
        return tunnel;
    }

    private final IMotionless[] motionless = { border, explosableWall, dirt, tunnel };

    private final Exit exit;

    public MotionlessFactory(final IPlayableMap map) {
        this.exit = new Exit(map);
        this.motionless[4] = this.exit;
    }

    public IMotionless createExit() {
        return this.exit;
    }

    public IMotionless getFromFileSymbol(final String fileSymbol) {
        for (final IMotionless motionless : this.motionless) {
            if (motionless.getSprite().getConsoleImage() == fileSymbol) {
                return motionless;
            }
        }
        return tunnel;
    }

}
