public class Main {
    public static void main(String[] args) {
        // Create a new Human instance
        Human person = new Human("John Doe", 30);

        // Using the getter methods
        System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());

        // Using the setter methods
        person.setName("Jane Doe");
        person.setAge(28);

        // Invoking the custom method
        person.talk("Hello, world!");

        person.talk("bow bow bow");

        Human alice = new Human("Alice", 25);
        Human bob = new Human("Bob", 30);

        alice.talk("Hello, I'm Alice!");
        bob.talk("Nice to meet you, Alice. I'm Bob.");

        alice.makeFriend(bob);
        alice.learn("The Earth is round.");
        alice.shareFact(bob);

        alice.setEmotion(Human.Emotion.HAPPY);
        bob.exercise(30);
        alice.eat("an apple");

        System.out.println(alice);
        System.out.println(bob);
    }

}
