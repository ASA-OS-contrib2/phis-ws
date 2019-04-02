//**********************************************************************************************
//                                       ShootingConfigurationDTO.java 
//
// Author(s): Morgane Vidal
// PHIS-SILEX version 1.0
// Copyright © - INRA - 2017
// Creation date: December, 8 2017
// Contact: morgane.vidal@inra.fr, anne.tireau@inra.fr, pascal.neveu@inra.fr
// Last modification date:  December, 8 2017
// Subject: Represents the JSON submitted for the images shooting configuration 
//***********************************************************************************************
package opensilex.service.resources.dto;

import io.swagger.annotations.ApiModelProperty;
import opensilex.service.configuration.DateFormat;
import opensilex.service.documentation.DocumentationAnnotation;
import opensilex.service.resources.validation.interfaces.Required;
import opensilex.service.resources.dto.manager.AbstractVerifiedClass;
import opensilex.service.resources.validation.interfaces.Date;
import opensilex.service.resources.validation.interfaces.URL;
import opensilex.service.model.ShootingConfiguration;

/**
 * corresponds to the submitted JSON for an image shooting configuration
 * @author Morgane Vidal <morgane.vidal@inra.fr>
 */
public class ShootingConfigurationDTO extends AbstractVerifiedClass {
    
    //date of the shooting
    private String date;
    //position of the sensor
    private String position;
    //uri of the sensor used to take the images
    private String sensor;
    
    @Override
    public ShootingConfiguration createObjectFromDTO() {
        ShootingConfiguration shootingConfiguration = new ShootingConfiguration();
        shootingConfiguration.setDate(date);
        shootingConfiguration.setSensor(sensor);
        shootingConfiguration.setPosition(position);
        
        return shootingConfiguration;
    }
    
    @Date(DateFormat.YMDHMSZ)
    @Required
    @ApiModelProperty(example = DocumentationAnnotation.EXAMPLE_SHOOTING_CONFIGURATION_DATE)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @ApiModelProperty(example = DocumentationAnnotation.EXAMPLE_SHOOTING_CONFIGURATION_POSITION)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @URL
    @Required
    @ApiModelProperty(example = DocumentationAnnotation.EXAMPLE_SENSOR_URI)
    public String getSensor() {
        return sensor;
    }

    public void setSensor(String sensor) {
        this.sensor = sensor;
    }
}
