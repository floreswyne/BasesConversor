package basesconversor.factories.conversors;

import java.math.BigInteger;

public class BaseTenToHexaConversor extends AbstractBaseTenToConversor {

    public BaseTenToHexaConversor() {
        baseValue = BigInteger.valueOf(16L);
    }

}
