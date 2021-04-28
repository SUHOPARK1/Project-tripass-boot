package shop.tripass.api.crs.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.tripass.api.pce.domain.PlaceDto;

import java.util.List;

@Getter
@NoArgsConstructor
public class CourseResponseDto {
    private long crsNum;
    private String crsName;
    private List<PlaceDto> places;
    private List<Double> distances;

    @Builder
    public CourseResponseDto(long crsNum,String crsName,List<PlaceDto> places,List<Double> distances){
        this.crsNum = crsNum;
        this.crsName = crsName;
        this.places = places;
        this.distances = distances;
    }
}