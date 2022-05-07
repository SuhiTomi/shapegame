public class Square extends Rectangle{

    @Override
    public void setA(double a) {
        this.a = a;
        this.b = a;
    }

    @Override
    public String getName() {
        return "négyzet";
    }

    @Override
    public String[] getSizeData() {
        return new String[]{"a oldal"};
    }

    @Override
    public void getInformation() {
        System.out.println("A négyzetet választottad. Itt egy oldal hosszát kell a következő formátumban megadnod, \n" +
                "mivel az oldalak egyforma hosszúak:");
    }

}
