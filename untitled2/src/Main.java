public class Main {
    static void Error()
    {
        int numberError = 10;
        System.out.println("Ошибка номер " + numberError + ". Проверьте подключение к Интернету");
        System.out.println("Или обратитесь к провайдеру");
    }
    public static void main(String[] args) {
        //int numberError = 10;
        System.out.println("Привет");
        Error();
        //System.out.println("Номер ошибки " + numberError + ". Проверьте подключение к Интернету");
        System.out.println("Или обратитесь к провайдеру");
        Error();
        System.out.println("Опять лагает интернет");
        Error();
        //System.out.println("Номер ошибки " + numberError + ". Проверьте подключение к Интернету"); Copy Paste Programming
        //System.out.println("Или обратитесь к провайдеру");
    }
}