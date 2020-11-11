import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class User extends TreeComponent implements PropertyChangeListener {
    // User class is a leaf of composite
    // User is both and observer and subject
    // User is observer to its list of followings
    // User is subject to its list of followers

    private String userID;
    private String tweet = "Default";
    private final String EVENT = "tweet";
    private ArrayList<User> followers = new ArrayList<>();
    private ArrayList<User> following = new ArrayList<>();
    private ArrayList<String> newsFeed = new ArrayList<>();

    // Observable
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Adds listener to this observable
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    // Removes listener
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    // Notifies listeners
    public void postTweet(String tweet) {
        // TODO: Post tweet
        support.firePropertyChange(EVENT, this.tweet, tweet);
        this.tweet = tweet;
    }

    // Observer
    // Runs method when event is received
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.postTweet((String) evt.getNewValue());
    }

    public User(String userID) {
        this.userID = userID;
    }

    public void followUser() {
        // TODO: Follow function
    }

    public void printTweet() {
        System.out.println(tweet);
    }

}
