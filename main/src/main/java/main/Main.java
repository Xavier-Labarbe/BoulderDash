/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.util.Iterator;

import contract.IMobile;
import contract.IPlayableMap;
import model.PlayableMap;
import model.element.mobile.Diamond;
import model.element.mobile.Monster;
import model.element.mobile.Player;
import model.element.mobile.Rock;
import model.element.motionless.Border;
import model.element.motionless.Dirt;
import model.element.motionless.Exit;
import model.element.motionless.ExplosableWall;
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
        final IPlayableMap playableMap = new PlayableMap(2);

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                if ((x == 0) || (x == 9) || (y == 0) || (y == 9)) {
                    playableMap.setXYElement(x, y, new Border());
                } else {
                    playableMap.setXYElement(x, y, new Dirt());
                }
            }
        }
        playableMap.setXYElement(8, 2, new Exit(playableMap));
        playableMap.setXYElement(3, 1, new Rock(3, 1, playableMap));
        playableMap.setXYElement(3, 2, new Dirt());
        playableMap.setXYElement(3, 3, new Tunnel());
        playableMap.setXYElement(3, 4, new Tunnel());
        playableMap.setXYElement(3, 5, new Tunnel());
        playableMap.setXYElement(3, 6, new Tunnel());
        playableMap.setXYElement(3, 7, new Tunnel());
        playableMap.setXYElement(3, 8, new Tunnel());
        playableMap.setXYElement(4, 5, new ExplosableWall());
        playableMap.setXYElement(5, 2, new Diamond(5, 2, playableMap));
        playableMap.setXYElement(6, 2, new Tunnel());
        playableMap.setXYElement(7, 2, new Tunnel());
        // playableMap.setXYElement(6, 2, new Diamond(6, 2, playableMap));
        playableMap.setXYElement(4, 7, new Tunnel());
        playableMap.setXYElement(5, 7, new Tunnel());
        // playableMap.setXYElement(3, 1, new Dirt());
        // playableMap.setXYElement(3, 1, new Diamond(3, 1, playableMap));
        final Monster monster = new Monster(3, 8, playableMap);
        final Player player = new Player(2, 2, playableMap);
        while ((player.isAlive() == true) && (playableMap.getWin() == false)) {
            try {
                Thread.sleep(1000);
            } catch (final InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            for (final Iterator<IMobile> i = playableMap.getWaitingMobilesForRemoving().iterator(); i.hasNext();) {
                final IMobile i_n = i.next();
                playableMap.removeMobiles(i_n);
                // i_n.getMap().setXYElement(i_n.getX(), i_n.getY(), new Tunnel());
                i.remove();
                System.out.println("supp");
            }
            for (final Iterator<IMobile> i = playableMap.getWaitingMobilesForCreation().iterator(); i.hasNext();) {
                final IMobile i_n = i.next();
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

            for (final Iterator<IMobile> i = playableMap.getMobiles().iterator(); i.hasNext();) {
                i.next().move();
            }

        }
        System.out.println("perdu ou gagné");

    }
}
