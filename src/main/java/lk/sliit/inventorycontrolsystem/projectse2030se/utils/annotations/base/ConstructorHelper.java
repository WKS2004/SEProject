package lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ConstructorHelper {
    public static <T> List<Constructor<T>> getPublicConstructors(Class<T> clazz) {
        @SuppressWarnings("unchecked")
        Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();

        List<Constructor<T>> constructorList = new ArrayList<>();

        for (Constructor<T> constructor : constructors) {
            if (Modifier.isPublic(constructor.getModifiers())) {
                constructorList.add(constructor);
            }
        }

        return constructorList;
    }

//    public static <T> Constructor<T> getConstructorByParameterCount(Class<T> clazz, int count) {
//        Constructor<T>[] constructors = getConstructors(clazz);
//
//        for (Constructor<T> constructor : constructors) {
//            if (constructor.getParameterCount() == count) {
//                return constructor;
//            }
//        }
//
//        throw new IllegalArgumentException("No constructor found with " + count + " parameters in " + clazz.getSimpleName() + " class");
//    }

}
