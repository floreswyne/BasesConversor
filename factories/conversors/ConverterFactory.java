package basesconversor.factories.conversors;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import basesconversor.contracts.IConversorFactory;
import basesconversor.enums.BasesOrders;

public class ConverterFactory {

    private Map<BasesOrders, IConversorFactory> converters;
    private BaseBinaryToTenConversor baseBinaryToTenConversor;
    private BaseFourToTenConversor baseFourToTenConversor;
    private BaseOctalToTenConversor baseOctalToTenConversor;
    private BaseHexaToTenConversor baseHexaToTenConversor;
    private BaseThirtyTwoToTenConversor baseThirtyTwoToTenConversor;
    private BaseTenToBinaryConversor baseTenToBinaryConversor;
    private BaseTenToFourConversor baseTenToFourConversor;
    private BaseTenToOctalConversor baseTenToOctalConversor;
    private BaseTenToHexaConversor baseTenToHexaConversor;
    private BaseTenToThirtyTwoConversor baseTenToThirtyTwoConversor;

    public ConverterFactory() {
        this.converters = new EnumMap<>(BasesOrders.class);

        this.baseBinaryToTenConversor = new BaseBinaryToTenConversor();
        this.baseFourToTenConversor = new BaseFourToTenConversor();
        this.baseOctalToTenConversor = new BaseOctalToTenConversor();
        this.baseHexaToTenConversor = new BaseHexaToTenConversor();
        this.baseThirtyTwoToTenConversor = new BaseThirtyTwoToTenConversor();
        this.baseTenToBinaryConversor = new BaseTenToBinaryConversor();
        this.baseTenToFourConversor = new BaseTenToFourConversor();
        this.baseTenToOctalConversor = new BaseTenToOctalConversor();
        this.baseTenToHexaConversor = new BaseTenToHexaConversor();
        this.baseTenToThirtyTwoConversor = new BaseTenToThirtyTwoConversor();

        this.converters.put(BasesOrders.BINARY_TO_TEN, baseBinaryToTenConversor);
        this.converters.put(BasesOrders.FOUR_TO_TEN, baseFourToTenConversor);
        this.converters.put(BasesOrders.OCTAL_TO_TEN, baseOctalToTenConversor);
        this.converters.put(BasesOrders.HEXA_TO_TEN, baseHexaToTenConversor);
        this.converters.put(BasesOrders.THIRTY_TWO_TO_TEN, baseThirtyTwoToTenConversor);
        this.converters.put(BasesOrders.TEN_TO_BINARY, baseTenToBinaryConversor);
        this.converters.put(BasesOrders.TEN_TO_FOUR, baseTenToFourConversor);
        this.converters.put(BasesOrders.TEN_TO_OCTAL, baseTenToOctalConversor);
        this.converters.put(BasesOrders.TEN_TO_HEXA, baseTenToHexaConversor);
        this.converters.put(BasesOrders.TEN_TO_THIRTY_TWO, baseTenToThirtyTwoConversor);
    }

    public ConverterFactory(
            BaseBinaryToTenConversor baseBinaryToTenConversor,
            BaseFourToTenConversor baseFourToTenConversor,
            BaseOctalToTenConversor baseOctalToTenConversor,
            BaseTenToBinaryConversor baseTenToBinaryConversor,
            BaseTenToFourConversor baseTenToFourConversor,
            BaseTenToOctalConversor baseTenToOctalConversor) {
        this.converters = new EnumMap<>(BasesOrders.class);

        this.converters.put(BasesOrders.BINARY_TO_TEN, baseBinaryToTenConversor);
        this.converters.put(BasesOrders.FOUR_TO_TEN, baseFourToTenConversor);
        this.converters.put(BasesOrders.OCTAL_TO_TEN, baseOctalToTenConversor);
        this.converters.put(BasesOrders.HEXA_TO_TEN, baseHexaToTenConversor);
        this.converters.put(BasesOrders.THIRTY_TWO_TO_TEN, baseThirtyTwoToTenConversor);
        this.converters.put(BasesOrders.TEN_TO_BINARY, baseTenToBinaryConversor);
        this.converters.put(BasesOrders.TEN_TO_FOUR, baseTenToFourConversor);
        this.converters.put(BasesOrders.TEN_TO_OCTAL, baseTenToOctalConversor);
        this.converters.put(BasesOrders.TEN_TO_HEXA, baseTenToHexaConversor);
        this.converters.put(BasesOrders.TEN_TO_THIRTY_TWO, baseTenToThirtyTwoConversor);
    }

    public Optional<IConversorFactory> getConverter(BasesOrders basesOrders) {
        return Optional.ofNullable(converters.get(basesOrders));
    }

}
