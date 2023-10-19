public class ChildrenBook extends Book{
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getGenre() {
        return "Children";
    }
}
