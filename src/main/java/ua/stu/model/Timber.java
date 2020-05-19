package ua.stu.model;

public class Timber extends AbstractForm {
    private float length;
    private float height;
    private float width;

    public Timber(Wood wood, float length, float height, float width) throws Exception {
        super(wood);
        setHeight(height);
        setLength(length);
        setWidth(width);
    }
    public void setLength(float length) throws Exception{
        if (length < 10 || length > 100){
            throw new Exception(length + " isn't correct length.\n"
            + "It must be from 10 to 100 cm.");
        }
        this.length = length;
    }
    public void setHeight(float height) throws Exception{
        if(height < 10 || height > 100){
            throw new Exception(height + " isn't correct height.\n"
                    + "It must be from 10 to 100 cm.");
        }
        this.height = height;
    }

    public void setWidth(float width) throws Exception{
        if(width < 10 || width > 100){
            throw new Exception(width + " isn't correct width.\n"
                    + "It must be from 10 to 100 cm.");
        }
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float volume() {
        return length * height * width;
    }

    @Override
    public String toString() {
        return "Timber{" +
                "wood=" + wood +
                ", weight=" + weight() +
                '}';
    }
}
