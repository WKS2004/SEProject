package lk.sliit.inventorycontrolsystem.projectse2030se.utils.base;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class MethodUtils {
    public static <T> List<Method> getPublicDeclaredMethods(Class<T> clazz) {
        Method[] allDeclaredMethods = clazz.getDeclaredMethods();
        List<Method> publicDeclaredMethods = new ArrayList<>();

        for (Method method : allDeclaredMethods) {
            if (Modifier.isPublic(method.getModifiers())) {
                publicDeclaredMethods.add(method);
            }
        }

        return publicDeclaredMethods;
    }

    public static <T> List<Method> getPublicSuperMethods(Class<T> clazz) {
        return getPublicDeclaredMethods(clazz.getSuperclass());
    }

    public static <T> List<Method> getAllPublicSuperMethods(Class<T> clazz) {
        Class<?> newClass = clazz.getSuperclass();

        List<Method> allMethods = new ArrayList<>();

        while (newClass != Object.class) {
            allMethods.addAll(getPublicDeclaredMethods(newClass));

            newClass = newClass.getSuperclass();
        }

        return allMethods;

    }

    public static <T> List<Method> getAllPublicMethods(Class<T> clazz) {
        List<Method> methods = MethodUtils.getPublicDeclaredMethods(clazz);
        List<Method> allSuperMethods = MethodUtils.getAllPublicSuperMethods(clazz);

        List<Method> allMethods = new ArrayList<>();
        allMethods.addAll(allSuperMethods);
        allMethods.addAll(methods);

        return allMethods;
    }
}
