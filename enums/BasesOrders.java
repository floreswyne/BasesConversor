package basesconversor.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BasesOrders {
    BINARY_TO_TEN(Bases.BINARY, Bases.TEN),
    FOUR_TO_TEN(Bases.FOUR, Bases.TEN),
    OCTAL_TO_TEN(Bases.OCTAL, Bases.TEN),
    HEXA_TO_TEN(Bases.HEXA, Bases.TEN),
    THIRTY_TWO_TO_TEN(Bases.THIRTY_TWO, Bases.TEN),
    TEN_TO_BINARY(Bases.TEN, Bases.BINARY),
    TEN_TO_FOUR(Bases.TEN, Bases.FOUR),
    TEN_TO_OCTAL(Bases.TEN, Bases.OCTAL),
    TEN_TO_HEXA(Bases.TEN, Bases.HEXA),
    TEN_TO_THIRTY_TWO(Bases.TEN, Bases.THIRTY_TWO);

    private Bases converter;
    private Bases converted;

    BasesOrders(Bases converter, Bases converted) {
        this.converter = converter;
        this.converted = converted;
    }

    public Bases getConverter() {
        return this.converter;
    }

    public Bases getConverted() {
        return this.converted;
    }

    public static Optional<BasesOrders> findByBases(Bases converter, Bases converted) {
        return Arrays.asList(values()).stream()
                .filter(item -> item.converter.equals(converter)
                        && item.converted.equals(converted))
                .findFirst();
    }

}
