public class Deltoid extends Rectangle {

    @Override
    public double getArea() {
        return height*width/2;
    }

    @Override
    public String getName() {
        return "deltoid";
    }

    @Override
    public String[] getSizeData() {
        return new String[]{"a oldal", "b oldal", "magasság", "szélesség"};
    }

    @Override
    public void getInformation() {
        System.out.println("A deltoidot választottad. Itt a két oldalt és a két átlót kell (magasság, szélesség) \n" +
                "a következő formátumban megadnod:");
    }

    @Override
    public boolean isParametersValid() {
        if (a+b <= height) {
            System.out.println("A magasságnak kisebbnek kell lennie a két oldal összegénél.\n" +
                    "Kérlek add meg újra az adatokat!");
            return false;
        } else if (2*a <= width || 2*b <= width) {
            System.out.println("A szélességnek kisebbnek kell lennie a kisebb oldal kétszeresénél.\n" +
                    "Kérlek add meg újra az adatokat!");
            return false;
        } else {
            return true;
        }
    }

}
