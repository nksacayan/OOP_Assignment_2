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

    public AdminControlPanel() throws HeadlessException {
        add(contentPanel);
        setTitle("Admin Control Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    // TODO: Add users
    // TODO: Add userGroups
    // TODO: Update tree when users or groups are added
    // TODO: Output total number of users
    // TODO: Output total number of groups
    // TODO: output the total number of Tweet messages in all the users’ news feed
    // TODO: output the percentage of the positive
    //  Tweet messages in all the users’ news feed (the message containing positive words,
    //  such as good, great, excellent, etc.) Free free to decide the positive words.
    // Simple pop-up dialogue boxes are sufficient for outputs on buttons
    // The buttons use the visitor pattern
    // TODO: Select user in tree, then open user view with button

}
