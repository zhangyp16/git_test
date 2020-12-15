public class M {

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("=======> do gc ====");
    }
}
