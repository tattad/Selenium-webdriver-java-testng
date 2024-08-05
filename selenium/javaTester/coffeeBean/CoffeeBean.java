package javaTester.coffeeBean;

public class CoffeeBean {

    //Thuộc tính: Variable/ Property
    public String espreso = "Cafe Espreso";

    protected String orangeJuice = "Orange Juice";

    String lemonJuice = "Lemon Juice";

    private String uniqueCafe = "Unique Cafe";

    //Phương thức: Method/ Function
    public void shipEspreso() {
        System.out.println("Ship cafe: " + espreso);
    }

    protected void shipOrange() {
        System.out.println("Ship orange: " + orangeJuice);
    }

    void shipLemon() {
        System.out.println("Ship orange: " + lemonJuice);
    }

    private void shipUniqueCafe() {
        System.out.println("Unique: " + uniqueCafe);
    }

    public static void main(String[] args) {
        CoffeeBean bean = new CoffeeBean();
        bean.shipEspreso();
        bean.shipOrange();
        bean.shipLemon();
        bean.shipUniqueCafe();
    }
}
