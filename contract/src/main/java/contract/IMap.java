package contract;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMap.
 */
public interface IMap {

    /**
     * Gets the elements.
     *
     * @return the elements
     */
    IElement[][] getElements();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets the label.
     *
     * @return the label
     */
    String getLabel();

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Sets the elements.
     *
     * @param elements the new elements
     */
    void setElements(IElement[][] elements);

}