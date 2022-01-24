package ns.commons;

public class Util {
    public static String setDhEmi(){
        return java.time.LocalDateTime.now().toString().substring(0, java.time.LocalDateTime.now().toString().length() - 4)+"-03:00";
    }
}
