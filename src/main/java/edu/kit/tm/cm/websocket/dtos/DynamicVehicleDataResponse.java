package edu.kit.tm.cm.websocket.dtos;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("DynamicVehicleData")
public class DynamicVehicleDataResponse {


    @ApiModelProperty(position = 1, required = true)
    private CoordinateResponse position;

    @ApiModelProperty(position = 2, required = true)
    private float enginePressure;

    @ApiModelProperty(position = 3, required = true)
    private float tirePressure;

    @ApiModelProperty(position = 4, required = true)
    private float tankLevel;

    @ApiModelProperty(position = 5, required = true)
    private String timestamp;

    public DynamicVehicleDataResponse(CoordinateResponse position, float enginePressure, float tirePressure, float tankLevel, String timestamp) {
        this.position = position;
        this.enginePressure = enginePressure;
        this.tirePressure = tirePressure;
        this.tankLevel = tankLevel;
        this.timestamp = timestamp;
    }
}

