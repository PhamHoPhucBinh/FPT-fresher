package Assignment.Day1;


import org.w3c.dom.ls.LSOutput;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }
}

public class Question10 {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("Trước khi gọi phương thức: " + num);
        modifyValue(num);
        System.out.println("Sau khi gọi phương thức: " + num);

        /////////////////////////////////

        Person person = new Person("Binh");
        System.out.println("before :" + person.name);
        changeName(person);
        System.out.println("after: " + person.name);

    }
/* đây là document để làm tài liệu , có thể đi kèm @param */
    public static void changeName(Person p) {
//        Person person = new Person("Tai");
        p.name = "tai";
        System.out.println("ten trong function : " + p.name); //đây là comment: giải thích ngay trong dòng code//
    }

    public static void modifyValue(int value) {
        value = 20;
        System.out.println("Trong phương thức: " + value);
    }
}
