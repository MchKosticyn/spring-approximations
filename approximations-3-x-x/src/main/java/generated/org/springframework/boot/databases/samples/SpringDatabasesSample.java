package generated.org.springframework.boot.databases.samples;

import generated.org.springframework.boot.databases.basetables.BaseTableManager;
import generated.org.springframework.boot.databases.basetables.NoIdTableManager;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.constraints.Digits;
import org.hibernate.validator.internal.constraintvalidators.bv.DigitsValidatorForCharSequence;
import org.hibernate.validator.internal.constraintvalidators.bv.DigitsValidatorForNumber;
import org.hibernate.validator.internal.constraintvalidators.bv.NotBlankValidator;
import org.hibernate.validator.internal.constraintvalidators.bv.number.sign.PositiveValidatorForInteger;
import org.hibernate.validator.internal.util.annotation.AnnotationDescriptor;
import org.hibernate.validator.internal.util.annotation.AnnotationFactory;

// Sample of generated SpringDatabases file
public class SpringDatabasesSample {
    public static EntityManager entityManager;

    public static BaseTableManager<FirstDataClass, Integer> _blank1 = new BaseTableManager<>(
            1,
            FirstDataClass.class,
            new Class<?>[]{ String.class, Integer.class },
            new ConstraintValidator<?, ?>[][]{
                    new ConstraintValidator<?, ?>[]{ new NotBlankValidator() },
                    new ConstraintValidator<?, ?>[]{
                            new PositiveValidatorForInteger(),
                            new DigitsValidatorForNumber()
                    }
            },
            "_blank1",
            true,
            true
    );

    public static BaseTableManager<SecondDataClass, Integer> _blank2 = new BaseTableManager<>(
            0,
            SecondDataClass.class,
            new Class<?>[0],
            new ConstraintValidator<?, ?>[0][],
            "_blank2",
            true,
            true
    );

    public static NoIdTableManager _blankAdd = new NoIdTableManager(Integer.class, Integer.class);

    // sample of validator generation
    static {
        AnnotationDescriptor.Builder<Digits> builder = new AnnotationDescriptor.Builder<>(Digits.class);
        builder.setAttribute("fraction", 0);
        builder.setAttribute("integer", 9);

        AnnotationDescriptor<Digits> descriptor = builder.build();
        Digits annotation = AnnotationFactory.create(descriptor);

        ConstraintValidator<Digits, ?> v = new DigitsValidatorForCharSequence();
        v.initialize(annotation);
    }
}