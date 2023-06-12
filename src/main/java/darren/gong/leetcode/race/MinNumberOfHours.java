package darren.gong.leetcode.race;

public class MinNumberOfHours {
  public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
    int length = energy.length;
    int result = 0;
    for (int i = 0; i < length; i++) {
      if (initialEnergy <= energy[i]) {
        int nextEnergy = energy[i]+1;
        result += nextEnergy-initialEnergy;
        initialEnergy = nextEnergy;
      }
      if (initialExperience <= experience[i]) {
        int nextExperience = experience[i]+1;
        result += nextExperience-initialExperience;
        initialExperience = nextExperience;
      }
      initialEnergy -= energy[i];
      initialExperience += experience[i];
    }
    return result;
  }
}
