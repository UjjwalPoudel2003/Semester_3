public class ChildrenBook extends Book{
    @Override
    void setPrice(double price) {
        this.price = price;
    }

    @Override
    String getGenre() {
        return "Children";
    }
}
