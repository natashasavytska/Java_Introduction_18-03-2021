package hw15;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class User {
     String name;
     int score = 0;

     public User(String name) {
          this.name = name;
     }
}
