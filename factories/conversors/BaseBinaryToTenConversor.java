package basesconversor.factories.conversors;

import java.math.BigInteger;

public class BaseBinaryToTenConversor extends AbstractToTenConversor {

    public BaseBinaryToTenConversor() {
        baseValue = BigInteger.valueOf(2L);
    }

}
