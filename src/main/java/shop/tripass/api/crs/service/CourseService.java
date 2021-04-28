package shop.tripass.api.crs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.tripass.api.cmm.util.LocationDistance;
import shop.tripass.api.crs.domain.Course;
import shop.tripass.api.crs.domain.CourseDto;
import shop.tripass.api.crs.domain.CourseResponseDto;
import shop.tripass.api.crs.repository.CourseRepository;
import shop.tripass.api.pce.domain.PlaceDto;
import shop.tripass.api.pce.repository.PlaceRepository;
import shop.tripass.api.usr.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;

    public int save(CourseDto c){
        return courseRepository.save(toEntity(c))!=null?1:0;
    }

    public List<CourseResponseDto> list(long id){
        List<Course> list = courseRepository.findAllByUser(userRepository.findById(id).orElse(null));
        List<CourseResponseDto> list2 = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            List<PlaceDto> placeDtos = getPlaceList(list.get(i).getPlaces());
            list2.add(CourseResponseDto.builder()
                    .crsNum(list.get(i).getCrsNum())
                    .crsName(list.get(i).getCrsName())
                    .places(placeDtos)
                    .distances(getDistanceList(placeDtos))
                    .build());
        }
        return list2;
    }
    public List<PlaceDto> getPlaceList(List<Long> places){
        List<PlaceDto> list = new ArrayList<>();
        for(long placeid:places){
            list.add(new PlaceDto(placeRepository.getOne(placeid)));
        }
        return list;
    }
    public List<Double> getDistanceList(List<PlaceDto> placeDtos){
        List<Double> list = new ArrayList<>();
        for(int i=0;i<placeDtos.size()-1;i++){
            list.add(LocationDistance.distance(
                    Double.parseDouble(placeDtos.get(i).getMapy()),
                    Double.parseDouble(placeDtos.get(i+1).getMapy()),
                    Double.parseDouble(placeDtos.get(i).getMapx()),
                    Double.parseDouble(placeDtos.get(i+1).getMapx())));
        }
        return list;
    }

    public Course toEntity(CourseDto c){
        return Course.builder()
                .crsName(c.getCrsName())
                .places(c.getPlaces())
                .user(userRepository.findById(c.getNum()).orElse(null)).build();
    }
}
