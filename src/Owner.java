public class Owner extends User {
    private int ownerID;

    public Owner(String name, String userID, String job, int OwnerID) {
        super(name, userID, "Owner");
        this.ownerID = OwnerID;
    }

    public float viewTotalRevenue(Bookstore store) {
        return store.getDailyRevenue();
    }
}
