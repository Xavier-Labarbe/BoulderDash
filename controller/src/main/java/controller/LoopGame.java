package controller;

import java.util.Iterator;

import contract.IController;
import contract.IFallingMobile;
import contract.ILoopGame;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;

// TODO: Auto-generated Javadoc
/**
 * The Class LoopGame.
 */
public class LoopGame implements ILoopGame {

    /** The is running. */
    private Boolean isRunning = true;

    /** The controller. */
    private IController controller;

    /**
     * Do game updates.
     */
    private void doGameUpdates() {
        final IPlayableMap map = this.controller.getModel().getPlayableMap();
        if (map.getPlayer().isAlive() && (map.isWin() == false)) {
            for (final Iterator<IMobile> i = map.getWaitingMobilesForRemoving().iterator(); i.hasNext();) {
                final IMobile i_n = i.next();
                map.removeMobiles(i_n);
                i.remove();
                System.out.println("supp");
            }
            for (final Iterator<IMobile> i = map.getWaitingMobilesForCreation().iterator(); i.hasNext();) {
                final IMobile i_n = i.next();
                map.addMobiles(i_n);
                i_n.getMap().setXYElement(i_n.getX(), i_n.getY(), i_n);
                i.remove();
                System.out.println("add");
            }

            for (final Iterator<IMobile> i = map.getMobiles().iterator(); i.hasNext();) {
                final IMobile i_n = i.next();
                if (i_n instanceof IPlayer) {
                } else if (i_n instanceof IFallingMobile) {
                    i_n.move();
                }
                if (i_n instanceof IFallingMobile) {
                    ((IFallingMobile) i_n).setFrozen(false);
                }
            }
            for (final Iterator<IMobile> i = map.getMobiles().iterator(); i.hasNext();) {
                final IMobile i_n = i.next();
                if (i_n instanceof IPlayer) {
                } else if (i_n instanceof IFallingMobile) {
                } else {
                    i_n.move();
                }
                if (i_n instanceof IFallingMobile) {
                    ((IFallingMobile) i_n).setFrozen(false);
                }
            }

            this.getController().getModel().getPlayableMap().getPlayer().move();
        } else {
            this.setIsRunning(false);
        }
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    @Override
    public IController getController() {
        return this.controller;
    }

    /**
     * Gets the checks if is running.
     *
     * @return the checks if is running
     */
    @Override
    public Boolean getIsRunning() {
        return this.isRunning;
    }

    /**
     * Loop game.
     *
     * @throws InterruptedException the interrupted exception
     */
    @Override
    public void loopGame() throws InterruptedException {
        while (this.getIsRunning()) {
            this.doGameUpdates();
            this.render();
            Thread.sleep(100); // the timing mechanism
        }
    }

    /**
     * Render.
     */
    private void render() {
        if (this.getIsRunning() == false) {
            System.out.println("Vous avez perdu... Ou gagné");
        }
    }

    /**
     * Sets the controller.
     *
     * @param controller the new controller
     */
    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }

    /**
     * Sets the checks if is running.
     *
     * @param isRunning the new checks if is running
     */
    @Override
    public void setIsRunning(final Boolean isRunning) {
        this.isRunning = isRunning;
    }
}
