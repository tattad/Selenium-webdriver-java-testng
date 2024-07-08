package javaTester.javaDemoSelenium;

public class Topic_14_Constructor {
    //Là 1 cái hàm cùng tên với class
    //Không có kiểu dữ liệu trả về
    //Trong 1 class có thể có nhiều constructor
    //1 Class nếu không define cái constructor cụ thể thì nó sẽ có 1 constructor rỗng (default)
    //Nếu mình define thì khi khởi tạo nó bắt buộc phải gọi tới constructor mà mình define

    public Topic_14_Constructor(String name) {
        System.out.println(name);
    }

    public Topic_14_Constructor(int numberStudent) {
        System.out.println(numberStudent);
    }

    public Topic_14_Constructor(String name, int numberStudent) {
        System.out.println(numberStudent);
    }

    public static void main(String[] args) {
        Topic_14_Constructor topic01 = new Topic_14_Constructor("Automation");
        Topic_14_Constructor topic02 = new Topic_14_Constructor(15);
    }
}
