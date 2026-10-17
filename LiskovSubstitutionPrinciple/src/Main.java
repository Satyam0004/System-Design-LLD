class Notification { // Building notification Service
    public void sendNotification() {
        System.out.println("Email sent");
    }
}

class TextNotification extends Notification {

    @Override
    public void sendNotification() {
        System.out.println("Text sent");
    }
}

class WhatsAppNotification extends Notification {
    @Override
    public void sendNotification() {
        System.out.println("WhatsApp sent");
    }
}

public class Main {
    public static void main(String[] args) {
        Notification notification = new TextNotification();
        notification.sendNotification();
    }
}