package view;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
     * Gets the view frame.
     *
     * @return the view frame
     */
    private ViewFrame getViewFrame() {
        return this.viewFrame;
    }

    /*
     * (non-Javadoc)
     *
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    protected void paintComponent(final Graphics graphics) {
        graphics.clearRect(0, 0, this.getViewFrame().getModel().getPlayableMap().getWidth(),
                this.getViewFrame().getModel().getPlayableMap().getHeight());
        if (this.getViewFrame().getModel().getPlayableMap().getPlayer().isAlive()) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
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
