/*
 * Irene Feng Nov 2022
 * This is the class where we create the Quiz and run it. It has the main method.  
 */
import java.util.Scanner;

public class Quiz {
        static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) throws Exception {
                // Create Categories
                Category pop = new Category("Pop",
                                "You might be labeled as basic, but you know what you like and aren't afraid to show it! \nYou're friendly and outgoing, and love to stay on top of the latest trends.");
                Category country = new Category("Country", 
                                "You value tradition and have a strong sense of community, \nand who knows, you might even be a huge patriot!");
                Category hiphop = new Category("Hip-Hop",
                                "You cherish the relationships in your life and love to have fun with friends. \nYou're outgoing and confident, and love to express yourself through your style and creativity.");
                Category rock = new Category("Rock", 
                                "You might be a lone wolf, or you're heavily involved in your community. \nYou have a strong sense of individuality and aren't afraid to stand out from the crowd.");
                // Create Questions
                Question q1 = new Question("You're at a small café in the city. What will you get to drink?");
                // Attach Answers to Questions
                q1.possibleAnswers[0] = new Answer("Espresso", pop);
                q1.possibleAnswers[1] = new Answer("Peach Tea", country);
                q1.possibleAnswers[2] = new Answer("Cold Brew", hiphop);
                q1.possibleAnswers[3] = new Answer("Black Coffee", rock);

                Question q2 = new Question("You're at a karaoke bar and suddenly your friends want you to go up and sing! What will you do?");
                q2.possibleAnswers[0] = new Answer("Persuade a friend to join", hiphop);
                q2.possibleAnswers[1] = new Answer("Sing your heart out in front of the crowd", pop);
                q2.possibleAnswers[2] = new Answer("Be the instrumental", country);
                q2.possibleAnswers[3] = new Answer("Refuse the offer", rock);

                Question q3 = new Question("You have a day off... What will you do?");
                q3.possibleAnswers[0] = new Answer("Sleep in and play video games", rock);
                q3.possibleAnswers[1] = new Answer("Exercise", country);
                q3.possibleAnswers[2] = new Answer("Read a new book", pop);
                q3.possibleAnswers[3] = new Answer("Go out with friends", hiphop);

                Question q4 = new Question("What's your favorite subject");
                q4.possibleAnswers[0] = new Answer("History", country);
                q4.possibleAnswers[1] = new Answer("I don't care.", rock);
                q4.possibleAnswers[2] = new Answer("English", pop);
                q4.possibleAnswers[3] = new Answer("Music Theory", hiphop);

                Question q5 = new Question("Which instrument appeals to you most?");
                q5.possibleAnswers[0] = new Answer("Drums", rock);
                q5.possibleAnswers[1] = new Answer("Synth", hiphop);
                q5.possibleAnswers[2] = new Answer("Acoustic Guitar", country);
                q5.possibleAnswers[3] = new Answer("My voice is my instrument!", pop);

                Question q6 = new Question("You're inside a gas station store. What are you buying?");
                q6.possibleAnswers[0] = new Answer("Beef Jerky", country);
                q6.possibleAnswers[1] = new Answer("Monster Energy Drink", rock);
                q6.possibleAnswers[2] = new Answer("Flamin' Hot Cheetos", hiphop);
                q6.possibleAnswers[3] = new Answer("Dubai Chocolate", pop);

                Question q7 = new Question("Which shoes are you wearing?");
                q7.possibleAnswers[0] = new Answer("Knee High Converses", rock);
                q7.possibleAnswers[1] = new Answer("Golden Gooses", pop);
                q7.possibleAnswers[2] = new Answer("Timberland Boots", country);
                q7.possibleAnswers[3] = new Answer("Nike Air Jordans", hiphop);

                Question q8 = new Question("You have an urge to post your thoughts… Where?");
                q8.possibleAnswers[0] = new Answer("Tumblr", rock);
                q8.possibleAnswers[1] = new Answer("Snapchat", pop);
                q8.possibleAnswers[2] = new Answer("\"X\"", country);
                q8.possibleAnswers[3] = new Answer("Instagram", hiphop);

                Question q9 = new Question("You want to decorate your bag to let people know about you. Which keychain will you choose?");
                q9.possibleAnswers[0] = new Answer("Raccoon Tail", rock);
                q9.possibleAnswers[1] = new Answer("Labubu", pop);
                q9.possibleAnswers[2] = new Answer("A big ol' American Flag", country);
                q9.possibleAnswers[3] = new Answer("Microphone", hiphop);
        

                // For each question, ask, read input, store answer.
                gameIntro();
                Question[] qList = { q1, q2, q3, q4, q5, q6, q7, q8, q9 };
                for (Question q : qList) {
                        Category c = q.ask(sc);
                        c.points++;
                }
                // Get most common category from the questions asked
                // Return Category
                Category[] cList = { pop, country, hiphop, rock };
                // these need to be in the same order or the points will be incorrect!
                int index = getMostPopularCatIndex(cList);
                System.out.println("Your music genre is... " + cList[index].label + "! ");
                System.out.println(cList[index].description);

        }

        public static void gameIntro() {
                // requires 1 to keep going
                System.out.println("Which Music Genre Are You?");
                System.out.println("You get to choose numbers 1-4 for every question. Enter '1' to play!");
                int play = sc.nextInt();
                if (play != 1) {
                        System.out.println("Unidentifiable input. Please enter '1' to play");
                        gameIntro();
                }
        }

        // returns the index that is the max
        // the tie breaker is the first Category that has the count is the "max" :/ 
        public static int getMostPopularCatIndex(Category[] counts) {
                int maxCount = 0;
                int maxIndex = 0;
                for (int i = 0; i < counts.length; i++) {
                        if (counts[i].points > maxCount) {
                                maxCount = counts[i].points;
                                maxIndex = i;
                        }
                }
                return maxIndex;
        }
}
