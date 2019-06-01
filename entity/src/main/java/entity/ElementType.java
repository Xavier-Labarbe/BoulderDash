
package entity;

public class ElementType extends Entity {

    private String elementChar;

    public ElementType(final String elementChar) {
        this.setElementChar(elementChar);

    }

    public String getElementChar() {
        return this.elementChar;
    }

    public void setElementChar(final String elementChar) {
        this.elementChar = elementChar;
    }
}
