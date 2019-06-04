package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JDialog;
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
    boolean start = true;
    private boolean newGame = false;

    /**
     * Instantiates a new view panel.
     *
     * @param viewFrame
     *            the view frame
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

    public boolean isNewGame() {
        return this.newGame;
    }

    // graphics.drawImage(this.getViewFrame().getModel().getPlayableMap().getXYElement(1,
    // 6).getSprite().getImage(), 0,
    // 0, null);

    @Override
    protected void paintComponent(Graphics graphics) {

        // if (this.start == true) {
        // graphics.drawImage();
        // }

        final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        final double width = gd.getDisplayMode().getWidth();
        final double height = gd.getDisplayMode().getHeight();
        // final ImageFilter filter = new RGBImageFilter() {
        // int transparentColor = Color.white.getRGB() | 0xFF000000;
        //
        // @Override
        // public final int filterRGB(final int x, final int y, final int rgb) {
        // if ((rgb | 0xFF000000) == this.transparentColor) {
        // return 0x00FFFFFF & rgb;
        // } else {
        // return rgb;
        // }
        // }
        // };

        graphics.clearRect(0, 0, this.getViewFrame().getModel().getPlayableMap().getWidth(),
                this.getViewFrame().getModel().getPlayableMap().getHeight());
        graphics = this.getComponentGraphics(graphics);
        final IPlayer player = this.getViewFrame().getModel().getPlayableMap().getPlayer();
        final int playerX = player.getX();
        final int playerY = player.getY();

        // graphics.translate(-(player.getX() * 16) + (this.viewFrame.getWidth()
        // / 16),
        // -(player.getY() * 16) + ((this.viewFrame.getHeight()) / 16));

        System.out.println((-(playerX * 16) + (((int) width / 16) * 2)));

        //
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

        System.out.print("Position joueurX : " + playerX + " ");
        System.out.print("Position joueurY : " + playerY + " ");
        System.out.println("Position du zoom : " + (-(playerX * 16) + (16 * 7)));

        // if (player.getX() > (-(player.getX() * 16) + (16 * 7))) {

        // }

        // if ((((player.getX() % 16) <= 5) && ((player.getX() % 16) > 0))
        // || (((player.getX() % 16) <= -5) && ((player.getX() % 16) < 0))) {
        // graphics.translate(-(player.getX() * 16) + (16 * 7), -(player.getY()
        // * 16) + (16 * 7));
        // }
        // this.viewFrame.getModel().getPlayableMap().getWidth()
        // if (start == true){
        // graphics.drawImage(img, x, y, null)
        //
        // }
        if (player.isAlive()) {

            graphics.translate(((-(playerX * 16) + (((int) width / 16) * 2))),
                    -(playerY * 16) + ((((int) height / 16) * 2)));
            for (int i = 0; i < this.viewFrame.getModel().getPlayableMap().getWidth(); i++) {
                for (int j = 0; j < this.viewFrame.getModel().getPlayableMap().getWidth(); j++) {

                    // final ImageProducer filteredImgProd = new
                    // FilteredImageSource(this.getViewFrame().getModel()
                    // .getPlayableMap().getXYElement(i,
                    // j).getSprite().getImage().getSource(), filter);
                    // final Image transparentImg =
                    // Toolkit.getDefaultToolkit().createImage(filteredImgProd);

                    graphics.drawImage(
                            this.getViewFrame().getModel().getPlayableMap().getXYElement(i, j).getSprite().getImage(),
                            i * 16, j * 16, null);
                }
            }
        } else {

            JDialog.setDefaultLookAndFeelDecorated(true);
            final int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "You died",
                    JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if (response == JOptionPane.NO_OPTION) {
                System.exit(0);
            } else if (response == JOptionPane.YES_OPTION) {
                try {
                    this.viewFrame.restart(this.viewFrame.getModel().getPlayableMap().getId());
                } catch (final SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("It works");
                // this.viewFrame.action(evt, what);
                // player.setAlive(true);
                // this.setNewGame(true);
                // new Game().start();
            } else if (response == JOptionPane.CLOSED_OPTION) {
                System.exit(0);
            }
            // this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // JOptionPane.showMessageDialog(this.getViewFrame(), "You died ! ",
            // "Try again !", JOptionPane.ERROR_MESSAGE);
            // super.paintComponent(graphics);
        }

        if (this.getViewFrame().getModel().getPlayableMap().isWin().equals(true)) {
            this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JOptionPane.showMessageDialog(this.getViewFrame(), "Bravo ", "Vous avez gagné !",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

        // graphics.drawImage(this.getViewFrame().getModel().getPlayableMap().getXYElement(1,
        // 6).getSprite().getImage(), 0,
        // 0, null);
        // this.previousPosX = player.getX();
        // this.previousPosY = player.getY();

    }

    public void setNewGame(final boolean newGame) {
        this.newGame = newGame;
    }

    /**
     * Sets the view frame.
     *
     * @param viewFrame
     *            the new view frame
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
