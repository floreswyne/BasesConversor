package basesconversor.factories.validators;

import java.math.BigInteger;

import basesconversor.contracts.IValidatorFactory;

public class BaseBinaryValidator implements IValidatorFactory {

    private static final Integer BASE_VALUE = 2;

    @Override
    public boolean isValid(String value) {
        try {
            BigInteger numericValue = new BigInteger(value);

            value = new StringBuilder(numericValue.toString()).reverse().toString();

            for (Character character : value.toCharArray()) {
                if (Integer.parseInt(character.toString()) >= BASE_VALUE) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}