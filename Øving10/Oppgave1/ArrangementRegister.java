import java.util.*;

public class ArrangementRegister {
    List<Arrangement> arrangementer = new ArrayList<>();
    List<String> typeListe = new ArrayList<>();

    public void leggTilArrangement(String navn, String sted, String arrangor, int type, long meta) {
        arrangementer.add(new Arrangement(navn, sted, arrangor, type, meta));
    }

    public String fjernArrangement(String navn) {

        for (int i = 0; i < arrangementer.size(); i++) {
            if (Objects.equals(arrangementer.get(i).navn, navn)) {
                arrangementer.remove(i);
                return "Arrangementet ble fjernet";
            }
        }
        return "Arrangementet finnes ikke";



    }

    public void setTypeListe(List<String> typeListe) {
        this.typeListe = typeListe;
    }

    public List<Arrangement> finnArrangementEtterSted(String target) {

        List<Arrangement> targets = new ArrayList<>();
        for (Arrangement search : this.arrangementer) {
            if (Objects.equals(search.getSted(), target)) {
                targets.add(search);
            }
        }
        return targets;
    }

    //Må legge til sortering av getMeta();
    public List<Arrangement> finnArrangementEtterDato(int dato) {

        List<Arrangement> targets = new ArrayList<>();
        for (Arrangement search : this.arrangementer) {
            if (search.getMeta() / 10000 == dato) {
                targets.add(search);
            }
        }

        return sortTime(targets);
    }

    public List<Arrangement> finnArrangementEtterInterval(int min, int max) {
        List<Arrangement> targets = new ArrayList<>();
        for (Arrangement search : this.arrangementer) {
            if (search.getMeta() / 10000 >= min && search.getMeta() / 10000 <= max) {
                targets.add(search);
            }
        }
        return sortTime(targets);
    }

    public List<Arrangement> sortTime(List<Arrangement> targets) {
        targets.sort((a, b) -> (int) (a.getMeta() - b.getMeta()));
        return targets;
    }

    public List<Arrangement> sortType(List<Arrangement> targets) {
        Comparator<Arrangement> sorterType = Comparator.comparingInt(Arrangement::getType);
        targets.sort(sorterType);
        return targets;
    }

    public List<Arrangement> sortSted(List<Arrangement> targets) {
        Comparator<Arrangement> sorterEtterSted = Comparator.comparing(Arrangement::getSted);
        targets.sort(sorterEtterSted);
        return targets;
    }


    public List<Arrangement> sort(List<Arrangement> targets) {
        Comparator<Arrangement> sorter = Comparator.comparing(Arrangement::getSted).thenComparing(Arrangement::getType).thenComparing(Arrangement::getMeta);
        targets.sort(sorter);
        return targets;

    }

    public boolean ifExists(String name) {
        for (Arrangement arrangement : arrangementer) {
            if (Objects.equals(arrangement.getNavn(), name)) {
                return true;
            }
        }
        return false;
    }

}
