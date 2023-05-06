package basesconversor.factories.conversors;

import java.math.BigInteger;

public class BaseTenToFourConversor extends AbstractBaseTenToConversor {

    public BaseTenToFourConversor() {
        baseValue = BigInteger.valueOf(4L);
    }

}
