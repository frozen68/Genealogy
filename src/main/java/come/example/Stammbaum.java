package come.example;

public class Stammbaum {
    private Person root;
    private Person mother;
    private Person father;
    private String familyName;

    public Stammbaum(String familyName, Person root, Person mother, Person father) {
        this.familyName = familyName;
        this.root = root;
        this.mother = mother;
        this.father = father;
    }

    public void printStammbaum() {
        System.out.println("Stammbaum von Familie: " + familyName);
        System.out.println("Eltern: " + mother.getName() + " (" + mother.getAge() + ") & " + father.getName() + " (" + father.getAge() + ")");
        printStammbaum(root, 1);
    }

    private void printStammbaum(Person person, int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }
        sb.append(person.getName()).append(" (").append(person.getAge()).append(")");
        if (person.isMarried()) {
            sb.append(", verheiratet mit ").append(person.getSpouseName())
                    .append(" (").append(person.getSpouseAge()).append(")");
        }
        System.out.println(sb.toString());
        for (Person child : person.getChildren()) {
            printStammbaum(child, level + 1);
        }
    }
}