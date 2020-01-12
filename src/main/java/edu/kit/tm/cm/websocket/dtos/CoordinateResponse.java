package edu.kit.tm.cm.websocket.dtos;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Coordinate")
public class CoordinateResponse {


    @ApiModelProperty(position = 1, required = true)
    private double latitude;

    @ApiModelProperty(position = 2, required = true)
    private double longitude;

    public CoordinateResponse(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
