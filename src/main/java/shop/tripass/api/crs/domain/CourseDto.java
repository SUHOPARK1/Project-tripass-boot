package shop.tripass.api.crs.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class CourseDto {
    private long crsNum;
    private String crsName;
    private List<Long> places;
    private long num;

    @Builder
    public CourseDto(String crsName, List<Long> places, long num) {
        this.crsName = crsName;
        this.places = places;
        this.num = num;
    }
}