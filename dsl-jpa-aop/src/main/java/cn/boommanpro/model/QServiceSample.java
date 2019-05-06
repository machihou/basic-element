package cn.boommanpro.model;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;

import javax.annotation.Generated;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;


/**
 * 生成方式详见Readme.md
 * QServiceSample is a Querydsl query type for ServiceSample
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServiceSample extends EntityPathBase<ServiceSample> {

    private static final long serialVersionUID = 160073971L;

    public static final QServiceSample serviceSample = new QServiceSample("serviceSample");

    public final StringPath creator = createString("creator");

    public final NumberPath<Integer> department = createNumber("department", Integer.class);

    public final NumberPath<Integer> serviceId = createNumber("serviceId", Integer.class);

    public final StringPath status = createString("status");

    public final StringPath supervisor = createString("supervisor");

    public QServiceSample(String variable) {
        super(ServiceSample.class, forVariable(variable));
    }

    public QServiceSample(Path<? extends ServiceSample> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServiceSample(PathMetadata metadata) {
        super(ServiceSample.class, metadata);
    }

}

