public class Rhombus extends Deltoid {
    @Override
    public void setA(double a) {
        this.a = a;
        this.b = a;
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
        this.width = height;
    }

    @Override
    public String getName() {
        return "rombusz";
    }

    @Override
    public String[] getSizeData() {
        return new String[]{"a oldal", "magasság"};
    }

    @Override
    public void getInformation() {
        System.out.println("A rombuszt választottad. Itt egy oldalt és az átlót kell a következő formátumban megadnod:");
    }

}
