package onlineticketing;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataFromCSV {
    private static DataFromCSV instance = null;

    private DataFromCSV() {

    }

    public static DataFromCSV getInstance() {
        synchronized (DataFromCSV.class) {
            if (instance == null) {
                instance = new DataFromCSV();
            }
        }
        return instance;
    }

    public <T> void write(List<T> list, String path) throws Exception {
        try {
            Field[] fields = list.get(0).getClass().getDeclaredFields();
            for(Field field : fields) {
                field.setAccessible(true);
            }

            try(PrintWriter writer = new PrintWriter(path)) {
                for(T element : list) {
                    for(int i = 0; i < fields.length - 1; i++) {
                        Object value = fields[i].get(element);
                        if(value != null) {
                            writer.print(value);
                        }
                        writer.print(",");
                    }

                    Object value = fields[fields.length - 1].get(element);
                    if(value != null) {
                        writer.println(value);
                    }

                }
            }
        } catch(Exception e) {
            e.getMessage();
        }
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> readLogs(String path, Class<T> type) throws Exception {
        List<T> records = new ArrayList<T>();
        Constructor<T> constructor = type.getDeclaredConstructor();
        Field[] fields = type.getDeclaredFields();
        constructor.setAccessible(true);
        for (Field field : fields) {
            field.setAccessible(true);
        }
        for (String line : Files.readAllLines(Paths.get(path))) {
            Log record = new Log(line);

            records.add((T)record);
        }

        return records;
    }

    @SuppressWarnings("unchecked")
    public <T> List<T> read(String path, Class<T> type) throws Exception {
        List<T> records = new ArrayList<T>();
        Constructor<T> constructor = type.getDeclaredConstructor();
        Field[] fields = type.getDeclaredFields();
        constructor.setAccessible(true);
        for (Field field : fields) {
            field.setAccessible(true);
        }
        for (String line : Files.readAllLines(Paths.get(path))) {
            Ticket record = new Ticket(line);

            records.add((T)record);
        }

        return records;
    }

    private void setField(Object object, Field field, String text) throws Exception {
        if (text.isEmpty()) {
            return;
        }
        Object value = null;

        if (String.class.equals(field.getType())) {
            value = text;

        } else {
            String name=Character.toUpperCase(field.getType().getSimpleName().charAt(0)) + field.getType().getSimpleName().substring(1);
            Class<?> type = Class.forName("java.lang." + name + (int.class.equals(field.getType()) ? "eger" : ""));
            Method method = type.getDeclaredMethod("parse" + name, String.class);
            value = method.invoke(null, text);
        }

        field.set(object, value);
    }

}
