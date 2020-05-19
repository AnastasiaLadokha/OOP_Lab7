package ua.stu.model;

public abstract class AbstractForm implements IWeight {
    protected Wood wood;
    public abstract float volume();

    public AbstractForm(Wood wood) {
        this.wood = wood;
    }

    public Wood getWood() {
        return wood;
    }

    public float weight() {
        return wood.getDensity() * volume();
    }
}
