package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import contract.IPlayer;

// TODO: Auto-generated Javadoc
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

    /**
     * Instantiates a new view panel.
     *
     * @param viewFrame the view frame
     */
    public ViewPanel(final ViewFrame viewFrame) {

        this.setViewFrame(viewFrame);

        viewFrame.getModel().getPlayableMap().getObservable().addObserver(this);
    }

    /**
     * Gets the component graphics.
     *
     * @param g the g
     * @return the component graphics
     */
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

    /**
     * Paint component.
     *
     * @param graphics the graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {

        final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        final double width = gd.getDisplayMode().getWidth();
        final double height = gd.getDisplayMode().getHeight();

        graphics.clearRect(0, 0, this.getViewFrame().getModel().getPlayableMap().getWidth(),
                this.getViewFrame().getModel().getPlayableMap().getHeight());
        graphics = this.getComponentGraphics(graphics);
        final IPlayer player = this.getViewFrame().getModel().getPlayableMap().getPlayer();
        final int playerX = player.getX();
        final int playerY = player.getY();

        if (player.isAlive()) {

            graphics.translate(((-(playerX * 16) + (((int) width / 16) * 2))),
                    -(playerY * 16) + ((((int) height / 16) * 2)));
            for (int i = 0; i < this.viewFrame.getModel().getPlayableMap().getWidth(); i++) {
                for (int j = 0; j < this.viewFrame.getModel().getPlayableMap().getWidth(); j++) {

                    graphics.drawImage(
                            this.getViewFrame().getModel().getPlayableMap().getXYElement(i, j).getSprite().getImage(),
                            i * 16, j * 16, null);
                }
            }
        } else {

            this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(this.getViewFrame(), "Game over", "You loose...", JOptionPane.ERROR_MESSAGE);
            System.exit(0);

        }

        if (this.getViewFrame().getModel().getPlayableMap().isWin().equals(true)) {
            this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(this.getViewFrame(), "Well done ", "You win !", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    /**
     * Sets the view frame.
     *
     * @param viewFrame the new view frame
     */
    private void setViewFrame(final ViewFrame viewFrame) {
        this.viewFrame = viewFrame;
    }

    /**
     * Update.
     *
     * @param arg0 the arg 0
     * @param arg1 the arg 1
     */
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
