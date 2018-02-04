package by.tc.task02.service.validation;

import by.tc.task02.entity.Category;

public class Validator {

    public static boolean isValid(Category category, String title, int price) {
        return isStringOrNull(title) && isNumberOrNull(price) && categoryChecker(category);
    }

    private static boolean categoryChecker(Category category) {
        if (category == null) {
            return true;
        }
        return category instanceof Category;
    }

    private static boolean isNumberOrNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return obj instanceof Number;
    }

    private static boolean isStringOrNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return obj instanceof String;
    }
}
