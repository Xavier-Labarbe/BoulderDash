package model.element;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import contract.ISprite;

public class Sprite implements ISprite {
    /** The image. */
    private Image image;

    /** The image name. */
    private String imageName;

    /** The console image. */
    private String consoleImage;

    /** The is image loaded. */
    private boolean imageLoaded;

    public Sprite(final String character, final String imageName) {
        this.setImageLoaded(false);
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }

    @Override
    public final String getConsoleImage() {
        return this.consoleImage;
    }

    @Override
    public final Image getImage() {
        return this.image;
    }

    @Override
    public final String getImageName() {
        return this.imageName;
    }

    @Override
    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }

    @Override
    public final void loadImage() throws IOException {
        System.out.println(this.getImageName());
        this.setImage(ImageIO.read(new File("images/" + this.getImageName())));

        this.setImageLoaded(true);
    }

    private void setConsoleImage(final String consoleImage) {
        this.consoleImage = consoleImage;
    }

    private void setImage(final Image image) {
        this.image = image;
    }

    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }

    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }
}
