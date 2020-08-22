package util;

public class ElementPair {

    int firstElement;
    int secondElement;

    public ElementPair(int firstElement, int secondElement) {
        this.firstElement = firstElement;
        this.secondElement = secondElement;
    }

    public int getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(int firstElement) {
        this.firstElement = firstElement;
    }

    public int getSecondElement() {
        return secondElement;
    }

    public void setSecondElement(int secondElement) {
        this.secondElement = secondElement;
    }

    public ElementPair getPair() {
        return new ElementPair(firstElement, secondElement);
    }
}
