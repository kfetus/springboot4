package base.comm.dbio;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * 프로젝트용 임시 매퍼. mybaits 로딩시의 대상 annotation 
 * @author ojh
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ProjectMapper {

	String value() default "";

}
