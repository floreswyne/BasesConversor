package basesconversor.factories.conversors;

import java.math.BigInteger;

public class BaseTenToBinaryConversor extends AbstractBaseTenToConversor {

    public BaseTenToBinaryConversor() {
        baseValue = BigInteger.valueOf(2L);
    }

}
