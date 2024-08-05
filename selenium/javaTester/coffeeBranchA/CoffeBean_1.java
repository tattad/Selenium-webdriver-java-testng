package javaTester.coffeeBranchA;

import javaTester.coffeeBean.CoffeeBean;

//Nhượng quyền của Bean
//Chi nhánh con của Bean
public class CoffeBean_1 extends CoffeeBean {

    public static void main(String[] args) {

    }

    public void createCafe() {
        //Capuccino

        //Espreso
        System.out.println("Get espreso cafe: " + espreso);
        shipEspreso();

        shipOrange();

//        shipLemon();

//        shipUniqueCafe();
    }
}
