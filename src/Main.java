public class Main {

    public static void main(String [] args) {
        int d = 0;

        while (d != 10) {
            d += 1;
        }

        float x = d/10;
        
        System.out.println(x);

        /**
         * It never shows the following message, because the program never gets out of the while loop.
         * Due to the fact, the condition statement is always true. Because, float and double cannot accurately
         * represent the base 10 multiples. In other words, decimals, are not 100% accurately.
         * EXAMPLE: 0 + 0.1 = 0.1 ; 0.1 + 0.1 = 0.2; 0.2 + 0.1 = 0.300000000000000004 ; 0.300000000000000004 + 0.1 = 0.4
         * 0.4 + 0.1 = 0.5; 0.5 + 0.1 = 0.6; 0.6 + 0.1 = 0.7; 0.7 + 0.1 = 0.79999999999999;
         * 0.79999999999999 + 0.1 = 0.899999999999; 0.899999999999 + 0.1 = 0.99999999999999;
         *  0.99999999999999 + 0.1 = 1.099999999999999 that is why, when we check the argument it is true, because 1.0
         *  is not equal to 1.09999999. In order to fix that, i would use BigDecimal or directly work with integers.
         *  (Multiplying numbers by 10 times).
         */
        System.out.println("d is 1");
    }
}




