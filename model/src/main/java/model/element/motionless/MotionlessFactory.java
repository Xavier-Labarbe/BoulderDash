package model.element.motionless;

import java.util.ArrayList;

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

    private final ArrayList<IMotionless> motionless = new ArrayList<IMotionless>();

    private final Exit exit;

    public MotionlessFactory(final IPlayableMap map) {
        this.exit = new Exit(map);
        this.motionless.add(border);
        this.motionless.add(dirt);
        this.motionless.add(explosableWall);
        this.motionless.add(tunnel);
        this.motionless.add(this.exit);
    }

    public IMotionless createExit() {
        return this.exit;
    }

    public IMotionless getFromFileSymbol(final String fileSymbol) {
        for (final IMotionless motionless : this.motionless) {
            if (motionless.getSprite().getConsoleImage().equals(fileSymbol)) {
                return motionless;
            }
        }
        return tunnel;
    }

}
