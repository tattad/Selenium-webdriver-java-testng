package javaTester.phoneFactory;

public class EndUser {

    public static void main(String[] args) {
        PhoneFactory phone;
        phone = getPhone("iPhone");
        phone.setPhoneName("iPhone 14 Pro");
        System.out.println(phone.getPhoneName());

        phone = getPhone("Samsung");
        phone.setPhoneName("Samsung S23 Plus");
        System.out.println(phone.getPhoneName());

        phone = getPhone("Reno");
        phone.setPhoneName("Reno 8");
        System.out.println(phone.getPhoneName());
    }

    public static PhoneFactory getPhone(String phoneBrand) {
        PhoneFactory phoneFactory = null;
        if (phoneBrand.equals("iPhone")) {
            phoneFactory = new IPhone();
        } else if (phoneBrand.equals("Samsung")) {
            phoneFactory = new Samsung();
        } else {
            phoneFactory = new Reno();
        }
        return phoneFactory;
    }
}
