package ua.stu.view;

import ua.stu.event.IProductListener;
import ua.stu.event.ProductEvent;
import ua.stu.file.OpenAndSave;
import ua.stu.file.fileLog;
import ua.stu.model.IWeight;
import ua.stu.store.ProductStore;
import ua.stu.store.WoodDirectory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MainGui {
    private JPanel MainPanel;
    private JList list1;
    private JTextArea textArea1;
    public JFrame frame;

    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu =new JMenu("File");
    private JMenuItem menuItem_save = new JMenuItem("Save");
    private JMenuItem menuItem_open = new JMenuItem("Open");
    private JMenu menu_event = new JMenu("Event");
    private JMenuItem menuItem_addl = new JMenuItem("Add listener");
    private JMenuItem menuItem_rem = new JMenuItem("Remove listener");
    private JMenuItem menuItem_log = new JMenuItem("Log");

    private WoodDirectory woodDirectory = new WoodDirectory();
    private ProductStore productStore = new ProductStore();
    private DlgTimber dlgTimber = new DlgTimber();
    private DlgWood dlgWood = new DlgWood();
    private DlgWaste dlgWaste = new DlgWaste();
    private DlgCylinder dlgCylinder = new DlgCylinder();

    public MainGui() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(MainPanel);
        frame.setTitle("Laboratory work №7");
        menuBar.add(menu);
        menuBar.add(menu_event);
        menu.add(menuItem_open);
        menu.add(menuItem_save);
        menu_event.add(menuItem_addl);
        menu_event.add(menuItem_rem);
        menu_event.add(menuItem_log);
        frame.setJMenuBar(menuBar);

        DefaultListModel<IWoodDialog> model = new DefaultListModel<>();
        model.addElement(dlgTimber);
        model.addElement(dlgCylinder);
        model.addElement(dlgWaste);
        model.addElement(dlgWood);
        list1.setModel(model);

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Log.txt", false));
        } catch (IOException e) {
            e.printStackTrace();
        }

        IProductListener productListener = new IProductListener() {
            @Override
            public void onProductEvent(ProductEvent event) {
                System.err.println(event);
                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Log.txt", true));
                    bufferedWriter.write(event.toString());
                    bufferedWriter.newLine();
                    bufferedWriter.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        };

        menuItem_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    OpenAndSave.save(woodDirectory, productStore);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "File save error", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        menuItem_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Object[] obj = OpenAndSave.open();
                    if(obj != null){
                        woodDirectory = (WoodDirectory) obj[0];
                        productStore = (ProductStore) obj[1];
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "File open error", "Error", JOptionPane.ERROR_MESSAGE);
                    woodDirectory = new WoodDirectory();
                    productStore = new ProductStore();
                }
                textArea1.setText(productStore.toString());
            }

        });

        menuItem_addl.addActionListener(e -> productStore.addProductListener(productListener));

        menuItem_rem.addActionListener(e -> productStore.removeProductListener(productListener));

        menuItem_log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, fileLog.readLog(), "Log", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        productStore.addProductListener(new IProductListener() {
            @Override
            public void onProductEvent(ProductEvent event) {
                fileLog.writeLog(event.toString());
            }
        });

        list1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                IWoodDialog dialog = (IWoodDialog) list1.getSelectedValue();
                dialog.setWoodDirectory(woodDirectory);
                dialog.setVisible(true);
                Object object = dialog.getObject();
                if (object != null)
                    productStore.add((IWeight) object);
                textArea1.setText(productStore.toString());
            }
        });
    }


}
