package co.mum.roommgt.model;
/**
 * Custom Annotation 
 * Updated: 01/19/2018
 * 
 * @version 1.0 18 March 2018
 * @author Joseph Kelly Tusoy
 */
import java.lang.annotation.Retention;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
public @interface Col {
	String name();
}



 