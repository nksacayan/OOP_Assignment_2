import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class UserGroup extends DefaultMutableTreeNode {
    // UserGroup class is a composite structure
    private String userGroupID;
    private ArrayList<User> users = new ArrayList<>();

    public UserGroup(String userGroupID) {
        this.userGroupID = userGroupID;
        allowsChildren = true;
    }

    @Override
    public String toString() {
        return userGroupID;
    }
}
