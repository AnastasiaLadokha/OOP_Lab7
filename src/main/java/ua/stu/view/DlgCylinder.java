package ua.stu.view;

import ua.stu.model.Cylinder;
import ua.stu.model.Wood;
import ua.stu.store.WoodDirectory;

import javax.swing.*;
import java.awt.event.*;

public class DlgCylinder extends JDialog implements IWoodDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldHeight;
    private JTextField textFieldRadius;
    private JLabel lblRadius;
    private JLabel lblHeight;
    private JLabel lblWood;
    private JComboBox comboBoxWood;
    private Cylinder cylinder;

    public DlgCylinder() {
        setUiProperties();
        setEvents();
    }

    private void setUiProperties(){
        setContentPane(contentPane);
        setModal(true);
        setBounds(200, 200, 400, 200);
        getRootPane().setDefaultButton(buttonOK);
    }

    private void setEvents(){
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        float height = Float.parseFloat(textFieldHeight.getText());
        float radius = Float.parseFloat(textFieldRadius.getText());
        Wood wood = (Wood) comboBoxWood.getSelectedItem();
        try {
            cylinder = new Cylinder(wood, height, radius);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Cylinder dialog error", JOptionPane.ERROR_MESSAGE);
        }
        DlgCylinder.this.setVisible(false);
        dispose();
    }

    private void onCancel() {
        cylinder = null;
        DlgCylinder.this.setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        DlgCylinder dialog = new DlgCylinder();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    @Override
    public Object getObject() {
        return cylinder;
    }

    @Override
    public void setWoodDirectory(WoodDirectory woodDirectory) {
        ComboBoxModel<Wood> model = new DefaultComboBoxModel<Wood>(woodDirectory.getArr());
        comboBoxWood.setModel(model);
    }

    @Override
    public String toString() {
        return "Cylinder";
    }
}
