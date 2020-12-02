import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class UserView extends JFrame implements PropertyChangeListener {
    private final String EVENT = "tweet";
    private JPanel contentPanel;
    private JTextField textFieldUserID;
    private JButton buttonFollowUser;
    private JList listCurrentFollowing;
    private JTextField textFieldTweetMessage;
    private JButton buttonPostTweet;
    private JList listNewsFeed;
    private JPanel followPanel;
    private JPanel followingPanel;
    private JPanel postPanel;
    private JPanel newsPanel;
    private JLabel creationTimeLabel;
    private JLabel updateTimeLabel;
    private JPanel labelPanel;
    private User user;

    public UserView(User user) throws HeadlessException {
        add(contentPanel);
        setTitle(user.toString());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.user = user;

        listNewsFeed.setModel(user.getNewsFeedListModel());
        listCurrentFollowing.setModel(user.getFollowingListModel());
        creationTimeLabel.setText("User created at: " + user.getCreationTime());
        updateTimeLabel.setText("User last updated at: " + user.getLastUpdatedTime());
        user.addPropertyChangeListener(this);

        pack();
        setVisible(true);

        buttonPostTweet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.postTweet(textFieldTweetMessage.getText());
                textFieldTweetMessage.setText("");
                updateTimeLabel.setText("User last updated at: " + user.getLastUpdatedTime());
            }
        });
        buttonFollowUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.followUser(textFieldUserID.getText());
                textFieldUserID.setText("");
            }
        });
    }

    public JList getListCurrentFollowing() {
        return listCurrentFollowing;
    }
    public JList getListNewsFeed() {
        return listNewsFeed;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("update")) {
            updateTimeLabel.setText("User last updated at: " + user.getLastUpdatedTime());
        }
    }
}
