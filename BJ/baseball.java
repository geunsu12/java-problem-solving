package BJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class baseball {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("정답을 입력하세요. : ");
        int answer = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrAnswer = new ArrayList<>(Arrays.asList(0,0,0));
        ArrayList<Integer> arrUser = new ArrayList<>(Arrays.asList(0,0,0));

        for(int i=2;i>=0;i--) {
            arrAnswer.set(i,answer%10);
            answer /= 10;
        }
        System.out.println("숫자 야구 게임을 시작합니다.");

        while(true){
            int userAnswer = Integer.parseInt(br.readLine());
            
            for(int i=2;i>=0;i--) {
                arrUser.set(i,userAnswer%10);
                userAnswer /=10;
            }
            
            int strike = 0;
            int ball = 0;

            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if (arrAnswer.get(i) == arrUser.get(j)) {
                        if(i==j) strike += 1;
                        else ball += 1;
                        break;
                    }
                }
            }

            if(strike == 0 && ball > 0) System.out.println(ball + "볼");
            if(strike > 0 && ball == 0) System.out.println(strike + "스트라이크");
            if(strike >0 && ball >0) System.out.println(ball + "볼" + strike + "스트라이크");
            if(strike == 0 && ball == 0) System.out.println("낫싱");
            if(strike == 3) break;
            
        }
        

    }
    


}
