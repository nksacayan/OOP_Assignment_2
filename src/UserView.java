import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class UserView extends JFrame {
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
    private JTextArea textAreaCreationTime;
    private User user;

    public UserView(User user) throws HeadlessException {
        add(contentPanel);
        setTitle(user.toString());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);
        this.user = user;

        listNewsFeed.setModel(user.getNewsFeedListModel());
        listCurrentFollowing.setModel(user.getFollowingListModel());
        textAreaCreationTime.setText("User created at: " + user.getCreationTime());

        buttonPostTweet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.postTweet(textFieldTweetMessage.getText());
                textFieldTweetMessage.setText("");
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

}
