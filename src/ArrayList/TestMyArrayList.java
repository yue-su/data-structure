package ArrayList;

public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList(5);
        try {
            list.addLast("first");
            list.addLast("second");
            list.addLast("third");
            list.add(1, "inserted");
            list.addFirst("zero");
            list.removeLast();
            list.printList();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }
}
