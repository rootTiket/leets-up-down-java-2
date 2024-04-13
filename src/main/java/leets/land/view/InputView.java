package leets.land.view;

import java.util.Scanner;

public class InputView {
    private final Scanner sc = new Scanner(System.in);

    public int versionInput() {
        System.out.print("버전을 입력해주세요 (숫자 버전: 1, 영어 버전: 2) : ");
        String version = sc.next();
        return validateNumberType(version);
    }

    public int readNumber() {
        System.out.print("숫자를 입력해주세요(1 ~ 100) : ");
        String number = sc.next();
        return checkNumberRange(checkNumberType(number));
    }

    public int checkNumberRange(int number) {
        if (number < 1 || number >100) {
            System.out.println("[ERROR] 범위 내의 숫자를 입력하세요. ");
            return readNumber();
        } else {
            return number;
        }
    }

    public int checkNumberType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return readNumber();
        }
    }

    public String readString() {
        System.out.print("영어를 입력해주세요(A ~ z) : ");
        String alpha = sc.next();
        return validateAlpha(alpha);
    }

    public char readUpperAlpha() {
        System.out.print("영어를 입력해주세요(A ~ Z) : ");
        String alpha = sc.next();
        char UpperAlpha = validateAlpha(alpha).charAt(0);
        if(UpperAlpha < 'A' || validateAlpha(alpha).charAt(0) > 'Z'){
            System.out.println("[ERROR]: 범위 내의 알파벳을 입력하세요.");
            return readUpperAlpha();
        }
        return UpperAlpha;
    }

    public char readUpperAlpha(char c) {
        char start = (char)(c + 1);
        System.out.printf("영어를 입력해주세요(%c ~ Z) : ",start);
        String alpha = sc.next();
        char UpperAlpha = validateAlpha(alpha).charAt(0);
        if(UpperAlpha < 'A' || validateAlpha(alpha).charAt(0) > 'Z'){
            System.out.println("[ERROR]: 범위 내의 알파벳을 입력하세요.");
            return readUpperAlpha();
        }
        return UpperAlpha;
    }

    public String validateAlpha(String alpha) {
        if (alpha.length() >= 2) {
            System.out.println("[ERROR] 입력 문자의 길이는 1을 넘을 수 없습니다.");
            return readString();
        }
        for (char c : alpha.toCharArray()) {
            if (!Character.isAlphabetic(c)) {
                System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
                return readString();
            }
        }
        return alpha;
    }

    public int validateNumberType(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 입력 문자의 타입이 맞지 않습니다.");
            return versionInput();
        }
    }


}
