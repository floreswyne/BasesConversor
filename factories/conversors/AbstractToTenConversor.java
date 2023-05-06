package basesconversor.factories.conversors;

import java.math.BigInteger;
import java.util.Optional;

import basesconversor.contracts.IConversorFactory;
import basesconversor.utils.AlphaNumericUtil;

public abstract class AbstractToTenConversor implements IConversorFactory {

    protected BigInteger baseValue;

    @Override
    public String convert(String value) {
        BigInteger count = BigInteger.valueOf(1L);
        BigInteger valueBaseTen = BigInteger.valueOf(0L);

        value = new StringBuilder(value).reverse().toString();

        for (Character character : value.toCharArray()) {
            Optional<String> numericValue = AlphaNumericUtil.fromAlphaNumericToNumeric(character.toString());

            if (numericValue.isEmpty()) {
                return "";
            }

            BigInteger characterValue = new BigInteger(numericValue.get());
            valueBaseTen = valueBaseTen.add(characterValue.multiply(count));
            count = count.multiply(baseValue);
        }

        return valueBaseTen.toString();
    }

}
