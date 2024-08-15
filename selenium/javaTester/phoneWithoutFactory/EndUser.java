package javaTester.phoneWithoutFactory;

public class EndUser {

    public static void main(String[] args) {
        //Quận 3 - Iphone
        IPhone iPhone = new IPhone();
        iPhone.setPhoneName("IPhone 14");
        System.out.println(iPhone.getPhoneName());
        iPhone.setPhoneName("IPhone 14 Pro");
        System.out.println(iPhone.getPhoneName());
        iPhone.setPhoneName("IPhone 14 Pro Max");
        System.out.println(iPhone.getPhoneName());
        iPhone.setPhoneName("IPhone 13");
        System.out.println(iPhone.getPhoneName());

        //Quận 8 - Samsung
        Samsung samsung = new Samsung();
        samsung.setPhoneName("Samsung S23");
        System.out.println(samsung.getPhoneName());
        samsung.setPhoneName("Samsung S23 Plus");
        System.out.println(samsung.getPhoneName());
        samsung.setPhoneName("Samsung S23 Ultra 5G");
        System.out.println(samsung.getPhoneName());

        //Quận 5 - Reno
        Reno reno = new Reno();
        reno.setPhoneName("Reno 6");
        System.out.println(reno.getPhoneName());
        reno.setPhoneName("Reno 7");
        System.out.println(reno.getPhoneName());
        reno.setPhoneName("Reno 8");
        System.out.println(reno.getPhoneName());
    }
}
