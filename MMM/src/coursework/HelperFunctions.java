package coursework;

public class HelperFunctions {
    /**
     * Большая ли первая буква
     * @param str
     * @return
     */
    public static boolean checkCapitalLetter(String str) {
        if (str.length() < 1)
            return false;
        if (Character.isUpperCase(str.charAt(0)))
            return true;
        return false;
    }

    /**
     * Чистка от лишних пробелов
     * @param string
     * @return результирующая строка
     */
    public static String cleanDoubleSpaces(String string){
        return string.trim().replaceAll(" +", " ");
    }
}
