package day;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
class MapEntry {
    String location;
    String left;
    String right;
}
