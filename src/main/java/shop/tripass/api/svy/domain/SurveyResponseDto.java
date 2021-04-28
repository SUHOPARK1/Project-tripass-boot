package shop.tripass.api.svy.domain;

import shop.tripass.api.pce.domain.Place;
import shop.tripass.api.pce.domain.PlaceDto;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SurveyResponseDto {
    private PlaceDto place;
    private double score;

    @Builder
    public  SurveyResponseDto(Place place, double score){
        this.place = new PlaceDto(place);
        this.score = score;
    }
}
