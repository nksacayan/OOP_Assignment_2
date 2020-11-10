import java.util.ArrayList;
import java.util.HashSet;

public class User {
    // User class is a leaf of composite
    // User is both and observer and subject
    private static HashSet<String> userIDSet;
    private String userID;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> newsFeed;

    public void followUser() {
        // TODO: Follow function
    }

    public void postTweet() {
        // TODO: Post tweet
    }

}
