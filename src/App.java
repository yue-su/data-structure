public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // print args if there is any
        if (args.length > 0) {
            for (String arg : args) {
                System.out.println(arg);
            }
        }
    }
}
