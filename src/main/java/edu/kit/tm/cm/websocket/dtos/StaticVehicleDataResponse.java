package edu.kit.tm.cm.websocket.dtos;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("StaticVehicleData")
public class StaticVehicleDataResponse {

    @ApiModelProperty(position = 1, required = true)
    private String vin;

    @ApiModelProperty(position = 2, required = true)
    private String model;

    @ApiModelProperty(position = 3, required = true)
    private String tag;

    @ApiModelProperty(position = 4, required = true)
    private int seats;

    @ApiModelProperty(position = 5, required = true)
    private int tankSize;

    @ApiModelProperty(position = 6, required = true)
    private VehicleType vehicleType;

    @ApiModelProperty(position = 7, required = true)
    private String endpointIdentifier;


    public StaticVehicleDataResponse(String vin, String model, String tag, int seats, int tankSize, VehicleType vehicleType, String endpointIdentifier) {
        this.vin = vin;
        this.model = model;
        this.tag = tag;
        this.seats = seats;
        this.tankSize = tankSize;
        this.vehicleType = vehicleType;
        this.endpointIdentifier = endpointIdentifier;
    }
}

