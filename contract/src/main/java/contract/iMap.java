package contract;

public interface iMap {

    IElement[][] getElements();

    int getHeight();

    String getLabel();

    int getWidth();

    void setElements(IElement[][] elements);

}