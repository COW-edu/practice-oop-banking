import bankService.Message;

public class StartBank {
    public static void main(String[] args) {
        Boolean repeat = true;
        Message message = new Message();

        while(repeat) {
            repeat = message.askAction();
        }
    }
}
