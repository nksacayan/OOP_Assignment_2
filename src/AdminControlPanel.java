import javax.swing.*;

public class AdminControlPanel {
    private JPanel contentPanel;
    private JTree treeView;
    private JPanel treePanel;
    private JPanel buttonPanelTop;
    private JTextField textFieldUserID;
    private JButton buttonAddUser;
    private JTextField textFieldGroupID;
    private JButton buttonAddGroup;
    private JButton buttonOpenUserView;
    private JPanel buttonPanelBottom;
    private JButton buttonShowUserTotal;
    private JButton buttonShowMessagesTotal;
    private JButton buttonShowGroupTotal;
    private JButton buttonShowPositivePercentage;

    public static void main(String[] args) {
        JFrame frame = new JFrame("AdminControlPanel");
        frame.setContentPane(new AdminControlPanel().contentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
