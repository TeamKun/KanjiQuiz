package net.kunmc.lab.kanjiquiz.command.config;

import java.lang.reflect.Field;

public class ConfigItem {
    Class clazz;
    Field field;

    public ConfigItem(Field field) {
        this.clazz = field.getType();
        this.field = field;
    }

    public String name() {
        return field.getName();
    }

    public Object getValue(Object obj) {
        Object value = null;
        try {
            value = field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }

    public void setValue(Object obj, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
            field.setAccessible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
