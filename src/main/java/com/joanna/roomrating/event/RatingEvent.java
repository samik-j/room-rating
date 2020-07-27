package com.joanna.roomrating.event;

import lombok.*;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RatingEvent {

    private Long roomId;

    private Double rating;
}
