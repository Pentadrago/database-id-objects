package com.github.pentadrago.repositorytest.games;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.descriptor.java.LongJavaType;
import org.hibernate.type.descriptor.jdbc.BigIntJdbcType;
import org.hibernate.type.internal.NamedBasicTypeImpl;

import java.util.Properties;

public class GameIdGenerator extends SequenceStyleGenerator {

    @Override
    public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
        NamedBasicTypeImpl<Long> longType = new NamedBasicTypeImpl<>(LongJavaType.INSTANCE, BigIntJdbcType.INSTANCE, "long");
        super.configure(longType, parameters, serviceRegistry);
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return new GameId((Long) super.generate(session, object));
    }
}
