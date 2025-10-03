package lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;
import lk.sliit.inventorycontrolsystem.projectse2030se.utils.base.MethodUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GetterHelper {
    public static <T extends DefaultModel> List<Method> getOrderedAllPublicGetters(T object) {
        Class<?> clazz = object.getClass();
        Class<?> superclass = clazz.getSuperclass();

        List<Method> getters = getOrderedDeclaredPublicGetters(clazz);
        List<Method> superGetters = new ArrayList<>();

        if (superclass != null) {
            superGetters = getOrderedDeclaredPublicGetters(superclass);
        }

        List<Method> allGetters = new ArrayList<>();
        allGetters.addAll(superGetters);
        allGetters.addAll(getters);

        return allGetters;
    }

    public static <T extends DefaultModel> List<Method> getOrderedDeclaredPublicGetters(T object) {
        Class<?> clazz = object.getClass();
        return getOrderedDeclaredPublicGetters(clazz);
    }

    private static List<Method> getOrderedDeclaredPublicGetters(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<Method> getters = getAllPublicGetters(clazz);

        List<Method> orderedGetters = new ArrayList<>();

        for (Field field : fields) {
            String fieldName = field.getName().toLowerCase();

            for (Method getter : getters) {
                if (orderedGetters.contains(getter)) continue;

                String methodName = getter.getName().toLowerCase();
                if (methodName.contains(fieldName)) {
                    orderedGetters.add(getter);
                }
            }
        }

        return orderedGetters;
    }

    private static List<Method> getAllPublicGetters(Class<?> clazz) {
        List<Method> methods = MethodUtils.getAllPublicMethods(clazz);

        List<Method> filteredMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Getter.class)) {
                filteredMethods.add(method);
            }
        }

        return filteredMethods;
    }

    public static <T extends DefaultModel> Method getSpecificPublicGetter(T object, String methodName) {
        List<Method> filteredGetters = getAllPublicGetters(object.getClass());

        for (Method getter : filteredGetters) {
            if (getter.getName().equals(methodName)) {
                return getter;
            }
        }

        return null;
    }

    public static <T extends DefaultModel> Method getSpecificPublicGetter(Class<T> clazz, String methodName) {
        List<Method> filteredGetters = getAllPublicGetters(clazz);

        for (Method getter : filteredGetters) {
            if (getter.getName().equals(methodName)) {
                return getter;
            }
        }

        return null;
    }
}
