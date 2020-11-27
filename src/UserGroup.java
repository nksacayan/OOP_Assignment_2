import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;

public class UserGroup extends DefaultMutableTreeNode implements Visitable {
    // UserGroup class is a composite structure
    private String userGroupID;
    private long creationTime = System.currentTimeMillis();
    private ArrayList<User> users = new ArrayList<>();
    public UserGroup(String userGroupID) {
        this.userGroupID = userGroupID;
        allowsChildren = true;
    }

    public long getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return userGroupID;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitUserGroup(this);
    }
}
