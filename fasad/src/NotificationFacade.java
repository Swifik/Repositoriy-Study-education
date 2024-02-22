import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationFacade {
    public void sendSms(UUID userId){
        UserService userService1 = new UserService();
        String userName1 = userService1.getUserNameById(userId);

        String MESSAGE_TYPE_SMS = "SMS";

        MessageTextService messageTextService1 = new MessageTextService();
        String messageText1 = messageTextService1.getShortText(userName1,MESSAGE_TYPE_SMS);

        MessageTitleService messageTitleService1 = new MessageTitleService();
        String messageTitle1 = messageTitleService1.getShortTitle(userName1,MESSAGE_TYPE_SMS);

        SendingTimeService sendingTimeService1 = new SendingTimeService();
        LocalDateTime time1 = sendingTimeService1.getSendingTime(MESSAGE_TYPE_SMS);

        SmsDeliveryService smsDeliveryService = new SmsDeliveryService();
        smsDeliveryService.send(userId,messageTitle1,messageText1,time1);
    }

    public void sendEmail(UUID userId){
        UserService userService2 = new UserService();
        String userName2 = userService2.getUserNameById(userId);

        String MESSAGE_TYPE_EMAIL = "EMAIL";

        MessageTextService messageTextService2 = new MessageTextService();
        String messageText2 = messageTextService2.getFullText(userName2,MESSAGE_TYPE_EMAIL);

        MessageTitleService messageTitleService2 = new MessageTitleService();
        String messageTitle2 = messageTitleService2.getFullTitle(userName2,MESSAGE_TYPE_EMAIL);

        SendingTimeService sendingTimeService2 = new SendingTimeService();
        LocalDateTime time2 = sendingTimeService2.getSendingTime(MESSAGE_TYPE_EMAIL);

        EmailDeliveryService emailDeliveryService = new EmailDeliveryService();
        emailDeliveryService.send(userId,messageTitle2,messageText2,time2);
    }
}
