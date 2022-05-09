public class Rectangle implements Calculation {

    double a;
    double b;
    double height;
    double width;

    @Override
    public void setA(double a) {
        this.a = a;
    }

    @Override
    public void setB(double b) {
        this.b = b;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double getArea() {
        return a * b;
    }

    @Override
    public double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    public String getName() {
        return "téglalap";
    }

    @Override
    public String[] getSizeData() {
        return new String[]{"a oldal", "b oldal"};
    }

    @Override
    public void getInformation() {
        System.out.println("A téglalapot választottad. Itt a két oldal hosszát kell megadnod a következő formátumban:");
    }

    @Override
    public void showParameterInformation() {
        System.out.println("-----");
        System.out.println("Max. 3 számjegy lehet az egész része, valamint ugyanúgy 3 számjegy a tört része\n" +
                "majd szóköz és a mértékegység, ami csak 'mm', 'cm', 'dm' vagy 'm' lehet \n" +
                "pl. 101.325 m, 1 cm, 15,4 dm, stb.");
        System.out.println("-----");
    }

    @Override
    public boolean isParametersValid() {
        return true;
    }
}
