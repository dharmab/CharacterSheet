package highfive.charactersheet;

import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;
import highfive.charactersheet.revisedthirdedition.ui.RevisedThirdEditionCharacterSheetView;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class MainWindow extends JFrame {
    private CharacterSheetView characterSheetView;
    private String filePath;
    private JScrollPane scrollPane;

    public MainWindow(String title) throws HeadlessException {
        super(title);
        setupMenuBar();
        newCharacterSheet();
        setupScrollPane();
    }

    private void setupScrollPane() {
        scrollPane = new JScrollPane(characterSheetView);
        add(scrollPane);
    }

    private void newCharacterSheet() {
        if (characterSheetView != null) {
            remove(characterSheetView);
        }
        characterSheetView = new RevisedThirdEditionCharacterSheetView();
        add(characterSheetView);
        characterSheetView.validate();
    }

    private void setupMenuBar() {
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newCharacterSheet();
            }
        });

        JMenuItem loadItem = new JMenuItem("Load");
        loadItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    load();
                } catch (FileNotFoundException e) {
                    // TODO show error message
                }
            }
        });

        JMenuItem saveItem = new JMenuItem("Save");
        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                save(filePath);
            }
        });
        JMenuItem saveAsItem = new JMenuItem("Save As");

        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                saveAs();
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        fileMenu.add(newItem);
        fileMenu.add(loadItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.add(exitItem);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }

    private void saveAs() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.getName().toLowerCase().endsWith("xml")) {
                    return true;
                }
                if (file.isDirectory()) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "XML Files";
            }
        });
        fileChooser.showSaveDialog(this);
        filePath = fileChooser.getSelectedFile().getAbsolutePath();
        save(filePath);
    }

    private void save(String path) {
        if (path == null) {
            saveAs();
        } else {
            FileOutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(path);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            XMLEncoder encoder = new XMLEncoder(outputStream);
            encoder.writeObject(characterSheetView.getCharacterSheet());
            encoder.close();
        }
    }

    private void load() throws FileNotFoundException {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                if (file.getName().toLowerCase().endsWith("xml")) {
                    return true;
                }
                if (file.isDirectory()) {
                    return true;
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "XML Files";
            }
        });
        fileChooser.showOpenDialog(this);
        filePath = fileChooser.getSelectedFile().toString();

        FileInputStream inputStream = new FileInputStream(filePath);
        XMLDecoder decoder = new XMLDecoder(inputStream);
        characterSheetView = new RevisedThirdEditionCharacterSheetView();
        characterSheetView.setCharacterSheet((RevisedThirdEditionCharacterSheet) decoder.readObject());
        characterSheetView.update();
        decoder.close();
    }

}