/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import model.PlayableMap;
import model.element.mobile.Mobile;
import model.element.mobile.Player;
import model.element.mobile.Rock;
import model.element.motionless.Border;
import model.element.motionless.Dirt;
import model.element.motionless.Tunnel;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        final PlayableMap playableMap = new PlayableMap();

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if ((x == 0) || (x == 9) || (y == 0) || (y == 9)) {
                    playableMap.setXYElement(x, y, new Border());
                } else {
                    playableMap.setXYElement(x, y, new Dirt());
                }
            }
        }
        final Player player = new Player(4, 6, playableMap);
        final Rock rock = new Rock(4, 1, playableMap);
        // final Monster monster3 = new Monster(6, 3, playableMap);
        final Boolean displayed;
        playableMap.setXYElement(8, 5, new Tunnel());
        playableMap.setXYElement(8, 6, new Tunnel());
        playableMap.setXYElement(7, 3, new Tunnel());
        playableMap.setXYElement(8, 3, new Tunnel());
        playableMap.setXYElement(8, 5, new Tunnel());
        playableMap.setXYElement(5, 3, new Tunnel());
        playableMap.setXYElement(3, 3, new Tunnel());
        playableMap.setXYElement(4, 3, new Tunnel());
        playableMap.setXYElement(4, 2, new Tunnel());
        playableMap.setXYElement(4, 4, new Tunnel());
        playableMap.setXYElement(4, 5, new Tunnel());
        playableMap.setXYElement(5, 3, new Tunnel());
        playableMap.setXYElement(5, 2, new Tunnel());
        playableMap.setXYElement(5, 4, new Tunnel());
        while (player.isAlive() == true) {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (final Mobile mobile : playableMap.getMobiles()) {
                mobile.move();
            }
            for (int y = 0; y < 10; y++) {

                for (int x = 0; x < 10; x++) {
                    System.out.print(playableMap.getXYElement(x, y).getSprite().getConsoleImage() + " ");
                }
                System.out.println();

            }
            System.out.println();
            System.out.println();

        }
        System.out.println("perdu");

    }
}
