package ua.stu.view;

import ua.stu.model.Timber;
import ua.stu.model.Wood;
import ua.stu.store.WoodDirectory;

import javax.swing.*;
import java.awt.event.*;

public class DlgTimber extends JDialog implements IWoodDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JLabel lblLength;
    private JTextField textFieldLength;
    private JTextField textFieldWidth;
    private JLabel lblWidth;
    private JTextField textFieldHeight;
    private JLabel lblHeight;
    private JLabel lblWood;
    private JComboBox<Wood> comboBoxWood;
    private Timber timber;

    public DlgTimber() {
        setUiProperties();
        setEvents();
    }

    private void setUiProperties(){
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setBounds(200, 200, 700, 300);
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

    public static void main(String[] args) {
        DlgTimber dialog = new DlgTimber();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void onOK() {
        float length = Float.parseFloat(textFieldLength.getText());
        float height = Float.parseFloat(textFieldHeight.getText());
        float width = Float.parseFloat(textFieldWidth.getText());
        Wood wood = (Wood) comboBoxWood.getSelectedItem();
        try {
            timber = new Timber(wood, length, height, width);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),
                    "Timber dialog error", JOptionPane.ERROR_MESSAGE);
        }
        DlgTimber.this.setVisible(false);
        dispose();
    }

    private void onCancel() {
        timber = null;
        DlgTimber.this.setVisible(false);
        dispose();
    }

    @Override
    public Object getObject() {
        return timber;
    }

    @Override
    public void setWoodDirectory(WoodDirectory woodDirectory) {
        ComboBoxModel<Wood> model = new DefaultComboBoxModel<Wood>(woodDirectory.getArr());
        comboBoxWood.setModel(model);
    }

    @Override
    public String toString() {
        return "Timber";
    }
}
