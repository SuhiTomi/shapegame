public interface Calculation {

    void setA(double a);
    void setB(double b);
    void setHeight(double height);
    void setWidth(double width);
    double getArea();
    double getPerimeter();
//    visszaadja a forma nevét pl. négyzet, deltoid, stb.
    String getName();
//    visszaadja, hogy az adott formának milyen paramétereket kell megadni pl. a oldal, b oldal, magasság, stb.
    String[] getSizeData();
//    kiírja a formára vonatkozó információkat
    void getInformation();
//    kiírja a beviteli paraméterre vonatkozó általános információkat
    void showParameterInformation();
//    ellenőrzi, hogy a megadott paraméterekkel az adott forma megvalósítható-e
    boolean isParametersValid();

}
