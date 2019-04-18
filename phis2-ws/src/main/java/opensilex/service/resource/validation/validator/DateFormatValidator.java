//******************************************************************************
//                              DateFormatValidator.java
// SILEX-PHIS
// Copyright © INRA 2018
// Creation date: 21 June 2018
// Contact: arnaud.charleroy@inra.fr, morgane.vidal@inra.fr, anne.tireau@inra.fr, 
//          pascal.neveu@inra.fr
//******************************************************************************
package opensilex.service.resource.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.joda.time.DateTime;
import opensilex.service.configuration.DateFormat;
import opensilex.service.utils.date.Dates;
import opensilex.service.resource.validation.interfaces.Date;

/**
 * Used by DateFormat annotation to validate a string value with one or more 
 * date format. 
 * The value is considered valid as soon as it corresponds to one format.
 * {@code null} elements are considered valid.
 * @see Date
 * @see DateFormat
 * @author Arnaud Charleroy <arnaud.charleroy@inra.fr>, Morgane Vidal <morgane.vidal@inra.fr>
 */
public class DateFormatValidator implements ConstraintValidator<Date, String> {

    private DateFormat[] dateFormat;

    @Override
    public void initialize(Date constraintAnnotation) {
        this.dateFormat = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        boolean isValid = false;
        for (DateFormat dateCheckFormat : dateFormat) {
            if (validateDate(dateCheckFormat, value)) {
                isValid = true;
                break;
            }
        }
        
        return isValid;
    }

    public boolean validateDate(DateFormat pattern, String date) {
        DateTime stringToDateTime = Dates.stringToDateTimeWithGivenPattern(date, pattern.toString());
        return stringToDateTime != null;
    }
}