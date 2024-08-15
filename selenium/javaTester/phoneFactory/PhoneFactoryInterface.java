package javaTester.phoneFactory;

public interface PhoneFactoryInterface {

//    public static final String PHONE_NAME = "";

    public abstract void setPhoneName(String phoneName);

    public abstract String getPhoneName();

    //Dù không thêm từ khóa abstract nhưng trình biên dịch tự hiểu
    //Đây là 1 abstract method
    public void touchPhone();
}
