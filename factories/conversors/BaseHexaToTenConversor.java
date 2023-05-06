package basesconversor.factories.conversors;

import java.math.BigInteger;

public class BaseHexaToTenConversor extends AbstractToTenConversor {

    public BaseHexaToTenConversor() {
        baseValue = BigInteger.valueOf(16L);
    }

}
