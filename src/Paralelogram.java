public class Paralelogram extends Rectangle {

    @Override
    public double getArea() {
        return a * height;
    }

    @Override
    public String getName() {
        return "paralelogramma";
    }

    @Override
    public String[] getSizeData() {
        return new String[]{"a oldal", "b oldal", "magasság"};
    }

    @Override
    public void getInformation() {
        System.out.println("A paralelogrammát választottad. Itt az egyik oldal hosszát valamint a magasságot kell \n" +
                "a következő formátumban megadnod:");
    }

    @Override
    public boolean isParametersValid() {
        if (b < height) {
            System.out.println("A b oldalnak kisebbnek kell lennie, mint a magasságnak.\n" +
                    "Kérlek add meg újra az adatokat!");
            return false;
        } else {
            return true;
        }
    }
}
