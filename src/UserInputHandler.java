import java.util.Scanner;

public class UserInputHandler {

    public final Scanner scanner;
    private int chosenNumber;

    public UserInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

//    visszaadja a kiválasztott menüpont számát
    public int getMenuChosenNumber() {
        System.out.println();
        System.out.println("Kérlek válassz egyet a fenti felsorolásból!");
        System.out.println("1 - Négyzet\n" +
                "2 - Téglalap\n" +
                "3 - Paralelogramma\n" +
                "4 - Rombusz\n" +
                "5 - Deltoid\n" +
                "0 - Kilépés");
        String userInput = "";
        boolean correctUserData;
        do {
            userInput = scanner.nextLine();
            correctUserData = validateUserInputInMenu(userInput, 0, 5);
        } while (correctUserData == false);
        return this.chosenNumber;
    }

//    visszaadja a kiválasztott forma egy példányát
    public Calculation getChosenForm(int userInput) {
        switch (userInput) {
            case 1:
               return new Square();
            case 2:
                return new Rectangle();
            case 3:
                return new Paralelogram();
            case 4:
                return new Rhombus();
            case 5:
                return new Deltoid();
            default:
                return null;
        }
    }

//    ez viszi be a paramétereket a kiválasztott forma példányába
    public void addShapeData(Calculation shape) {
        String[] sizeData = shape.getSizeData();
//        a külső do while addig fut, amíg a beírt adatok érvényesek lesznek az adott formára vonatkozóan
//        pl. bizonyos oldalak nem lehetnek hosszabbak, mint az átló vagy magasság, stb.
        do {
//            végigmegy az összes paraméteren és beírja a bekért adatokat a megfelelő helyre
            for (int i = 0; i < sizeData.length; i++) {
                System.out.print(sizeData[i] + " mérete: ");
                String userInput = "";
                boolean correctUserData = false;
                do {
                    userInput = scanner.nextLine();
                    correctUserData = validateUserInputSize(userInput);
                } while (correctUserData == false);
                String [] sizes = extractSizeAndUnit(userInput);
                Parameter parameter = new Parameter(Double.parseDouble(sizes[0].replace(",", ".")), sizes[1]);
//                átváltja a megadott adatot méterbe
                parameter.changeUnit("m");
                if (sizeData[i].equals("a oldal")) {
                    shape.setA(parameter.getSize());
                } else if (sizeData[i].equals("b oldal")) {
                    shape.setB(parameter.getSize());
                } else if (sizeData[i].equals("magasság")) {
                    shape.setHeight(parameter.getSize());
                } else {
                    shape.setWidth(parameter.getSize());
                }
            }
        } while (!shape.isParametersValid());
    }

//    itt vizsgálja meg, hogy a főmenüben érvényes szám van-e megadva
    private boolean validateUserInputInMenu(String userInput, int min, int max) {
        try {
            this.chosenNumber = Integer.parseInt(userInput);
            if (this.chosenNumber < min || this.chosenNumber > max) {
                System.out.println("Rossz számot adtál meg. Kérlek válassz 1-től 5-ig!");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Nem számot adtál meg. Kérlek válassz 1-től 5-ig!");
            return false;
        }
        return true;
    }

//    validálja a beírt paramétert, az elfogadott formátum 123.456 m
    private boolean validateUserInputSize(String userInput) {
        boolean isValid = userInput.matches("^[1-9] [mcd]?m$||^[1-9]\\d [mcd]?m$||^[1-9]\\d\\d [mcd]?m$||^\\d[,\\.]\\d{1,3} [mcd]?m$||[0]^[1-9]\\d[,\\.]\\d{1,3} [mcd]?m$||^[1-9]\\d\\d[,\\.]\\d{1,3} [mcd]?m$||");
        if (!isValid) {
            System.out.println("Nem jó formátumot adtál meg. Kérlek próbáld meg újra!");
            return false;
        } else {
            return true;
        }
    }

//    szétbontja a beírt paramétert számra és mértékegységre
    private String[] extractSizeAndUnit(String userInput) {
        return userInput.split(" ");
    }

//    kiírja a terület és kerület adatokat
    public void printAreaAndPerimeter(Calculation shape, Parameter area, Parameter perimeter) {
        System.out.println("------------------------------------------------------");
        System.out.println("A " + shape.getName() + " területe " + String.format("%.3f", area.getSize()) + " " + area.getUnit());
        System.out.println("A " + shape.getName() + " kerülete " + String.format("%.3f", perimeter.getSize()) + " " + perimeter.getUnit());
        System.out.println("------------------------------------------------------");
    }

//    visszaadja a mértékegységnél kiválasztott számot
    public int getDifferentUnitChosenNumber() {
        System.out.println();
        System.out.println("Milyen más mértékegységben szeretnéd még látni az eredményt?");
        System.out.println("1 - mm/mm2\n" +
                "2 - cm/cm2\n" +
                "3 - dm/dm2\n" +
                "4 - m/m2\n" +
                "0 - nem szeretnék más mértékegységet");
        String userInput = "";
        boolean correctUserData;
        do {
            userInput = scanner.nextLine();
            correctUserData = validateUserInputInMenu(userInput, 0, 4);
        } while (correctUserData == false);
        return this.chosenNumber;
    }

}
