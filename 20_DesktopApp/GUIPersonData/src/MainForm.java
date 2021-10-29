import javax.swing.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JButton collapseButton;
    private JTextField lastNameField;
    private JTextField nameField;
    private JTextField middleNameField;
    private JTextField lastNameTextField;
    private JTextField nameTextField;
    private JTextField middleNameTextField;

    public MainForm() {
        lastNameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        nameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        middleNameTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        collapseButton.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

                String lastName = lastNameField.getText();
                String name = nameField.getText();
                String middleName = middleNameField.getText();

                if (!lastName.isEmpty() && !name.isEmpty()) {
                    JOptionPane.showOptionDialog(
                            mainPanel,
                            lastName + " " + name + " " + middleName,
                            "Correct Input!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            new String[]{"Expand"},
                            "default"
                    );
                } else {
                    JOptionPane.showMessageDialog(
                            mainPanel,
                            "You have entered incorrect data!\nTry it again!",
                            "Incorrect Input!",
                            JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}