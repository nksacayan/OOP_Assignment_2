import javax.swing.*;
import java.awt.*;

public class AdminControlPanel extends JFrame {
    // WYSIWYG generated code
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

    // Singleton code
    private static AdminControlPanel instance;

    private AdminControlPanel() throws HeadlessException {
        add(contentPanel);
        setTitle("Admin Control Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static AdminControlPanel getInstance() {
        if (instance == null) {
            synchronized (AdminControlPanel.class) {
                if (instance == null) {
                    instance = new AdminControlPanel();
                }
            }
        }
        return instance;
    }

    // Admin control panel functions
    // TODO: Output total number of users
    // TODO: Output total number of groups
    // TODO: output the total number of Tweet messages in all the users’ news feed
    // TODO: output the percentage of the positive
    //  Tweet messages in all the users’ news feed (the message containing positive words,
    //  such as good, great, excellent, etc.) Free free to decide the positive words.

}
