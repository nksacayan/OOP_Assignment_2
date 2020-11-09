import javax.swing.*;

public class UserView {
    private JPanel contentPanel;
    private JTextField textFieldUserID;
    private JButton buttonFollowUser;
    private JList listCurrentFollowing;
    private JTextField textFieldTweetMessage;
    private JButton buttonPostTweet;
    private JList listNewsFeed;

    public static void main(String[] args) {
        JFrame frame = new JFrame("UserView");
        frame.setContentPane(new UserView().contentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
