//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDateTime;
import java.util.UUID;
public class Main {
    public static void main(String[] args) {
        UUID userId = UUID.randomUUID();
        NotificationFacade notificationFacade = new NotificationFacade();
        notificationFacade.sendSms(userId);
        notificationFacade.sendEmail(userId);
    }
}