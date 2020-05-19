package ua.stu.model;

public class Waste implements IWeight {
    private float weight;

    public Waste(float weight) throws Exception {
        super();
        setWeight(weight);
    }

    public void setWeight(float weight) throws Exception {
        if (weight < 20 || weight > 100) {
            throw new Exception(weight + " isn't correct weight.\n"
                    + "Must be from 20 to 100 kg.");
        }
        this.weight = weight;
    }

    @Override
    public float weight() {
        return weight;
    }


    @Override
    public String toString() {
        return "Waste{" +
                "weight=" + weight +
                '}';
    }
}
