package ua.stu.view;

import ua.stu.model.Wood;
import ua.stu.store.WoodDirectory;

import javax.swing.*;
import java.awt.event.*;

public class DlgWood extends JDialog implements IWoodDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textFieldId;
    private JTextField textFieldName;
    private JTextField textFieldDensity;
    private JLabel lblId;
    private JLabel lblName;
    private JLabel lblDensity;
    private JTextArea textArea1;
    private WoodDirectory woodDirectory;
    private Wood wood;

    public DlgWood() {
        setUiProperties();
        setEvents();
    }
    private void setUiProperties() {
        setContentPane(contentPane);
        setModal(true);
        setBounds(200, 200, 500, 300);
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
        int id = Integer.parseInt(textFieldId.getText());
        String name = textFieldName.getText();
        float density = Float.parseFloat(textFieldDensity.getText());
        woodDirectory.add(new Wood(id, name, density));
        textArea1.setText(woodDirectory.toString());
        dispose();
    }

    private void onCancel() {
        DlgWood.this.setVisible(false);
        dispose();
    }

    public static void main(String[] args) {
        DlgWood dialog = new DlgWood();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    @Override
    public Object getObject() {
        return wood;
    }

    @Override
    public void setWoodDirectory(WoodDirectory woodDirectory) {
        this.woodDirectory = woodDirectory;
        textArea1.setText(String.valueOf(woodDirectory));
    }

    @Override
    public String toString() {
        return "Wood";
    }
}
