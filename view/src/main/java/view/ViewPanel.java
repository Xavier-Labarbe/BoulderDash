package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import contract.IPlayer;

/**
 * The Class ViewPanel.
 *
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -998294702363713521L;
    /** The view frame. */
    private ViewFrame viewFrame;
    int previousPosX;
    int previousPosY;
    int previousX;
    int previousY;
    int countX;
    int countY;
    boolean motionCamera = true;

    /**
     * Instantiates a new view panel.
     *
     * @param viewFrame the view frame
     */
    public ViewPanel(final ViewFrame viewFrame) {

        this.setViewFrame(viewFrame);
        viewFrame.getModel().getPlayableMap().getObservable().addObserver(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected Graphics getComponentGraphics(final Graphics g) {
        final Graphics2D g2d = (Graphics2D) g;
        // g2d.translate(9, 2);
        g2d.scale(2, 2);

        return super.getComponentGraphics(g2d);
    }

    /**
     * Gets the view frame.
     *
     * @return the view frame
     */
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        this.reloadImage();
        graphics.clearRect(0, 0, this.getViewFrame().getModel().getPlayableMap().getWidth(),
                this.getViewFrame().getModel().getPlayableMap().getHeight());
        graphics = this.getComponentGraphics(graphics);
        final IPlayer player = this.getViewFrame().getModel().getPlayableMap().getPlayer();
        graphics.translate(-(player.getX() * 16) + (16 * 7), -(player.getY() * 16) + (16 * 7));

        // // when player forward
        // if ((this.previousPosX - player.getX()) == 1) {
        // this.countX--;
        // }
        // // when player backward
        // if ((this.previousPosX - player.getX()) == -1) {
        // this.countX++;
        // }
        // // when player go down
        // if ((this.previousPosY - player.getY()) == 1) {
        // this.countY--;
        // }
        // // when player go up
        // if ((this.previousPosY - player.getY()) == -1) {
        // this.countY++;
        // }
        //
        // System.out.println("countX: " + this.countX);
        // System.out.println("countY: " + this.countY);
        //
        // if ((this.countX > 4) || (this.countX < -4)) {
        // this.motionCamera = true;
        // this.countX = 0;
        // }
        //
        // if ((this.countY > 4) || (this.countY < -4)) {
        // this.motionCamera = true;
        // this.countY = 0;
        // }
        //
        // if (this.motionCamera == false) {
        // graphics.translate(-(this.previousX * 16) + (16 * 7),
        // -(this.previousY * 16) + (16 * 7));
        // }
        // if (this.motionCamera == true) {
        // graphics.translate(-(player.getX() * 16) + (16 * 7), -(player.getY()
        // * 16) + (16 * 7));
        // this.previousX = player.getX();
        // this.previousY = player.getY();
        // this.motionCamera = false;
        // }

        System.out.print("Position joueur : " + player.getX() + " ");
        System.out.println("Position du zoom : " + (-(player.getX() * 16) + (16 * 7)));

        // if (player.getX() > (-(player.getX() * 16) + (16 * 7))) {

        // }

        // if ((((player.getX() % 16) <= 5) && ((player.getX() % 16) > 0))
        // || (((player.getX() % 16) <= -5) && ((player.getX() % 16) < 0))) {
        // graphics.translate(-(player.getX() * 16) + (16 * 7), -(player.getY()
        // * 16) + (16 * 7));
        // }

        if (player.isAlive()) {

            for (int i = 0; i < this.getViewFrame().getModel().getPlayableMap().getWidth(); i++) {
                for (int j = 0; j < this.getViewFrame().getModel().getPlayableMap().getHeight(); j++) {
                    graphics.drawImage(
                            this.getViewFrame().getModel().getPlayableMap().getXYElement(i, j).getSprite().getImage(),
                            i * 16, j * 16, null);
                }
            }
        } else {
            this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(this.getViewFrame(), "Your are dead ! ", "Try again !",
                    JOptionPane.ERROR_MESSAGE);
        }

        if (this.getViewFrame().getModel().getPlayableMap().isWin().equals(true)) {
            this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(this.getViewFrame(), "Bravo ", "Vous avez gagné !",
                    JOptionPane.ERROR_MESSAGE);
        }

        // graphics.drawImage(this.getViewFrame().getModel().getPlayableMap().getXYElement(1,
        // 6).getSprite().getImage(), 0,
        // 0, null);
        this.previousPosX = player.getX();
        this.previousPosY = player.getY();
    }

    private void reloadImage() {
        for (int x = 0; x < this.getViewFrame().getModel().getPlayableMap().getWidth(); x++) {
            for (int y = 0; y < this.getViewFrame().getModel().getPlayableMap().getHeight(); y++) {
                try {
                    this.getViewFrame().getModel().getPlayableMap().getXYElement(x, y).getSprite().loadImage();
                } catch (final IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    // graphics.drawImage(this.getViewFrame().getModel().getPlayableMap().getXYElement(1,
    // 6).getSprite().getImage(), 0,
    // 0, null);

    /**
     * Sets the view frame.
     *
     * @param viewFrame the new view frame
     */
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    @Override
    public void update(final Observable arg0, final Object arg1) {
        this.repaint();
    }
}
