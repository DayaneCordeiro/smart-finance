package com.example.smartfinance.factory;

import com.example.smartfinance.core.exception.RecordFactoryException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.ObjectCreationException;
import org.jeasy.random.ObjenesisObjectFactory;
import org.jeasy.random.api.RandomizerContext;

import java.lang.reflect.Constructor;
import java.lang.reflect.RecordComponent;

@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class RecordFactory extends ObjenesisObjectFactory {

    private EasyRandom easyRandom;

    @Override
    public <T> T createInstance(Class<T> type, RandomizerContext context) {
        if (easyRandom == null) {
            final EasyRandomParameters parameters = context.getParameters();
            easyRandom = new EasyRandom(parameters);
        }

        if (type.isRecord()) {
            return createRandomRecord(type);
        }

        return super.createInstance(type, context);
    }

    private <T> T createRandomRecord(Class<T> recordType) {
        RecordComponent[] recordComponents = recordType.getRecordComponents();
        Object[] randomValues = new Object[recordComponents.length];

        for (int i = 0; i < recordComponents.length; i++) {
            randomValues[i] = easyRandom.nextObject(recordComponents[i].getType());
        }

        try {
            return getCanonicalConstructor(recordType).newInstance(randomValues);
        } catch (Exception e) {
            throw new ObjectCreationException("Unable to create a random instance of record type " + recordType, e);
        }
    }

    private <T> Constructor<T> getCanonicalConstructor(Class<T> recordType) {
        RecordComponent[] recordComponents = recordType.getRecordComponents();
        Class<?>[] componentTypes = new Class<?>[recordComponents.length];

        for (int i = 0; i < recordComponents.length; i++) {
            componentTypes[i] = recordComponents[i].getType();
        }

        try {
            return recordType.getDeclaredConstructor(componentTypes);
        } catch (NoSuchMethodException e) {
            throw new RecordFactoryException(e);
        }
    }
}
