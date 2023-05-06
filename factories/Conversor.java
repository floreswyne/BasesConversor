package basesconversor.factories;

import java.util.Optional;

import basesconversor.annotations.Logger;
import basesconversor.contracts.IConversorFactory;
import basesconversor.contracts.IValidatorFactory;
import basesconversor.enums.BasesOrders;
import basesconversor.factories.conversors.ConverterFactory;
import basesconversor.factories.validators.ValidatorFactory;

@Logger
public class Conversor {

    private BasesOrders basesOrders;

    public Conversor(BasesOrders basesOrders) {
        this.basesOrders = basesOrders;
    }

    public Optional<String> convert(String value) {
        if (!validate(value)) {
            Logger.out.info("Value isn't valid.");
            return Optional.empty();
        }

        ConverterFactory factory = new ConverterFactory();
        Optional<IConversorFactory> converter = factory.getConverter(basesOrders);

        if (converter.isEmpty()) {
            Logger.out.info("Value cannot be converted.");
            return Optional.empty();
        }

        String resultValue = converter.get().convert(value);

        showResult(value, resultValue);

        return Optional.ofNullable(resultValue);
    }

    private boolean validate(String value) {
        ValidatorFactory factory = new ValidatorFactory();
        Optional<IValidatorFactory> validator = factory.getValidator(basesOrders.getConverter());

        if (validator.isEmpty()) {
            Logger.out.info("Value cannot be converted.");
            return false;
        }

        return validator.get().isValid(value);
    }

    private void showResult(String initialValue, String resultValue) {
        StringBuilder result = new StringBuilder();

        result.append(basesOrders.getConverter().toString());
        result.append("(\"" + initialValue + "\")");
        result.append(" == ");
        result.append(basesOrders.getConverted().toString());
        result.append("(\"" + resultValue + "\")");

        String message = result.toString();

        Logger.out.info(message);
    }

}
