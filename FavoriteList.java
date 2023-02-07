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
        if ((index < 0) || (index > this.getSize() ))
            throw new ListException("Index " + index + " is invalid for a " +
                                      "list of size " + this.getSize());

        for (int i = this.getSize(); i > index; i--) {
            this.favorites[i] = this.favorites[i-1];
        }

        this.favorites[index] = item;
        this.numFavorites++;
    }

    @Override
    public void remove(int index) {
        if ((index < 0) || (index >= this.getSize() ))
            throw new ListException("Index " + index + " is invalid for a " +
                                      "list of size " + this.getSize());

        for (int i = index + 1; i < this.getSize(); i++)
            this.favorites[i - 1] = this.favorites[i];

        
        this.numFavorites--;
        
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

    @Override
    public String toString() {
        String s = "";
        for (int i =0; i < this.getSize(); i++)
            s += "Item " + i + " is " + this.get(i).toString() + "\n";
        return s;

        
    }
    
}
