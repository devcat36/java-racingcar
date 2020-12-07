package racingcar.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    Scanner sc = new Scanner(System.in);
    public Map<Integer, String[]> inputRacingByName(){

        Map<Integer, String[]> map = new HashMap<>();

        String[] racer = getRacerNames();
        map.put(0, racer);

        String[] move = getNumberOfRacing();
        map.put(1, move);

        sc.close();
        
        return map;
    }
    public void validateNameLength(String[] racer){
        Stream.of(racer).forEach(s ->   {
            if (s.length() > 5){
                throw new IllegalArgumentException(s + "의 이름이 5글자 이상입니다.");
            }
        });
    }

    public String[] getRacerNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] racer = sc.nextLine().split(",");
        validateNameLength(racer);
        
        return racer;
    }

    public String[] getNumberOfRacing() {
        System.out.println("시도할 횟수는 몇회 인가요?");
        return sc.nextLine().split(",");
    }
    
}