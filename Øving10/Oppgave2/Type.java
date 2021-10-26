import java.util.ArrayList;
import java.util.List;

public class Type {
    public static String[] type = {"Forrett", "Hovedrett", "Dessert"};

    int typeId;
    public Type(int typeId) {
        this.typeId = typeId;
    }

    public static String[] getTyper() {
        return type;
    }

    public String getType() {
        return type[this.typeId];
    }

}