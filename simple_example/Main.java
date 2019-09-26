import mylib.Lib;

public class Main {
    public static void main(String[] args) {
        System.out.println("main start");
        Lib lib = new Lib();
        lib.test();
        System.out.println("main end");
    }
}    


// 包和Main在同一级目录,直接可编译运行: javac Main.java && java Main



