package shop.tripass.api.rev.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data @Component @Lazy
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private long revNum;
    private String revName;
    private String revStar;
    private String revContent;
    private String revDate;
    private long contentid;
    private long num;

    public ReviewDto(long revNum, String revName, String revStar,
                     String revContent, String revDate, long num) {
        super();
        this.revNum = revNum;
        this.revName = revName;
        this.revStar = revStar;
        this.revContent = revContent;
        this.revDate = revDate;
        this.num = num;
    }
}