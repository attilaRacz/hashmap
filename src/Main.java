import hashMapImpl.HashMapImpl;

public class Main {

    public static void main(String[] args) {
        HashMapImpl hashMap = new HashMapImpl(16);
        hashMap.add("hey", 2);
        hashMap.add("ho", 123);
        hashMap.add("let's", 45);
        hashMap.add("go", 90);
        System.out.println("value: " + hashMap.getValue("ho"));
        hashMap.remove("ho");
        System.out.println("\"ho\" removed");
        System.out.println("value: " + hashMap.getValue("ho"));
        hashMap.clearAll();
        System.out.println("All cleared");
        System.out.println("value: " + hashMap.getValue("hey"));
    }

}
