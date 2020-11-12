import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class User extends DefaultMutableTreeNode implements PropertyChangeListener {
    // User class is a leaf of composite
    // User is both and observer and subject
    // User is observer to its list of followings
    // User is subject to its list of followers

    private final String EVENT = "tweet";
    private Admin admin;
    private String userID;
    private String tweet = "Default";
    private DefaultListModel<String> followingListModel = new DefaultListModel<>();
    private DefaultListModel<String> newsFeedListModel = new DefaultListModel<>();
    // Observable
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public User(String userID, Admin admin) {
        this.userID = userID;
        allowsChildren = false;
        this.admin = admin;
    }

    public DefaultListModel<String> getFollowingListModel() {
        return followingListModel;
    }

    public DefaultListModel<String> getNewsFeedListModel() {
        return newsFeedListModel;
    }

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
        newsFeedListModel.addElement(tweet);

    }

    // Observer
    // Runs method when event is received
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        newsFeedListModel.addElement((String) evt.getNewValue());
    }

    public void followUser(String userID) {
        // TODO: Follow function
    }

    @Override
    public String toString() {
        return userID;
    }
}
