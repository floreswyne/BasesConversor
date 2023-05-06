package basesconversor.utils;

import java.util.Map;
import java.util.Optional;

import abstractfactory.annotations.Logger;

@Logger
public class AlphaNumericUtil {

    private static final Map<String, String> alphaNumeric = Map.ofEntries(
            Map.entry("10", "A"),
            Map.entry("11", "B"),
            Map.entry("12", "C"),
            Map.entry("13", "D"),
            Map.entry("14", "E"),
            Map.entry("15", "F"),
            Map.entry("16", "G"),
            Map.entry("17", "H"),
            Map.entry("18", "I"),
            Map.entry("19", "J"),
            Map.entry("20", "K"),
            Map.entry("21", "L"),
            Map.entry("22", "M"),
            Map.entry("23", "N"),
            Map.entry("24", "O"),
            Map.entry("25", "P"),
            Map.entry("26", "Q"),
            Map.entry("27", "R"),
            Map.entry("28", "S"),
            Map.entry("29", "T"),
            Map.entry("30", "U"),
            Map.entry("31", "V"),
            Map.entry("32", "W"),
            Map.entry("33", "X"),
            Map.entry("34", "Y"),
            Map.entry("35", "Z"));

    private AlphaNumericUtil() {
    }

    public static Optional<String> fromAlphaNumericToNumeric(String value) {
        try {
            Integer numericValue = Integer.parseInt(value);

            if (numericValue >= 10) {
                return Optional.empty();
            }

            return Optional.ofNullable(value);
        } catch (NumberFormatException e) {
            if (!alphaNumeric.values().contains(value)) {
                return Optional.empty();
            }

            return findKeyByValue(value);
        } catch (ClassCastException | NullPointerException e) {
            return Optional.empty();
        }
    }

    public static Optional<String> fromNumericToAlphaNumeric(String value) {
        try {
            Integer numericValue = Integer.parseInt(value);

            if (numericValue < 10) {
                return Optional.ofNullable(value);
            }

            String alphaNumericValue = alphaNumeric.get(value);

            return Optional.ofNullable(alphaNumericValue);
        } catch (NumberFormatException | ClassCastException | NullPointerException e) {
            return Optional.empty();
        }
    }

    private static Optional<String> findKeyByValue(String value) {
        return alphaNumeric.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Map.Entry::getKey)
                .findFirst();
    }

}
