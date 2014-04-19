package highfive.charactersheet.revisedthirdedition.ui;

import highfive.charactersheet.CharacterSheet;
import highfive.charactersheet.Section;
import highfive.charactersheet.revisedthirdedition.models.Inventory;
import highfive.charactersheet.revisedthirdedition.models.Item;
import highfive.charactersheet.revisedthirdedition.models.RevisedThirdEditionCharacterSheet;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class InventorySection extends Section {
    private final String key;
    private Inventory inventory;
    private JButton addItemButton;
    private JPanel itemsPanel;

    public InventorySection(String title, String key) {
        super(title);
        this.inventory = new Inventory();
        this.key = key;
        initializeWidgets();
        assembleWidgets();
    }

    private void initializeWidgets() {
        itemsPanel = new JPanel();
        addItemButton = new JButton("Add");
        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addItemDialog();
            }
        });
    }

    private void assembleWidgets() {
        add(itemsPanel);
        add(addItemButton);
    }

    private void addItemDialog() {
        JLabel nameLabel = new JLabel("Item name");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField nameField = new JTextField();
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel weightLabel = new JLabel("Item weight");
        weightLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JSpinner weightField = new JSpinner(new SpinnerNumberModel(0, 0, Double.MAX_VALUE, 0.1));
        weightField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(weightLabel);
        panel.add(weightField);

        boolean showAgain = true;
        do {
            int option = JOptionPane.showConfirmDialog(null, panel, "New Item", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                double weight = (Double) weightField.getValue();

                Item item = new Item();

                item.setName(name);
                item.setWeight(weight); // JSpinner guarantees a value

                if (inventory.contains(item)) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "That item is already in the inventory.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    inventory.add(item);
                    updateParent();
                    showAgain = false;
                }
            } else {
                showAgain = false;
            }
        } while (showAgain);
    }

    private void editItemDialog(Item item) {
        int quantity = inventory.getQuantity(item);
        inventory.removeAll(item);
        JLabel nameLabel = new JLabel("Item name");
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField nameField = new JTextField(item.getName());
        nameField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel weightLabel = new JLabel("Item weight");
        weightLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JSpinner weightField = new JSpinner(new SpinnerNumberModel(item.getWeight(), 0, Double.MAX_VALUE, 0.1));
        weightField.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(weightLabel);
        panel.add(weightField);

        boolean showAgain = true;
        do {
            int option = JOptionPane.showConfirmDialog(null, panel, "New Item", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String name = nameField.getText();
                double weight = (Double) weightField.getValue();

                Item newItem = new Item();

                newItem.setName(name);
                newItem.setWeight(weight); // JSpinner guarantees a value

                if (inventory.contains(newItem)) {
                    JOptionPane.showMessageDialog(this.getTopLevelAncestor(), "That item is already in the inventory.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    inventory.add(newItem);
                    updateParent();
                    showAgain = false;
                }
            } else {
                showAgain = false;
            }
        } while (showAgain);
    }

    private void removeItemDialog(Item item) {
        inventory.removeAll(item);
        updateParent();
    }

    private void rebuild() {
        itemsPanel.removeAll();
        itemsPanel.setLayout(new GridLayout(inventory.size() + 1, 6));
        itemsPanel.add(new JLabel("Name"));
        itemsPanel.add(new JLabel("Quantity"));
        itemsPanel.add(new JLabel("Unit Weight"));
        itemsPanel.add(new JLabel("Total Weight"));
        itemsPanel.add(new JLabel(""));
        itemsPanel.add(new JLabel(""));
        for (Map.Entry<Item, Integer> entry : inventory) {
            final Item item = entry.getKey();
            final int quantity = entry.getValue();

            JLabel itemNameLabel = new JLabel(item.getName());

            final JSpinner itemQuantityField = new JSpinner(new SpinnerNumberModel(quantity, 0, Integer.MAX_VALUE, 1));
            itemQuantityField.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent changeEvent) {
                    inventory.setQuantity(item, (Integer) itemQuantityField.getValue());
                    updateParent();
                }
            });

            double weight = item.getWeight();

            String unitWeight = String.format("%.2f", weight);
            JLabel unitWeightLabel = new JLabel(unitWeight);

            String totalWeight = String.format("%.2f", weight * quantity);
            JLabel totalWeightLabel = new JLabel(totalWeight);

            JButton editButton = new JButton("Edit");
            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    editItemDialog(item);
                }
            });

            JButton removeButton = new JButton("Remove");
            removeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    removeItemDialog(item);
                }
            });

            itemsPanel.add(itemNameLabel);
            itemsPanel.add(itemQuantityField);
            itemsPanel.add(unitWeightLabel);
            itemsPanel.add(totalWeightLabel);
            itemsPanel.add(editButton);
            itemsPanel.add(removeButton);
        }
    }



    @Override
    public CharacterSheet update(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        return update((RevisedThirdEditionCharacterSheet) characterSheet);
    }


    private RevisedThirdEditionCharacterSheet update(RevisedThirdEditionCharacterSheet characterSheet) {
        if (inventory != null) {
            characterSheet.setInventory(key, inventory);
        }
        load(characterSheet);
        return characterSheet;
    }

    @Override
    public void load(CharacterSheet characterSheet) {
        if (!characterSheet.getClass().equals(RevisedThirdEditionCharacterSheet.class)) {
            throw new ClassCastException();
        }
        load((RevisedThirdEditionCharacterSheet) characterSheet);
    }

    private void load(RevisedThirdEditionCharacterSheet characterSheet) {
        inventory = characterSheet.getInventory(key);
        rebuild();
    }

}
