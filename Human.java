import java.util.ArrayList;
import java.util.List;

public class Human {
    // Data members
    private String name;
    private int age;
    private double energy;
    private List<String> knowledge;
    private List<Human> friends;
    private Emotion currentEmotion;

    // Enum for emotions
    public enum Emotion {
        HAPPY, SAD, ANGRY, NEUTRAL
    }

    // Constructor
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.energy = 100.0;
        this.knowledge = new ArrayList<>();
        this.friends = new ArrayList<>();
        this.currentEmotion = Emotion.NEUTRAL;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getEnergy() {
        return energy;
    }

    public List<String> getKnowledge() {
        return new ArrayList<>(knowledge);
    }

    public List<Human> getFriends() {
        return new ArrayList<>(friends);
    }

    // Setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = (age > 0) ? age : 1; // Ensure the age is positive
    }

    // Action methods
    public void talk(String message) {
        System.out.println(name + " says: " + message);
        decreaseEnergy(5);
    }

    public void learn(String information) {
        knowledge.add(information);
        System.out.println(name + " learned: " + information);
        decreaseEnergy(10);
    }

    public void sleep(int hours) {
        System.out.println(name + " is sleeping for " + hours + " hours.");
        increaseEnergy(hours * 10);
    }

    public void eat(String food) {
        System.out.println(name + " is eating " + food);
        increaseEnergy(25);
    }

    public void exercise(int minutes) {
        System.out.println(name + " is exercising for " + minutes + " minutes.");
        decreaseEnergy(minutes / 2);
    }

    // Interaction methods
    public void makeFriend(Human other) {
        if (!friends.contains(other)) {
            friends.add(other);
            other.friends.add(this);
            System.out.println(name + " and " + other.getName() + " are now friends.");
        }
    }

    public void shareFact(Human other) {
        if (friends.contains(other) && !knowledge.isEmpty()) {
            String fact = knowledge.get((int) (Math.random() * knowledge.size()));
            System.out.println(name + " shares with " + other.getName() + ": " + fact);
            other.learn(fact);
        }
    }

    // Emotion methods
    public void setEmotion(Emotion emotion) {
        this.currentEmotion = emotion;
        System.out.println(name + " is feeling " + emotion);
    }

    public Emotion getCurrentEmotion() {
        return currentEmotion;
    }

    // Helper methods
    private void decreaseEnergy(double amount) {
        energy = Math.max(0, energy - amount);
    }

    private void increaseEnergy(double amount) {
        energy = Math.min(100, energy + amount);
    }

    // toString method for easy printing
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", energy=" + energy +
                ", emotion=" + currentEmotion +
                ", friends=" + friends.size() +
                ", knowledge=" + knowledge.size() +
                '}';
    }
}

