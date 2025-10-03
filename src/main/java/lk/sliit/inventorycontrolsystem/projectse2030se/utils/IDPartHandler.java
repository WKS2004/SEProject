package lk.sliit.inventorycontrolsystem.projectse2030se.utils;

import lk.sliit.inventorycontrolsystem.projectse2030se.models.DefaultModel;

public class IDPartHandler {

    public static <T extends DefaultModel> String idRetriever(Class<T> modelClass) {
        String USER_ID_PART = "0001";
        String ITEM_ID_PART = "0002";
        String COURSE_ID_PART = "0003";
        String PAYMENT_ID_PART = "0004";
        String NOTIFICATION_ID_PART = "0004";

        return switch (modelClass.getSimpleName()) {
            case "User" -> USER_ID_PART;
            case "Item" -> ITEM_ID_PART;
            case "Course" -> COURSE_ID_PART;
            case "Payment" -> PAYMENT_ID_PART;
            case "Notification" -> NOTIFICATION_ID_PART;
            default -> null;
        };

    }
}
