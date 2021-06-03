package Operations;

public class Validations {

    public static boolean isEmpty(String value) {
        if (value != null) {
            return value.trim().isEmpty();
        }
        return false;
    }

    public static boolean isNumber(String value) {
        try {
            if (value != null) {
                Integer.parseInt(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {

        }
        return false;
    }

    public static boolean isFloat(String value) {
        try {
            if (value != null) {
                Float.parseFloat(value.trim());
                return true;
            }
        } catch (NumberFormatException ex) {

        }
        return false;
    }
}
