package basesconversor.factories.validators;

import basesconversor.contracts.IValidatorFactory;

public class BaseTenValidator implements IValidatorFactory {

    @Override
    public boolean isValid(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
