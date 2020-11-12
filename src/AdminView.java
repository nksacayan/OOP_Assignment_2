import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminView extends JFrame {
    private JPanel contentPanel;
    private Admin admin;
    private JTree treeView;
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
    private JScrollPane treeScrollPane;
    private DefaultMutableTreeNode selectedNode;
    private ArrayList<UserView> userViews = new ArrayList<>();

    public AdminView(Admin admin) throws HeadlessException {
        add(contentPanel);
        setTitle("Admin Control Panel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        this.admin = admin;

        buttonAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedNode != null && selectedNode.getAllowsChildren()) {
                    admin.addUser(textFieldUserID.getText(), selectedNode);
                } else {
                    admin.addUser(textFieldUserID.getText());
                }
                textFieldUserID.setText("");
            }
        });
        buttonAddGroup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedNode != null && selectedNode.getAllowsChildren()) {
                    admin.addUserGroup(textFieldGroupID.getText(), selectedNode);
                } else {
                    admin.addUserGroup(textFieldGroupID.getText());
                }
                textFieldGroupID.setText("");
            }
        });
        treeView.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                selectedNode = (DefaultMutableTreeNode) treeView.getLastSelectedPathComponent();
            }
        });
        buttonOpenUserView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedNode != null && !selectedNode.getAllowsChildren()) {
                    UserView userView = new UserView((User) selectedNode);
                }
            }
        });
    }

    public JTree getTreeView() {
        return treeView;
    }

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
