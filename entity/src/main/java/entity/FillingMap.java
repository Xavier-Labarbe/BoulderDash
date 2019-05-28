package entity;

public class FillingMap extends Entity{

	private int x;
	private int y;

	private ElementType elementType;

	public FillingMap(final ElementType elementType, final int x, final int y) {
		setElementType(elementType);
		setX(x);
		setY(y);
	}

	public String getElementLabel() {
		return elementType.getLabel();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
