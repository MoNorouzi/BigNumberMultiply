import java.math.BigInteger;
import java.util.Scanner;
public class BigInt {
   private String d;

   public BigInt() {
   }
   public String getD() {
      return d;
   }
   public void setD(String d) {
      this.d = d;
   }

   public String getInput() {
      Scanner scanner = new Scanner(System.in);
      return scanner.nextLine();
   }

   public void multiply(BigInt right) {
      String digit, digit1, answer = "0",answerF="0",res1,res2;
      int n, n1, total, rightDigit, leftDigit = 0,res;
      for (int j = (right.d).length()-1 ; j >= -1; j--) {
         String answer1 = Reverse(answer);
         for(int x=0;x<(((right.d).length())-j)-2;x++){
            answer1+="0";//as we going on another digit in number add 0 to it (first = zero , second=2,...)
         }
         answerF = plus(answer1, answerF);//plus every 2 row and keep in answerF to plus with next row
         if (j== - 1)//if there is no digit left
         {
            System.out.println("Result:   ");
            System.out.println(answerF);
            Multi.repeat();//go back and repeat
         }
         answer = "";
         leftDigit=0;//reset leftdigit for 2nd digit of first number(going next row)
         for (int i = d.length() - 1; i >= 0; i--) {

             digit = String.valueOf((right.d).charAt(j));

            digit1 = String.valueOf((this.d).charAt(i));
            n = Integer.parseInt(digit);
            n1 = Integer.parseInt(digit1);
            total = n * n1;
            if (total > 9) {//if we have 2 digit number that is from multiply just write right digit and keep leftdigit for next round
               total+=leftDigit;
               rightDigit = total % 10;
               if(i==0) {//if it is the last digit reverse it because we want to reverse it all in the above
                  res = total ;
                  if (res > 9) {
                     res1 = String.valueOf(res);
                     res2 = Reverse(res1);

                     answer += res2;

                  } else
                     answer += String.valueOf(rightDigit);
               }
               else
                  answer += String.valueOf(rightDigit);

               leftDigit = (total - rightDigit) / 10;

            } else {
               if(i==0) {
                  res = total + leftDigit;
                  if (res > 9) {
                     res1 = String.valueOf(res);
                     res2 = Reverse(res1);

                     answer += res2;

                  } else
                     answer += String.valueOf(total + leftDigit);
               }
               else
                  answer += String.valueOf(total + leftDigit);
               leftDigit = 0;
            }
         }
      }

   }
   private String Reverse(String str) {
      String reverse = "";
      for (int i = str.length() - 1; i >= 0; i--) {
         reverse = reverse + str.charAt(i);
      }
      return reverse;
   }
   private String plus(String answer1, String answer2) {
      BigInteger big = new BigInteger(answer1);
      BigInteger big1 = new BigInteger(answer2);
return big.add(big1).toString();
   }
}
//at the end I have to say I accept it is not the best code and it is not organized and it should be shorter but
//its my best effort and it took a lot of time ,Norouzi M
