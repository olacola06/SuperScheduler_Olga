package models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString

public class Direction {
    String from;
    String to;
    String numberKm;
    String cost;
    String currency;
}
