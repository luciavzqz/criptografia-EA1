package core;

import java.math.BigInteger;

public class Prime {

    private int k = 0;
    private BigInteger m;
    private BigInteger n;
    private BigInteger a = new BigInteger("2");

    public Prime(BigInteger n) {
        this.n = n;
    }

    public boolean isPrime() {
        makeStep1();
        //we skip step 2 since its picking an a between 1 and n-1, we'll always pick a = 2.
        return makeStep3();
    }

    /*
    Step 1: n-1 = (2^k) * m
    search for k and m (both whole numbers)
    To find K we divide n-1 by 2^k until the result is not whole.
    Of course, as any power of two is even, we can divide n-1 by two until we find the number
     */

    private void makeStep1() {
        BigInteger nMinus1 = this.n.subtract(BigInteger.ONE);
        while(nMinus1.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            nMinus1 = nMinus1.divide(BigInteger.TWO);
            this.k ++;
        }
        //find m
        this.m = this.n.subtract(BigInteger.ONE).divide(BigInteger.TWO.pow(this.k));
        System.out.println("K is: " + this.k + " " + "And m is: " + this.m);
    }

    /*
    Step 3 is the tricky one. You want to evaluate b0 = (a^n) mod n. If b0 equals +1 or -1, then n is Prime (probably)!
    If b0 isn't equal to +1 or -1, then we test bn = (bn-1 ^ 2) mod n. If bn equals +1 -> it's composite 100%. If bn equals -1 -> is prime (probably).
    Remember that a mod being equal to -1, means that is also equal to n-1 (yea, do the math and you'll realize)
     */
    private boolean makeStep3() {
        BigInteger b0 = this.a.modPow(this.m, this.n);
        System.out.println(b0);
        BigInteger bnext;
        if(b0.equals(BigInteger.ONE) || b0.equals(new BigInteger("-1")) || b0.equals(this.n.subtract(BigInteger.ONE))) {
            return true;
        }

        for(int i = 0; i < k; i++) {
            bnext = b0.modPow(BigInteger.TWO, this.n);
            System.out.println(bnext);
            /*if(bnext.equals(BigInteger.ONE))
                return false;*/
            if(bnext.equals(n.subtract(BigInteger.ONE)))
                return true;
            b0 = bnext;
        }
        return false;
    }
}
