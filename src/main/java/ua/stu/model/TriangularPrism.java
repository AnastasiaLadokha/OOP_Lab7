package ua.stu.model;

public class TriangularPrism extends AbstractForm {
    private float height;
    private float length;

    public TriangularPrism(Wood wood, float height, float length) {
        super(wood);
        this.height = height;
        this.length = length;
    }

    public float getHeight() {
        return height;
    }

    public float getLength() {
        return length;
    }

    @Override
    public float volume() {
        return (float) ((Math.sqrt(3)/4)* Math.pow(length, 2)*height);
    }

    @Override
    public String toString() {
        return "TriangularPrism{" +
                "volume=" + volume() +
                '}';
    }
}
