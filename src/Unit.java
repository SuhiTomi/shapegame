public class Unit {

    public double size;
    public String unit;

    public Unit(double size, String unit) {
        this.size = size;
        this.unit = unit;
    }

    public double getSize() {
        return size;
    }

    public String getUnit() {
        return unit;
    }

    //    ez végzi az átváltást a mértékegységek között
    public void setSizeInMeter() {
        if (unit.equals("mm")) {
            size = size/1000;
            unit = "m";
        } else if (unit.equals("cm")) {
            size = size/100;
            unit = "m";
        } else if (unit.equals("dm")) {
            size = size / 10;
            unit = "m";
        } else {
            unit = "m";
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
