public class Basket {

    private static int count = 0;
    private  static int totalCount = 0;
    private String items = "";
    private int totalPrice = 0;
    private static  int totalItemsPrice = 0;
    private int limit;
    private double totalWeight = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }
    public static  void increaseTotalCount(int count){
        Basket.totalCount += count;
    }
    public  static void  increaseTotalItemsPrice(int price){
        Basket.totalItemsPrice += price;
    }
    public static  double averagePriceProduct(){
        System.out.println("Средняя цена товара: " + (double) totalItemsPrice/(double) totalCount);
        return totalItemsPrice/totalCount;
    }
    public  static double averagePriceBasket(){
        System.out.println("Средняя цена корзины: " + (double)totalItemsPrice/(double) Basket.count);
        return totalItemsPrice/Basket.count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);

    }

    public void add(String name, int price, int count, double weight){
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        increaseTotalCount(count);
        increaseTotalItemsPrice(price);
        totalPrice = totalPrice + count * price;
        items = items + "\n" + name + " - " +
                count + " шт. - " + price + " - " + weight + "гр";
        totalWeight = totalWeight + count*weight;
    }



    public double getTotalWeight() {
        return totalWeight;
    }


    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
}
