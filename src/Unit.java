public class Unit {

    public double size;
    public String unit;

    public Unit(double size, String unit) {
        this.size = size;
        this.unit = unit;
    }

//    ez végzi az átváltást a mértékegységek között
    public double getSizeInMeter() {
        if (unit.equals("mm")) {
            return size/1000;
        } else if (unit.equals("cm")) {
            return size/100;
        } else if (unit.equals("dm")) {
            return size / 10;
        } else {
            return size;
        }
    }

    public double changeUnit(String unit) {
        if (unit.equals("mm")) {
            return size/1000;
        } else if (unit.equals("cm")) {
            return size/100;
        } else if (unit.equals("dm")) {
            return size / 10;
        } else {
            return size;
        }
    }

    @Override
    public String toString() {
        return unit;
    }

}
