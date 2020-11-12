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
    private User user;

    public UserView(User user) throws HeadlessException {
        add(contentPanel);
        setTitle("Admin Control Panel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
        setVisible(true);

        listNewsFeed = new JList(user.getNewsFeedListModel());

        listNewsFeed.setLayoutOrientation(JList.VERTICAL);
        listCurrentFollowing.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        this.user = user;

        buttonPostTweet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                user.postTweet(textFieldTweetMessage.toString());
                textFieldTweetMessage.setText("");
            }
        });
    }

    public JList getListCurrentFollowing() {
        return listCurrentFollowing;
    }

    // TODO: Display current users you are following
    // TODO: Display news feed
    // TODO: Post tweet with text area and button
    //  Adds message to both followers and own news feed
    // TODO: Whenever a new message is posted, all followers news list should update automatically

    public JList getListNewsFeed() {
        return listNewsFeed;
    }

}
