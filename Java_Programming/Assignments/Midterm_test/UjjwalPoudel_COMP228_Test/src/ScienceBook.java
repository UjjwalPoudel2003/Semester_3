public class ScienceBook extends Book{
    @Override
    void setPrice(double price) {
        double discount = 0.1 * price;
        price -= discount;
        this.price = price;
    }

    @Override
    String getGenre() {
        return "Science";
    }

}
