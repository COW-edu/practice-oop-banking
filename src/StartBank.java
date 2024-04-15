import bank.Message;

public class StartBank {
    public static void main(String[] args) {
        boolean repeat = true;
        Message message = new Message();

        while(repeat) {
            repeat = message.askAction();
        }
    }
}
