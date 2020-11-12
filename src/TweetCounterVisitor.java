public class TweetCounterVisitor implements Visitor {
    private int numTweets = 0;

    public int getNumTweets() {
        return numTweets;
    }

    @Override
    public void visitUser(User user) {
        numTweets += user.getNewsFeedListModel().size();
    }

    @Override
    public void visitUserGroup(UserGroup userGroup) {

    }

    public void resetCount() {
        numTweets = 0;
    }
}
