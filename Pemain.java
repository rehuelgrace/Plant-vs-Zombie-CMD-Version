import java.util.ArrayList;

public class Pemain {
    private int sun = 200;
    private ArrayList<Plant> listPlants = new ArrayList<Plant>();
    private ArrayList<Pea> listPeas = new ArrayList<Pea>();

    public Pemain(Plant[] plant, Pea[] pea){
        getPlants();
        getPeas();
    }
    public Pemain (Pea[] pea){
        getPeas();
    }

    /**
     * Get the sun status
     */
    public int getSun(){
        return this.sun;
    }


    /**
     *Get the plants that the player owns
     */
    public ArrayList<Plant> getPlants(){
        return listPlants;
    }

    public ArrayList<Pea> getPeas(){
        return listPeas;
    }

    /**
     * set the sun status and the label
     */
    public void setSun(int sun){
        this.sun = sun;
    }

    /**
     * add the plant that the player bought
     */
    public void addPlants(Plant plant){
        listPlants.add(plant);
    }

    /**
     * add the peas which are weapons
     * param pea
     */
    public void addPea(Pea pea){
        listPeas.add(pea);
    }
    /**
     * remove the plant that the player bought
     */
    public void removePlant(Plant plant){
        listPlants.remove(plant);
    }
    /**
     * remove the plant that the player bought
     */
    public void removePea(Pea pea){
        listPlants.remove(pea);
    }
    public void removeSimbol(String s){ //masih ragu
        listPlants.remove(s);
    }
}
