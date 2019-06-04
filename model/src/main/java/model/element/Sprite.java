package model.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.ISprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Sprite.
 */
public class Sprite implements ISprite {
    /** The image. */
    private Image image;

    /** The image name. */
    private String imageName;

    /** The console image. */
    private String consoleImage;

    /** The is image loaded. */
    private boolean imageLoaded;

    /**
     * Instantiates a new sprite.
     *
     * @param character the character
     * @param imageName the image name
     */
    public Sprite(final String character, final String imageName) {
        this.setImageLoaded(false);
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }

    /**
     * Gets the console image.
     *
     * @return the console image
     */
    @Override
    public final String getConsoleImage() {
        return this.consoleImage;
    }

    /**
     * Gets the image.
     *
     * @return the image
     */
    @Override
    public final Image getImage() {
        return this.image;
    }

    /**
     * Gets the image name.
     *
     * @return the image name
     */
    @Override
    public final String getImageName() {
        return this.imageName;
    }

    /**
     * Checks if is image loaded.
     *
     * @return true, if is image loaded
     */
    @Override
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    /**
     * Load image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    @Override
    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("images/" + this.getImageName())));

        this.setImageLoaded(true);
    }

    /**
     * Sets the console image.
     *
     * @param consoleImage the new console image
     */
    private void setConsoleImage(final String consoleImage) {
        this.consoleImage = consoleImage;
    }

    /**
     * Sets the image.
     *
     * @param image the new image
     */
    private void setImage(final Image image) {
        this.image = image;
    }

    /**
     * Sets the image loaded.
     *
     * @param isImageLoaded the new image loaded
     */
    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }

    /**
     * Sets the image name.
     *
     * @param imageName the new image name
     */
    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }
}
