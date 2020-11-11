import java.util.ArrayList;
import java.util.HashSet;

public class UserGroup extends TreeComposite {
    // UserGroup class is a composite structure
    private String userGroupID;
    private ArrayList<User> users;

    public UserGroup(String userGroupID) {
        this.userGroupID = userGroupID;
        users = new ArrayList<>();
    }
}
