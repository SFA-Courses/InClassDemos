public class Friend {
    private String username;
    private boolean status; // true - Online; false - Offline;
    
    public Friend(String name, boolean online) {
        this.username = name;
        this.status = online;
    }

    public Friend(String name) {
        this(name, false);
    }

    public void setStatue(boolean online) {
        this.status = online;
    }

    @Override
    public String toString() {
        String s = this.status ? "Online" : "Offline";
        return username + " " + s;
    }
}
