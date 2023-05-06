package basesconversor.factories.conversors;

import java.math.BigInteger;

public class BaseOctalToTenConversor extends AbstractToTenConversor {

    public BaseOctalToTenConversor() {
        baseValue = BigInteger.valueOf(8L);
    }

}
