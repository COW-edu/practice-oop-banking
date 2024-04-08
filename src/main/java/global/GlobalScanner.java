package global;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Scanner;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalScanner {

    public static final Scanner scanner = new Scanner(System.in);

}
