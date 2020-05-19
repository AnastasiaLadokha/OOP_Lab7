package ua.stu.view;


import ua.stu.store.WoodDirectory;

public interface IWoodDialog {
    public void setVisible(boolean b);
    public Object getObject();
    public void setWoodDirectory(WoodDirectory wd);
}
