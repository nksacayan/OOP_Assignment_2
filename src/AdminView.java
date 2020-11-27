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
    private JButton buttonValidate;
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
        buttonShowUserTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numUsers = admin.getNumUsers();
                JOptionPane.showMessageDialog(new JFrame(),
                        "There are " + numUsers + " users.");
            }
        });
        buttonShowGroupTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numUserGroups = admin.getNumUserGroups();
                JOptionPane.showMessageDialog(new JFrame(),
                        "There are " + numUserGroups + " user groups.");
            }
        });
        buttonShowMessagesTotal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numTweets = admin.countAllTweets();
                JOptionPane.showMessageDialog(new JFrame(),
                        "There are " + numTweets + " total tweets.");
            }
        });
        buttonShowPositivePercentage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double percentPositive = admin.countPositiveTweets();
                JOptionPane.showMessageDialog(new JFrame(),
                        "There are " + percentPositive + "% positive tweets.");
            }
        });
        buttonValidate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                if (admin.validateIDs()) {
                    message = "All IDs are valid.";
                }
                else {
                    message = "Not all IDs are valid.";
                }
                JOptionPane.showMessageDialog(new JFrame(), message);
            }
        });
    }

    public JTree getTreeView() {
        return treeView;
    }


}
