package thread;

import java.util.Optional;

public class ThreadDemo {

    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>(){
            @Override
            protected Integer initialValue() {
                return super.initialValue();
            }
        };
        threadLocal.set(1);

        threadLocal.get();

        System.out.println(Optional.of(2).orElse(1));
    }
}
