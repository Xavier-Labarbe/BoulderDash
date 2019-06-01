package contract;

public interface IMap {

    IElement[][] getElements();

    int getHeight();

    String getLabel();

    int getWidth();

    void setElements(IElement[][] elements);

}