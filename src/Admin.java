import java.util.HashSet;

public class Admin {
    private AdminControlPanel adminControlPanel;
    private HashSet<User> userHashSet;
    private HashSet<UserGroup> userGroupHashSet;

    // Singleton implementation
    private static Admin instance;

    private Admin() {
        adminControlPanel = new AdminControlPanel();
        userHashSet = new HashSet<>();
        userGroupHashSet = new HashSet<>();
    }

    public static Admin getInstance() {
        if (instance == null) {
            synchronized (AdminControlPanel.class) {
                if (instance == null) {
                    instance = new Admin();
                }
            }
        }
        return instance;
    }

    // Methods
    public void addUser(String userID) {
        // TODO: Add users

    }

    public void addUserGroup() {
        // TODO: Add userGroups
    }

    public void updateTree() {
        // TODO: Update tree when users or groups are added
    }

    public int getNumUsers() {
        return userHashSet.size();
    }

    public int getNumUserGroups() {
        return userGroupHashSet.size();
    }

    // TODO: get the total number of Tweet messages in all the users’ news feed
    // TODO: get the percentage of the positive
    //  Tweet messages in all the users’ news feed (the message containing positive words,
    //  such as good, great, excellent, etc.) Free free to decide the positive words.

}
