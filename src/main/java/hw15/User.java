package hw15;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
 class User {
     private String name;
     private int score = 0;

     public User(String name) {
          this.name = name;
     }
}
