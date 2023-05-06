package basesconversor.factories.validators;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import basesconversor.contracts.IValidatorFactory;
import basesconversor.enums.Bases;

public class ValidatorFactory {

    private Map<Bases, IValidatorFactory> validators;
    private BaseBinaryValidator baseBinaryValidator;
    private BaseFourValidator baseFourValidator;
    private BaseOctalValidator baseOctalValidator;
    private BaseTenValidator baseTenValidator;
    private BaseHexaValidator baseHexaValidator;
    private BaseThirtyTwoValidator baseThirtyTwoValidator;

    public ValidatorFactory() {
        this.validators = new EnumMap<>(Bases.class);

        this.baseBinaryValidator = new BaseBinaryValidator();
        this.baseFourValidator = new BaseFourValidator();
        this.baseOctalValidator = new BaseOctalValidator();
        this.baseTenValidator = new BaseTenValidator();
        this.baseHexaValidator = new BaseHexaValidator();
        this.baseThirtyTwoValidator = new BaseThirtyTwoValidator();

        this.validators.put(Bases.BINARY, baseBinaryValidator);
        this.validators.put(Bases.FOUR, baseFourValidator);
        this.validators.put(Bases.OCTAL, baseOctalValidator);
        this.validators.put(Bases.TEN, baseTenValidator);
        this.validators.put(Bases.HEXA, baseHexaValidator);
        this.validators.put(Bases.THIRTY_TWO, baseThirtyTwoValidator);
    }

    public ValidatorFactory(
            BaseBinaryValidator baseBinaryValidator,
            BaseFourValidator baseFourValidator,
            BaseOctalValidator baseOctalValidator,
            BaseTenValidator baseTenValidator,
            BaseHexaValidator baseHexaValidator,
            BaseThirtyTwoValidator baseThirtyTwoValidator) {
        this.validators = new EnumMap<>(Bases.class);

        this.validators.put(Bases.BINARY, baseBinaryValidator);
        this.validators.put(Bases.FOUR, baseFourValidator);
        this.validators.put(Bases.OCTAL, baseOctalValidator);
        this.validators.put(Bases.TEN, baseTenValidator);
        this.validators.put(Bases.HEXA, baseHexaValidator);
        this.validators.put(Bases.THIRTY_TWO, baseThirtyTwoValidator);
    }

    public Optional<IValidatorFactory> getValidator(Bases base) {
        return Optional.ofNullable(validators.get(base));
    }

}
