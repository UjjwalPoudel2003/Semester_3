public class ScienceBook extends Book{
    @Override
    public void setPrice(double price) {
        double discount = 0.1 * price;
        price -= discount;
        this.price = price;
    }

    @Override
    public String getGenre() {
        return "Science";
    }

}
