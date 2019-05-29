package entity;

public class FillingMap extends Entity {

    private int x;
    private int y;

    private ElementType elementType;

    public FillingMap(final ElementType elementType, final int x, final int y) {
        this.setElementType(elementType);
        this.setX(x);
        this.setY(y);
    }

    public String getElementChar() {
        return this.elementType.getElementChar();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setElementType(final ElementType elementType) {
        this.elementType = elementType;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

}
