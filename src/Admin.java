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
    private TweetCounterVisitor tweetCounterVisitor = new TweetCounterVisitor();
    private PositiveTweetVisitor positiveTweetVisitor = new PositiveTweetVisitor();

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
            if (node.toString().equals(s)) {
                return new TreePath(node.getPath());
            }
        }
        return null;
    }

    public int countAllTweets() {
        visitAllNodes(rootNode);
        int numTweets = tweetCounterVisitor.getNumTweets();
        tweetCounterVisitor.resetCount();
        return numTweets;
    }

    public double countPositiveTweets() {
        visitAllNodes(rootNode);
        double percentPositive = positiveTweetVisitor.calculatePercentage();
        positiveTweetVisitor.resetCount();
        return percentPositive;
    }

    private void visitAllNodes(TreeNode node) {
        if (node.getParent() != null) {
            Visitable visitable = (Visitable) node;
            visitable.accept(tweetCounterVisitor);
            visitable.accept(positiveTweetVisitor);
        }
        if (node.getChildCount() >= 0) {
            for (Enumeration e = node.children(); e.hasMoreElements();) {
                TreeNode n = (TreeNode) e.nextElement();
                visitAllNodes(n);
            }
        }
    }

    public boolean validateIDs() {
        for (String id : userIDHashSet) {
            // Test uniqueness of IDs between users and group sets
            if (userGroupIDHashSet.contains(id)) {
                return false;
            }
            // Test if any ID contains spaces
            if (id.contains(" ")) {
                return false;
            }
        }
        return true;
    }

    public int getNumUsers() {
        return userIDHashSet.size();
    }

    public int getNumUserGroups() {
        return userGroupIDHashSet.size();
    }

}
