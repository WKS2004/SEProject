package lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.MethodUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SetterHelper {
    public static <T extends DefaultModel> List<Method> getOrderedAllPublicSetters(T object) {
        Class<?> clazz = object.getClass();
        Class<?> superclass = clazz.getSuperclass();

        List<Method> setters = getOrderedDeclaredPublicSetters(clazz);
        List<Method> superSetters = new ArrayList<>();

        if (superclass != null) {
            superSetters = getOrderedDeclaredPublicSetters(superclass);
        }

        List<Method> allSetters = new ArrayList<>();
        allSetters.addAll(superSetters);
        allSetters.addAll(setters);

        return allSetters;
    }

    public static <T extends DefaultModel> List<Method> getOrderedDeclaredPublicSetters(T object) {
        Class<?> clazz = object.getClass();
        return getOrderedDeclaredPublicSetters(clazz);
    }

    private static List<Method> getOrderedDeclaredPublicSetters(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<Method> setters = getAllPublicSetters(clazz);

        List<Method> orderedSetters = new ArrayList<>();

        for (Field field : fields) {
            String fieldName = field.getName().toLowerCase();

            for (Method setter : setters) {
                if (orderedSetters.contains(setter)) continue;

                String methodName = setter.getName().toLowerCase();
                if (methodName.contains(fieldName)) {
                    orderedSetters.add(setter);
                }
            }
        }

        return orderedSetters;
    }

    private static List<Method> getAllPublicSetters(Class<?> clazz) {
        List<Method> methods = MethodUtils.getAllPublicMethods(clazz);

        List<Method> filteredMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Setter.class)) {
                filteredMethods.add(method);
            }
        }

        return filteredMethods;
    }

    public static <T extends DefaultModel> Method getSpecificPublicSetter(T object, String methodName) {
        List<Method> filteredSetters = getAllPublicSetters(object.getClass());

        for (Method setter : filteredSetters) {
            if (setter.getName().equals(methodName)) {
                return setter;
            }
        }

        return null;
    }

    public static <T extends DefaultModel> Method getSpecificPublicSetter(Class<T> clazz, String methodName) {
        List<Method> filteredSetters = getAllPublicSetters(clazz);

        for (Method setter : filteredSetters) {
            if (setter.getName().equals(methodName)) {
                return setter;
            }
        }

        return null;
    }
}
