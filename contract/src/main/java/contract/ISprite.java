package contract;

import java.awt.Image;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Interface ISprite.
 */
public interface ISprite {

    /**
     * Gets the console image.
     *
     * @return the console image
     */
    String getConsoleImage();

    /**
     * Gets the image.
     *
     * @return the image
     */
    Image getImage();

    /**
     * Gets the image name.
     *
     * @return the image name
     */
    String getImageName();

    /**
     * Checks if is image loaded.
     *
     * @return true, if is image loaded
     */
    boolean isImageLoaded();

    /**
     * Load image.
     *
     * @throws IOException Signals that an I/O exception has occurred.
     */
    void loadImage() throws IOException;

}