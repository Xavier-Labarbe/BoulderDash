package model.element.motionless;

public class MotionlessFactory {
    private static Exit exit = new Exit();
    private static Border border = new Border();
    private static ExplosableWall explosableWall = new ExplosableWall();
    private static Dirt dirt = new Dirt();
    private static Tunnel tunnel = new Tunnel();
    private static Motionless[] motionless = { exit, border, explosableWall, dirt, tunnel, };

    public static Motionless getFromFileSymbol(final char fileSymbol) {
        for (final Motionless motionless : motionless) {
            if (motionless.getSprite().getConsoleImage() == fileSymbol) {
                return motionless;
            }
        }
        return tunnel;
    }

    public Motionless createBorder() {
        return border;
    }

    public Motionless createDirt() {
        return dirt;
    }

    public Motionless createExit() {
        return exit;
    }

    public Motionless createExplosableWall() {
        return explosableWall;
    }

    public Motionless createTunnel() {
        return tunnel;
    }

}
