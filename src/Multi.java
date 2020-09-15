

import static java.lang.System.exit;
public class Multi  {
        public static void main(String[] args) {
repeat();
        }

    public static void repeat() {
        while (true) {
            System.out.println("Please Enter Your First Number to Multiply(0 to end):\n");
            BigInt d1 = new BigInt();
            BigInt d2 = new BigInt();
            d1.setD(d1.getInput());
            if(d1.getD().equals("0"))
                exit(0);
            System.out.println("Please Enter Your Second Number :");

            d2.setD(d2.getInput());
            d1.multiply(d2);

        }
    }
}


