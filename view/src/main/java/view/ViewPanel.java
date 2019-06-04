package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
    boolean start = false;

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
        // this.reloadImage();
        graphics.clearRect(0, 0, this.getViewFrame().getModel().getPlayableMap().getWidth(),
                this.getViewFrame().getModel().getPlayableMap().getHeight());
        graphics = this.getComponentGraphics(graphics);
        final IPlayer player = this.getViewFrame().getModel().getPlayableMap().getPlayer();
        graphics.translate(-(player.getX() * 16) + (16 * 7), -(player.getY() * 16) + (16 * 7));

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

    }

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
