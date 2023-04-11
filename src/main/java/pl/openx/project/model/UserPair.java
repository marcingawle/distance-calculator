package pl.openx.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserPair {
   private User user1;
   private User user2;

   public double calculateDistance() {
      return user1.calculateDistance(user2);
   }

   public boolean pairEquals() {
      return user1.equals(user2);
   }
}