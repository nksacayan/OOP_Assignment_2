import java.util.HashSet;

public class PositiveTweetVisitor implements Visitor {

    private int numTweets = 0;
    private int numPositiveTweets = 0;
    private HashSet<String> positiveWordList = new HashSet<>();

    public PositiveTweetVisitor() {
        positiveWordList.add("Good");
        positiveWordList.add("Yay");
        positiveWordList.add("Hooray");
        positiveWordList.add("Great");
    }

    @Override
    public void visitUser(User user) {
        numTweets += user.getNewsFeedListModel().getSize();
        for (int i = 0; i < user.getNewsFeedListModel().size(); i++) {
            String tweet = user.getNewsFeedListModel().elementAt(i);
            for (String word : positiveWordList) {
                if (tweet.contains(word)) {
                    numPositiveTweets += 1;
                    break;
                }
            }
        }

    }

    @Override
    public void visitUserGroup(UserGroup userGroup) {

    }

    public double calculatePercentage() {
        return (double) (numPositiveTweets / numTweets) * 100;
    }

    public void resetCount() {
        numTweets = 0;
        numPositiveTweets = 0;
    }
}
