package view;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class ViewFrame.
 *
 * @author Jean-Aymeric Diet
 */
class ViewFrame extends JFrame implements KeyListener {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -697358409737458175L;

    /** The controller. */
    private IController controller;
    /** The model. */
    private IModel model;

    private IView view;

    /**
     * Instantiates a new view frame.
     *
     * @param model the model
     * @param gc    the gc
     */
    public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
        super(gc);
        this.buildViewFrame(model);
    }

    /**
     * Instantiates a new view frame.
     *
     * @param model the model
     * @throws HeadlessException the headless exception
     */
    public ViewFrame(final IModel model, final IController controller) throws HeadlessException {
        this.buildViewFrame(model);
        this.controller = controller;
    }

    /**
     * Instantiates a new view frame.
     *
     * @param model the model
     * @param title the title
     * @throws HeadlessException the headless exception
     */
    public ViewFrame(final IModel model, final String title) throws HeadlessException {
        super(title);
        this.buildViewFrame(model);
    }

    /**
     * Instantiates a new view frame.
     *
     * @param model the model
     * @param title the title
     * @param gc    the gc
     */
    public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
        super(title, gc);
        this.buildViewFrame(model);
    }

    /**
     * Builds the view frame.
     *
     * @param model the model
     */
    private void buildViewFrame(final IModel model) {
        this.setModel(model);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setContentPane(new ViewPanel(this));
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    /**
     * Gets the controller.
     *
     * @return the controller
     */
    protected IController getController() {
        return this.controller;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    protected IModel getModel() {
        return this.model;
    }

    public IView getView() {
        return this.view;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
     */
    @Override
    public void keyPressed(final KeyEvent e) {
        this.getView().getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
    }

    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent e) {

    }

    /*
     * (non-Javadoc)
     *
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent e) {

    }

    /**
     * Prints the message.
     *
     * @param message the message
     */
    public void printMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /**
     * Sets the controller.
     *
     * @param controller the new controller
     */
    protected void setController(final IController controller) {
        this.controller = controller;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    protected void setModel(final IModel model) {
        this.model = model;
    }

    public void setView(final IView view) {
        this.view = view;
    }
}