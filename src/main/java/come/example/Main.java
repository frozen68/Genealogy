package come.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie den Familiennamen ein:");
        String familyName = scanner.nextLine();

        System.out.println("Bitte geben Sie den Namen des Vaters ein:");
        String fatherName = scanner.nextLine();
        System.out.println("Bitte geben Sie das Alter des Vaters ein:");
        int fatherAge = Integer.parseInt(scanner.nextLine());

        System.out.println("Bitte geben Sie den Namen der Mutter ein:");
        String motherName = scanner.nextLine();
        System.out.println("Bitte geben Sie das Alter der Mutter ein:");
        int motherAge = Integer.parseInt(scanner.nextLine());

        Person father = new Person(fatherName, fatherAge);
        Person mother = new Person(motherName, motherAge);

        System.out.println("Wie viele Kinder hat " + motherName + " und " + fatherName + "?");
        int numOfChildren = Integer.parseInt(scanner.nextLine());

        Person root = new Person("Root", 0);

        for (int i = 0; i < numOfChildren; i++) {
            System.out.println("Bitte geben Sie den Namen des Kindes " + (i + 1) + " ein:");
            String childName = scanner.nextLine();
            System.out.println("Bitte geben Sie das Alter des Kindes " + (i + 1) + " ein:");
            int childAge = Integer.parseInt(scanner.nextLine());
            Person child = new Person(childName, childAge);

            System.out.println("Bitte wählen Sie den Familienstand des Kindes " + childName + ":");
            System.out.println("1. ledig");
            System.out.println("2. verheiratet");
            System.out.println("3. geschieden");
            System.out.println("4. verlobt");
            System.out.println("5. verwitwet");
            int maritalStatusOption = Integer.parseInt(scanner.nextLine());

            switch (maritalStatusOption) {
                case 1:
                    if (childAge > 18) {
                        System.out.println("Wie viele Kinder hat " + childName + "?");
                        int numOfGrandChildren = Integer.parseInt(scanner.nextLine());

                        for (int j = 0; j < numOfGrandChildren; j++) {
                            System.out.println("Bitte geben Sie den Namen des Kindes " + (j + 1) + " von " + childName + " ein:");
                            String grandChildName = scanner.nextLine();
                            System.out.println("Bitte geben Sie das Alter des Kindes " + (j + 1) + " von " + childName + " ein:");
                            int grandChildAge = Integer.parseInt(scanner.nextLine());
                            Person grandChild = new Person(grandChildName, grandChildAge);
                            child.addChild(grandChild);
                        }
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.println("Wie viele Kinder hat " + childName + "?");
                    int numOfGrandChildren = Integer.parseInt(scanner.nextLine());

                    for (int j = 0; j < numOfGrandChildren; j++) {
                        System.out.println("Bitte geben Sie den Namen des Kindes " + (j + 1) + " von " + childName + " ein:");
                        String grandChildName = scanner.nextLine();
                        System.out.println("Bitte geben Sie das Alter des Kindes " + (j + 1) + " von " + childName + " ein:");
                        int grandChildAge = Integer.parseInt(scanner.nextLine());
                        Person grandChild = new Person(grandChildName, grandChildAge);
                        child.addChild(grandChild);
                    }

                    if (maritalStatusOption != 1) {
                        System.out.println("Mit wem ist das Kind " + childName + " " +
                                (maritalStatusOption == 2 ? "verheiratet" :
                                        maritalStatusOption == 3 ? "geschieden" : "verlobt") + "?");
                        String spouseName = scanner.nextLine();
                        System.out.println("Wie alt ist der Ehepartner?");
                        int spouseAge = Integer.parseInt(scanner.nextLine());
                        child.setMarried(true, spouseName, spouseAge);
                    }
                    break;
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
                    i--; // Um die Schleife erneut auszuführen und die korrekte Option auszuwählen
                    break;
            }

            root.addChild(child);
        }

        Stammbaum stammbaum = new Stammbaum(familyName, root, mother, father);
        System.out.println("\nStammbaum:");
        stammbaum.printStammbaum();

        scanner.close();
    }
}