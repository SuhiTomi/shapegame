import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            new Main().run(scanner);
        }
    }

    public void run(Scanner scanner) {
        System.out.println("Üdvözöllek ebben a síkgeometriai terület és kerület számoló programban.");
        UserInputHandler uih = new UserInputHandler(scanner);
        int userInput;
        while (true) {
//        főmenüben az alakzat számának a bekérése
            userInput = uih.getMenuChosenNumber();
//        addig fut a program, amíg a kilépés (0) gombbal be nem fejezzük
            if (userInput == 0) {
                System.out.println("A program kilép. Köszönöm, hogy használtál. Várlak vissza.");
                break;
            }
//        a kiválasztott alakzat objektumba helyezése
            Calculation shape = uih.getChosenForm(userInput);
//        a kiválasztott adatokról információ
            shape.getInformation();
//        kiírja a paraméterek bevitelére vonatkozó általános információkat
            shape.showParameterInformation();
//        megadjuk a szükséges paramétereket a formához
            uih.addShapeData(shape);
//        felvisszük a kiszámolt adatot Unit formátumban
            Unit area = new Unit(shape.getArea(), "m2");
            Unit perimeter = new Unit(shape.getPerimeter(), "m");
//        kiíratjuk a terület és kerület adatokat
            uih.printAreaAndPerimeter(shape, area, perimeter);
//        megkérdezzük a felhasználót, hogy szeretné-e másik mértékegységben látni az adatokat
            while (true) {
                userInput = uih.getDifferentUnitChosenNumber();
                if (userInput == 0) {
                    break;
                }
                switch (userInput) {
                    case 1:
                        area.changeUnit("mm2");
                        perimeter.changeUnit("mm");
                        break;
                    case 2:
                        area.changeUnit("cm2");
                        perimeter.changeUnit("cm");
                        break;
                    case 3:
                        area.changeUnit("dm2");
                        perimeter.changeUnit("dm");
                        break;
                    case 4:
                        area.changeUnit("m2");
                        perimeter.changeUnit("m");
                        break;
                }
                uih.printAreaAndPerimeter(shape, area, perimeter);
            }
        }
    }

}

//    Feladat specifikációja:
//
//        Írj Java konzolos programot, ami a következő szempontokat teljesíti:
//        A program indulás után jelenítsen meg egy üdvözlő üzenetet!
//        Az üdvözlő üzenet alatt jelenítsen meg egy menüt, ahol a menüpontok 1-től sorfolytonosan vannak megszámozva!
//        Kérje be a program a felhasználótól a választott menüpont sorszámát!
//        Ha helytelen bemenetet ad meg a felhasználó, akkor kezeld le ezt a kivételes helyzetet és jeleníts meg egy felhasználóbarát üzenetet majd kérd be a számot újra!
//
//        A következő menüpontok legyenek legalább elérhetők:
//        - négyzet
//        - téglalap
//        - parallelogramma
//        - rombusz
//        - deltoid
//
//        Ezeken kívül legyen még egy utolsó menüpont, a kilépés!
//        Ezt választva a program jelenítsen meg egy búcsú üzenetet és álljon le!
//        Ha a felhasználó az egyik alakzatot választja, akkor kérd be az ahhoz az alakzathoz tartozó bemeneti adatokat.
//        Például négyzet esetén az egyetlen oldalhosszúságot, téglalap esetén a két oldalhosszúságot!
//        Ezek a bemeneti adatok nem csak egy számértéket tartalmaznak, hanem egy mértékegységet is.
//        Például 3 cm vagy 4,5 dm, vagy 100 m.
//        A különböző bemeneti adatok különböző mértékegységekben lehetnek megadva.
//        Ezek után a program számolja ki az adott alakzathoz tartozó kerületet és területet.
//        Ezeknek az eredményeknek az értékét írja ki először SI mértékegységben, majd opcionálisan más mértékegységekben is!
//        A számítás és az eredmény megjelenítése után a program térjen vissza a menübe, azt újra írja ki, majd a felhasználó újra választhasson egy alakzatot!
//
//        A megoldásod során törekedj alkalmazni minden olyan programozási eszközt, amiről eddig tanultunk!
//        Különösen ügyelj az OOP elvek követésére, alkalmazd az OOP-s elveket, használd az ehhez tartozó nyelvi lehetőségeket. Figyelj oda a változók, típusok elnevezésére, tömör, de beszédes angol azonosítókat válassz! Kövesd a Java elnevezési és formázási konvencióit! Alkalmazz kivételkezelést, ahol indokolt!
//
//        A megoldásaitokat várom 2022 májusában, kérlek, hogy e-mailben küldjétek el nekünk az info@ak-akademia.hu címünkre ZIP mellékletként!
//
//        A legszebb megoldást az első júniusi részben bemutatom és kiegészítem a saját észrevételeimmel. Ha hozzájárulsz a neved megemlítéséhez ebben a részben, akkor kérlek, küldd el ezt is nekünk a megoldásoddal együtt. Ha ezt nem szeretnéd, akkor egy kitalált becenév is megteszi. ;-)
//
//        Jó programozást kívánok a feladathoz! :-)