package me.duck.java.object;

public class equalsAndHashCode {
    public static void main(String args[]) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode());
        System.out.println(obj2.hashCode());

        String str1 = "test";
        String str2 = "test";

        // 동일성 비교. 객체 인스턴스의 주소 값을 비교.
        //primitive 인 경우 ==으로 값 비교 가능
        System.out.println(str1==str2);

        //동등성 비교. 객체 내부의 값을 비교.
        System.out.println(str1.equals(str2));

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
    }
}
