import java.util.Locale;

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
    public void changeUnit(String newUnit) {
        String oldUnit = this.unit;
        this.unit = newUnit;
        if (oldUnit.equals("mm")) {
            if (newUnit.equals("cm")){
                size = size/10;
            } else if (newUnit.equals("dm")) {
                size = size/100;
            } else if (newUnit.equals("m")) {
                size = size/1000;
            }
        } else if (oldUnit.equals("cm")) {
            if (newUnit.equals("mm")){
                size = size*10;
            } else if (newUnit.equals("dm")) {
                size = size/10;
            } else if (newUnit.equals("m")) {
                size = size/100;
            }
        } else if (oldUnit.equals("dm")) {
            if (newUnit.equals("mm")){
                size = size*100;
            } else if (newUnit.equals("cm")) {
                size = size*10;
            } else if (newUnit.equals("m")) {
                size = size/10;
            }
        } else if (oldUnit.equals("m")) {
            if (newUnit.equals("mm")){
                size = size*1000;
            } else if (newUnit.equals("cm")) {
                size = size*100;
            } else if (newUnit.equals("dm")) {
                size = size*10;
            }
        } else if (oldUnit.equals("mm2")) {
            if (newUnit.equals("cm2")){
                size = size/100;
            } else if (newUnit.equals("dm2")) {
                size = size/10_000;
            } else if (newUnit.equals("m2")) {
                size = size/1_000_000;
            }
        } else if (oldUnit.equals("cm2")) {
            if (newUnit.equals("mm2")){
                size = size*100;
            } else if (newUnit.equals("dm2")) {
                size = size/100;
            } else if (newUnit.equals("m2")) {
                size = size/10_000;
            }
        } else if (oldUnit.equals("dm2")) {
            if (newUnit.equals("mm2")){
                size = size*10_000;
            } else if (newUnit.equals("cm2")) {
                size = size*100;
            } else if (newUnit.equals("m2")) {
                size = size/100;
            }
        } else if (oldUnit.equals("m2")) {
            if (newUnit.equals("mm2")){
                size = size*1_000_000;
            } else if (newUnit.equals("cm2")) {
                size = size*10_000;
            } else if (newUnit.equals("dm2")) {
                size = size*100;
            }
        }
    }

    @Override
    public String toString() {
        return unit;
    }

}
