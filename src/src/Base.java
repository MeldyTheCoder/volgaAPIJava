public class Base {

    public String toString() {
        return this.getClass().getName() + "[" + this.getClass().getDeclaredMethods().toString() + "]";
    }
}
