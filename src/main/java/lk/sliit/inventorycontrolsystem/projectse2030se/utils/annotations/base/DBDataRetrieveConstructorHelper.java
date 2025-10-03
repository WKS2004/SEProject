package lk.sliit.inventorycontrolsystem.projectse2030se.utils.annotations.base;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;

import java.lang.reflect.Constructor;
import java.util.List;

public class DBDataRetrieveConstructorHelper {
    public static <T extends DefaultModel>Constructor<T> getConstructor(Class<T> clazz) {
        Constructor<T> foundConstructor = null;
        List<Constructor<T>> allConstructors = ConstructorHelper.getPublicConstructors(clazz);

        for (Constructor<T> constructor : allConstructors) {
            if (constructor.isAnnotationPresent(DBDataRetrieveConstructor.class)) {
                if (foundConstructor != null) {
                    throw new IllegalArgumentException("Multiple Constructors Found for DBDataRetrieveConstructor in " + clazz.getSimpleName() + " class!");
                }
                foundConstructor = constructor;
            }
        }

        if (foundConstructor == null) {
            throw new IllegalArgumentException("No Constructor Found for DBDataRetrieveConstructor in " + clazz.getSimpleName() + " class or the Constructor is not Public!");
        }

        return foundConstructor;
    }
}
