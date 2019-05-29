/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.util.Iterator;

import model.PlayableMap;
import model.element.mobile.Mobile;
import model.element.mobile.Monster;
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

        playableMap.setXYElement(3, 1, new Rock(3, 1, playableMap));
        playableMap.setXYElement(3, 2, new Dirt());
        playableMap.setXYElement(3, 3, new Tunnel());
        playableMap.setXYElement(3, 4, new Tunnel());
        playableMap.setXYElement(3, 5, new Tunnel());
        playableMap.setXYElement(3, 6, new Tunnel());
        playableMap.setXYElement(3, 7, new Tunnel());
        playableMap.setXYElement(3, 8, new Tunnel());
        // playableMap.setXYElement(3, 1, new Dirt());
        // playableMap.setXYElement(3, 1, new Diamond(3, 1, playableMap));
        final Monster monster = new Monster(3, 8, playableMap);
        final Player player = new Player(2, 2, playableMap);
        while (player.isAlive() == true) {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (final Iterator<Mobile> i = playableMap.getWaitingMobilesForRemoving().iterator(); i.hasNext();) {
                final Mobile i_n = i.next();
                playableMap.removeMobiles(i_n);
                // i_n.getMap().setXYElement(i_n.getX(), i_n.getY(), new Tunnel());
                i.remove();
                System.out.println("supp");
            }
            for (final Iterator<Mobile> i = playableMap.getWaitingMobilesForCreation().iterator(); i.hasNext();) {
                final Mobile i_n = i.next();
                playableMap.addMobiles(i_n);
                i_n.getMap().setXYElement(i_n.getX(), i_n.getY(), i_n);
                i.remove();
                System.out.println("add");
            }
            for (int y = 0; y < 10; y++) {

                for (int x = 0; x < 10; x++) {
                    System.out.print(playableMap.getXYElement(x, y).getSprite().getConsoleImage() + " ");
                }
                System.out.println();

            }
            System.out.println();
            System.out.println();

            for (final Iterator<Mobile> i = playableMap.getMobiles().iterator(); i.hasNext();) {
                i.next().move();
            }

        }
        System.out.println("perdu");

    }
}
