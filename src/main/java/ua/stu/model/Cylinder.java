package ua.stu.model;

public class Cylinder extends AbstractForm {
    private float height;
    private float radius;

    @Override
    public float volume() {
        return (float)(height* Math.pow(radius, 2)* Math.PI);
    }

    public Cylinder(Wood wood, float height, float radius) throws Exception {
        super(wood);
        setHeight(height);
        setRadius(radius);
    }

    public void setHeight(float height) throws Exception{
        if(height < 5 || height > 80){
            throw new Exception(height + " isn't correct height.\n"
                    + "It must be from 5 to 80 cm.");
        }
        this.height = height;
    }

    public void setRadius(float radius) throws Exception{
        if(radius < 5 || radius > 80){
            throw new Exception(radius + " isn't correct height.\n"
                    + "It must be from 5 to 80 cm.");
        }
        this.radius = radius;
    }

    public float getHeight() {
        return height;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "volume=" + volume() +
                '}';
    }
}
