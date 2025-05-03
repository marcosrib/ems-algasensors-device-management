package com.algaworks.algasensors.device.management.api.config.jpa;

import io.hypersistence.tsid.TSID;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TSIDToLongJPAAttributeConvert implements AttributeConverter<TSID, Long> {
    @Override
    public Long convertToDatabaseColumn(TSID tsid) {
        return tsid.toLong();
    }

    @Override
    public TSID convertToEntityAttribute(Long aLong) {
        return TSID.from(aLong);
    }
}
