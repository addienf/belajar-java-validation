package pzn.validation;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pzn.validation.entity.*;

import java.lang.classfile.constantpool.ConstantPoolException;

public class ValueExtractorTest extends AbstractValidatorTest{
    @Test
    void create() {
        SampleData sampleData = new SampleData();
        sampleData.setData(new Data<>());

        validate(sampleData);
    }

    @Test
    void entry() {
        SampleEntry sampleEntry = new SampleEntry();
        sampleEntry.setEntry(new Entry<>());

        validate(sampleEntry);
    }

    @Test
    void dataInt() {
        SimpleDataInteger sample = new SimpleDataInteger();

        sample.setDataInteger(new DataInteger());
        sample.getDataInteger().setData(1);

        validate(sample);
    }

    @Test
    void exception() {
        Assertions.assertThrows(ConstraintViolationException.class, () -> {
            Person person = new Person();
            validate(person);
        });
    }
}
