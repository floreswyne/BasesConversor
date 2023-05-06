package basesconversor.factories.conversors;

import java.math.BigInteger;
import java.util.Optional;

import basesconversor.contracts.IConversorFactory;
import basesconversor.utils.AlphaNumericUtil;

public abstract class AbstractBaseTenToConversor implements IConversorFactory {

    protected BigInteger baseValue;

    @Override
    public String convert(String value) {
        StringBuilder result;

        BigInteger valueBaseTen = new BigInteger(value);

        if (valueBaseTen.compareTo(baseValue) < 0) {
            Optional<String> tempValue = AlphaNumericUtil.fromNumericToAlphaNumeric(valueBaseTen.toString());

            if (tempValue.isEmpty()) {
                return "";
            }

            return tempValue.get();
        }

        BigInteger rest = valueBaseTen.remainder(baseValue);
        BigInteger division = valueBaseTen.divide(baseValue);

        if (baseValue.compareTo(BigInteger.TEN) < 0) {
            result = new StringBuilder(convert(division.toString()) + rest.toString());

            return result.toString();
        }

        Optional<String> restAlphaNumeric = AlphaNumericUtil.fromNumericToAlphaNumeric(rest.toString());

        String restValue = restAlphaNumeric.isPresent() ? restAlphaNumeric.get() : "";
        String divisionValue = division.toString();

        if (restValue.equals("")) {
            return "";
        }

        result = new StringBuilder(convert(divisionValue) + restValue);

        return result.toString();
    }

    public String oldConvert(String value) {
        StringBuilder result;

        BigInteger valueBaseTen;

        try {
            valueBaseTen = new BigInteger(value);
        } catch (NumberFormatException e) {
            Optional<String> alphaNumericValue = AlphaNumericUtil.fromAlphaNumericToNumeric(value);

            valueBaseTen = alphaNumericValue.isPresent()
                    ? new BigInteger(alphaNumericValue.get())
                    : BigInteger.ZERO;
        }

        if (valueBaseTen.compareTo(baseValue) < 0) {
            Optional<String> temp = AlphaNumericUtil.fromNumericToAlphaNumeric(valueBaseTen.toString());

            if (temp.isEmpty()) {
                return "";
            }

            return temp.get();
        }

        BigInteger rest = valueBaseTen.remainder(baseValue);
        BigInteger division = valueBaseTen.divide(baseValue);

        if (baseValue.compareTo(BigInteger.TEN) < 0) {
            result = new StringBuilder(convert(division.toString()) + rest.toString());

            return result.toString();
        }

        Optional<String> restAlphaNumeric = AlphaNumericUtil.fromNumericToAlphaNumeric(rest.toString());
        Optional<String> divisionAlphaNumeric = AlphaNumericUtil.fromNumericToAlphaNumeric(division.toString());

        String divisionValue = divisionAlphaNumeric.isPresent() ? divisionAlphaNumeric.get() : division.toString();
        String restValue = restAlphaNumeric.isPresent() ? restAlphaNumeric.get() : "";

        if (restValue.equals("")) {
            return "";
        }

        result = new StringBuilder(convert(divisionValue) + restValue);

        return result.toString();
    }

}
