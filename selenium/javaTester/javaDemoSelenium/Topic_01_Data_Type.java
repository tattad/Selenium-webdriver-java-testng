package javaTester.javaDemoSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    //Kieu du lieu trong Java - 2 nhom

    //Nhóm 1: Kiểu dữ liệu nguyên thủy (Primitive Type)
    //8 loại
    //Số Nguyên: byte - short - int - long
    //Không có phần thập phân: nhân viên trong 1 cty/ hoc sinh trong 1 lop
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 15111234;
    long lNumber = 1247521749;


    //Số thực: float - double
    //Có phần thập phân: diem so/ luong/...
    float fNumber = 9.99f;
    double dNumber = 35.800000d;

    //Kí tự: char
    //Đại diện cho 1 kí tự
    char c = 'D';
    char d = 'A';

    //Logic: boolean
    boolean status = true;

    //Nhóm 2: Kiểu dữ liệu tham chiếu (Reference Type)
    //Class
    FirefoxDriver firefoxDriver = new FirefoxDriver();
    Select select = new Select(firefoxDriver.findElement(By.className("")));
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();
    //Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    //Object
    Object name = "hahaha";

    //Array
    int[] studentAge = {15, 29, 8};
    String[] studentName = {"auto", "test"};

    //String - Chuỗi kí tự
    String sName = "hello world";

    //Collection: List/ Set/ Queue
    List<String> studentAddress = new ArrayList<String>();
    List<String> studentCity = new LinkedList<>();
    List<String> studentPhone = new Vector<>();

    //Khai báo 1 biến để lưu trữ 1 loại dữ liệu nào đó
    //Access Modifier: Phạm vi truy cập (public/ private/ protected/ default)
    //Kiểu dữ liệu
    //Tên biến
    //Giá trị của biến - gắn vào với phép =
}
