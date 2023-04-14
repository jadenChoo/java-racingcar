package CarRacing.view;

import java.util.Scanner;

import exception.NegativeInputException;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String[] getCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String numberStr = SCANNER.nextLine();

        try {
            return getNameOfCars(numberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCars();
        }
    }

    public static int getNumberOfTry() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String numberStr = SCANNER.nextLine();

        try {
            return getNumber(numberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getNumberOfTry();
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static int getNumber(String numberStr) {
        if (!isNumeric(numberStr)) {
            throw new IllegalArgumentException("숫자로만 입력해주세요!");
        }

        int numberOfCar = Integer.parseInt(numberStr);
        if (numberOfCar < 0 ) {
            throw new NegativeInputException("양의 숫자만 입력해주세요!");
        }

        return numberOfCar;
    }

    public static String[] getNameOfCars(String numberStr) {
        if (numberStr.isEmpty()) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다!");
        }

        String[] names = numberStr.split(",");

        for (String name : names) {
            checkNameLength(name);
        }

        return names;
    }

    private static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다!");
        }
    }
}
