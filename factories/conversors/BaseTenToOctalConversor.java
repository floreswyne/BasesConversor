package basesconversor.factories.conversors;

import java.math.BigInteger;

public class BaseTenToOctalConversor extends AbstractBaseTenToConversor {

    public BaseTenToOctalConversor() {
        baseValue = BigInteger.valueOf(8L);
    }

}
