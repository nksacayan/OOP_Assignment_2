import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.Enumeration;
import java.util.HashSet;

public class Admin {
    // Singleton implementation
    private static Admin instance;
    private HashSet<String> userIDHashSet = new HashSet<>();
    private HashSet<String> userGroupIDHashSet = new HashSet<>();
    private DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
    private DefaultTreeModel treeModel;

    private Admin() {
        treeModel = new DefaultTreeModel(rootNode, true);
        AdminView adminView = new AdminView(this);
        adminView.getTreeView().setModel(treeModel);
    }

    public static Admin getInstance() {
        if (instance == null) {
            synchronized (AdminView.class) {
                if (instance == null) {
                    instance = new Admin();
                }
            }
        }
        return instance;
    }

    // Methods
    public void addUser(String userID) {
        if (userIDHashSet.contains(userID)) {
            throw new RuntimeException("UserID already exists");
        }
        userIDHashSet.add(userID);
        treeModel.insertNodeInto(new User(userID, this), rootNode, rootNode.getChildCount());
    }

    public void addUser(String userID, DefaultMutableTreeNode parentNode) {
        if (userIDHashSet.contains(userID)) {
            throw new RuntimeException("UserID already exists");
        }
        userIDHashSet.add(userID);
        treeModel.insertNodeInto(new User(userID, this), parentNode, parentNode.getChildCount());
    }

    public void addUserGroup(String userGroupID) {
        if (userGroupIDHashSet.contains(userGroupID)) {
            throw new RuntimeException("UserGroupID already exists");
        }
        userGroupIDHashSet.add(userGroupID);
        treeModel.insertNodeInto(new UserGroup(userGroupID), rootNode, rootNode.getChildCount());
    }

    public void addUserGroup(String userGroupID, DefaultMutableTreeNode parentNode) {
        if (userGroupIDHashSet.contains(userGroupID)) {
            throw new RuntimeException("UserGroupID already exists");
        }
        userGroupIDHashSet.add(userGroupID);
        treeModel.insertNodeInto(new UserGroup(userGroupID), parentNode, parentNode.getChildCount());
    }

    public User findUser(String userID) {
        TreePath treePath = find(rootNode, userID);
        if (treePath == null) {
            return null;
        }
        User user = (User) treePath.getLastPathComponent();
        return user;
    }

    private TreePath find(DefaultMutableTreeNode root, String s) {
        Enumeration<TreeNode> e = root.depthFirstEnumeration();
        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            if (node.toString().equalsIgnoreCase(s)) {
                return new TreePath(node.getPath());
            }
        }
        return null;
    }

    public int getNumUsers() {
        return userIDHashSet.size();
    }

    public int getNumUserGroups() {
        return userGroupIDHashSet.size();
    }

    // TODO: get the total number of Tweet messages in all the users’ news feed
    // TODO: get the percentage of the positive
    //  Tweet messages in all the users’ news feed (the message containing positive words,
    //  such as good, great, excellent, etc.) Free free to decide the positive words.

}
