import java.util.ArrayList;
import java.util.List;

public class Meny {
    List<Matrett> matretter = new ArrayList<>();

    public void setMeny(Matrett matrett) {
        matretter.add(matrett);
    }

    public Matrett getMeny(int id) {
        return matretter.get(id);
    }

    public int getLength() {
        return matretter.size();
    }

    public float getTotalPris() {
        float sum = 0;
        for (int i = 0; i < matretter.size(); i++) {
            sum += matretter.get(i).getPris();
        }
        return sum;
    }



}