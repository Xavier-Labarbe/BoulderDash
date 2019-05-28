package entity;

public class ElementType extends Entity{

	private String label;

	public ElementType(final String label) {
		setLabel(label);

	}

	public String getLabel() {
		return label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}
}
