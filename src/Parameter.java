import java.util.HashMap;
import java.util.Map;

public class Parameter {

    private double size;
    private String unit;
    private Map<String, Integer> converter = new HashMap();

    {
        converter.put("mm", 1_000);
        converter.put("cm", 100);
        converter.put("dm", 10);
        converter.put("m", 1);
        converter.put("mm2", 1_000_000);
        converter.put("cm2", 10_000);
        converter.put("dm2", 100);
        converter.put("m2", 1);
    }

    public Parameter(double size, String unit) {
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
        size = size / converter.get(oldUnit) * converter.get(newUnit);
    }

}
