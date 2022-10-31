package cz.spsmb.source;

public class Singleton {

    private static int instanceCount;
    private static Singleton singleton;

    public static Singleton getSingleton() {
        return singleton;
    }

    public static int getInstanceCount() {
        return instanceCount;
    }

    private Singleton() {
        Singleton.instanceCount++;
    }

    public String getMessage() {
        return "Hello";
    }

}
