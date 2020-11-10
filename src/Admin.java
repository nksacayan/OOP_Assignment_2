public class Admin {
    private AdminControlPanel adminControlPanel;

    // Singleton implementation
    private static Admin instance;

    private Admin() {
        adminControlPanel = new AdminControlPanel();
    }

    public static Admin getInstance() {
        if (instance == null) {
            synchronized (AdminControlPanel.class) {
                if (instance == null) {
                    instance = new Admin();
                }
            }
        }
        return instance;
    }
}
