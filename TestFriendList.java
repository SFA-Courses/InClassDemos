public class TestFriendList {
    public static void main(String[] args) {
        FriendsList friends = new FriendsList();
        System.out.println("Testing add: ");
        friends.add(0, new Friend("Lezduit", true));
        friends.add(1, new Friend("magicschoolbusdropout", false));
        friends.add(2, new Friend("hoosierdaddy", false));
        System.out.println(friends.toString());

        System.out.println();
        System.out.println("Testing remove: ");
        friends.remove(2);
        System.out.println(friends.toString());

        System.out.println();
        System.out.println("Testing remove all: ");
        friends.removeAll();
        System.out.println(friends.toString());

    }
}
