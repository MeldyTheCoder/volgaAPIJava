import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class BaseObject {

    private Field[] getFields() {
        Class<?> c = this.getClass();
        return c.getFields();
    }

    private String getAttribute(String name) throws Exception {
        Class<?> c = this.getClass();
        return c.getDeclaredField(name).get(this).toString();
    }

    private List<String> formatedFields() {
        Field[] fields = this.getFields();
        List<String> formated_fields = new ArrayList<>();

        for (Field field : fields) {
            try {
                String name = field.getName();
                formated_fields.add(name + "=" + this.getAttribute(name));
            } catch (Exception e) {
                System.out.println("Ошибка форматирования");
            }
        }
        return formated_fields;
    }
    public String toString() {
        return this.getClass().getName() + ": " + this.formatedFields().toString();
    }
}
