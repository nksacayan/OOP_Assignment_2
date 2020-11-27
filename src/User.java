import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class User extends DefaultMutableTreeNode implements PropertyChangeListener, Visitable {
    // User class is a leaf of composite
    // User is both and observer and subject
    // User is observer to its list of followings
    // User is subject to its list of followers

    private Admin admin;
    private String userID;
    private String tweet = "Default";
    private long creationTime = System.currentTimeMillis();
    private long lastUpdatedTime;
    private DefaultListModel<String> followingListModel = new DefaultListModel<>();
    private DefaultListModel<String> newsFeedListModel = new DefaultListModel<>();
    // Observable
    private PropertyChangeSupport support = new PropertyChangeSupport(this);
    public User(String userID, Admin admin) {
        this.userID = userID;
        allowsChildren = false;
        this.admin = admin;
    }

    public long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public long getCreationTime() {
        return creationTime;
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
        String event = "tweet";
        tweet = this.userID + ": " + tweet;
        support.firePropertyChange(event, this.tweet, tweet);
        this.tweet = tweet;
        newsFeedListModel.addElement(tweet);
        updateLastUpdatedTime();

    }

    // Observer
    // Runs method when event is received
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        newsFeedListModel.addElement((String) evt.getNewValue());
        updateLastUpdatedTime();
    }

    public void followUser(String userID) {
        if (userID.equals(this.userID)) {
            throw new IllegalArgumentException("User: " + userID + " tried to follow self.");
        }
        if (followingListModel.contains(userID)) {
            throw new IllegalArgumentException("User: " + this.userID + " already follows " + userID);
        }
        User user = admin.findUser(userID);
        if (user == null) {
            throw new IllegalArgumentException("Could not find user");
        }
        user.addPropertyChangeListener(this);
        followingListModel.addElement(user.userID);
    }

    @Override
    public String toString() {
        return userID;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitUser(this);
    }

    private void updateLastUpdatedTime() {
        lastUpdatedTime = System.currentTimeMillis();
    }
}
