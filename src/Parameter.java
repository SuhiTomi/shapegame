import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Parameter {

    public double size;
    public String unit;
    public Map<String, Double> converter = new HashMap();

    {
        converter.put("mm->mm", 1e0);
        converter.put("mm->cm", 1e-1);
        converter.put("mm->dm", 1e-2);
        converter.put("mm->m", 1e-3);
        converter.put("cm->mm", 1e1);
        converter.put("cm->cm", 1e0);
        converter.put("cm->dm", 1e-1);
        converter.put("cm->m", 1e-2);
        converter.put("dm->mm", 1e2);
        converter.put("dm->cm", 1e1);
        converter.put("dm->dm", 1e0);
        converter.put("dm->m", 1e-1);
        converter.put("m->mm", 1e3);
        converter.put("m->cm", 1e2);
        converter.put("m->dm", 1e1);
        converter.put("m->m", 1e0);

        converter.put("mm2->mm2", 1e0);
        converter.put("mm2->cm2", 1e-2);
        converter.put("mm2->dm2", 1e-4);
        converter.put("mm2->m2", 1e-6);
        converter.put("cm2->mm2", 1e2);
        converter.put("cm2->cm2", 1e0);
        converter.put("cm2->dm2", 1e-2);
        converter.put("cm2->m2", 1e-4);
        converter.put("dm2->mm2", 1e4);
        converter.put("dm2->cm2", 1e2);
        converter.put("dm2->dm2", 1e0);
        converter.put("dm2->m2", 1e-2);
        converter.put("m2->mm2", 1e6);
        converter.put("m2->cm2", 1e4);
        converter.put("m2->dm2", 1e2);
        converter.put("m2->m2", 1e0);
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
        double multiplier = converter.get(oldUnit + "->" + newUnit);
        size = size * multiplier;
    }

}
