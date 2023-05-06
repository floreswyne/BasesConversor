package basesconversor.factories.validators;

import java.util.Optional;

import basesconversor.contracts.IValidatorFactory;
import basesconversor.utils.AlphaNumericUtil;

public class BaseThirtyTwoValidator implements IValidatorFactory {

    private static final Integer BASE_VALUE = 32;

    @Override
    public boolean isValid(String value) {
        try {
            Integer numericValue = Integer.parseInt(value);

            return numericValue.compareTo(BASE_VALUE) >= 0;
        } catch (NumberFormatException e) {
            String reverseValue = new StringBuilder(value).reverse().toString();

            for (Character character : reverseValue.toCharArray()) {
                Optional<String> alphaNumericValue = AlphaNumericUtil.fromAlphaNumericToNumeric(character.toString());

                if (alphaNumericValue.isEmpty()) {
                    return false;
                }
            }

            return true;
        }
    }

}
