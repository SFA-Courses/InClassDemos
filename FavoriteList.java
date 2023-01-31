public class FavoriteList extends ListADT<Favorite> {
    private static final int MAX_FAVORITES = 50;
    private int numFavorites;
    private Favorite[] favorites;

    public FavoriteList() {
        this.numFavorites = 0;
        this.favorites = new Favorite[MAX_FAVORITES];
    }

    @Override
    public boolean isEmpty() {        
        return (this.numFavorites == 0);
    }

    @Override
    public int getSize() {        
        return this.numFavorites;
    }

    @Override
    public void add(int index, Favorite item) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeAll() {
        this.numFavorites = 0;
        this.favorites = new Favorite[MAX_FAVORITES];
        
    }

    @Override
    public Favorite get(int index) {      
        if ((index < 0) || (index >= this.getSize() ))
            throw new ListException("Index " + index + " is invalid for a " +
                                      "list of size " + this.getSize());
        
        return this.favorites[index];
    }
    
}
