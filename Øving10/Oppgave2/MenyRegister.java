import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenyRegister {
    List<Meny> menyRegister = new ArrayList<>();
    List<Matrett> matRegister = new ArrayList<>();

    public void registrerMatrett(String navn, int type, float pris) {
        matRegister.add(new Matrett(navn, type, pris));
    }

    public Matrett finnMatrettEtterNavn(String navn) {
        for (Matrett target : matRegister) {
            if (Objects.equals(target.getNavn(), navn)) {
                return target;
            }
        }
        return null;
    }

    public List<Matrett> finnMatrettEtterType(String type) {
        List<Matrett> targets = new ArrayList<>();
        for (Matrett target : matRegister) {
            if (Objects.equals(target.getType(), type)) {
                targets.add(target);
            }
        }
        return targets;
    }

    public void registrerMeny(ArrayList<Matrett> matretter) {
        Meny meny = new Meny();
        for (Matrett matrett : matretter) {
            meny.setMeny(matrett);
        }

        menyRegister.add(meny);
    }

    public ArrayList<Meny> finnMenyEtterPris( int min, int max) {
        ArrayList<Meny> targets = new ArrayList<>();
        for (Meny meny : menyRegister) {
            float totalpris = meny.getTotalPris();
            if (totalpris < max || totalpris > min) {
                targets.add(meny);
            }
        }
        return targets;
    }
}
