import java.net.MalformedURLException;

public class TestFavoriteList {
    public static void main(String[] args) throws MalformedURLException {
        FavoriteList favList = new FavoriteList();
        System.out.println("Testing add: ");
        Favorite f = new Favorite("Minecraft", "https://www.youtube.com/watch?v=0cpQC5jVMDg");
        favList.add(0, f);
        f = new Favorite("Madden", "https://www.youtube.com/watch?v=bOSZwKSb09M");
        favList.add(1, f);
        f = new Favorite("Monster Hunter", "https://www.youtube.com/watch?v=TdCec2GRg-w");
        favList.add(0,f);
        System.out.println(favList);
        System.out.println();
        System.out.println("Last Element:");
        System.out.println(favList.get(favList.getSize()-1));

        System.out.println();
        System.out.println("Testing Remove: ");
        favList.remove(1);
        System.out.println(favList);

        System.out.println();
        System.out.println("Testing Remove All: ");
        favList.removeAll();
        System.out.println(favList);

    }
}
