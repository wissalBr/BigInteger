import java.math.BigInteger;
import java.util.Random;

public class BigInt {
	
	private BigInteger BigI ;
	
	BigInt() {
		
		BigInteger maxLimit = new BigInteger("50000000000000000000000000000000000000");
	    BigInteger minLimit = new BigInteger("25000000000000000000000000000");
	    BigInteger bigInteger = maxLimit.subtract(minLimit);
	    Random randNum = new Random();
	    int len = maxLimit.bitLength();
	    BigInteger Big = new BigInteger(len, randNum);
	    if (Big.compareTo(minLimit) < 0)
	    	Big = Big.add(minLimit);
	    if (Big.compareTo(bigInteger) >= 0)
	        Big = Big.mod(bigInteger).add(minLimit);
	   this.BigI= Big;
	}

	BigInteger getBigI() {
		return this.BigI;
	}
	
}
