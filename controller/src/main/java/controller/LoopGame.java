package controller;

import java.util.Iterator;

import contract.IController;
import contract.IFallingMobile;
import contract.ILoopGame;
import contract.IMobile;
import contract.IPlayableMap;
import contract.IPlayer;

public class LoopGame implements ILoopGame {
    private Boolean isRunning = true;
    private IController controller;

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

    @Override
    public IController getController() {
        return this.controller;
    }

    @Override
    public Boolean getIsRunning() {
        return this.isRunning;
    }

    @Override
    public void loopGame() throws InterruptedException {
        while (this.getIsRunning()) {
            this.doGameUpdates();
            this.render();
            Thread.sleep(100); // the timing mechanism
        }
    }

    private void render() {
        if (this.getIsRunning() == false) {
            System.out.println("Vous avez perdu... Ou gagné");
        }
    }

    @Override
    public void setController(final IController controller) {
        this.controller = controller;
    }

    @Override
    public void setIsRunning(final Boolean isRunning) {
        this.isRunning = isRunning;
    }
}
