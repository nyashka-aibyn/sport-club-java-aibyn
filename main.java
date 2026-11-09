
import java.util.*;

public class Main {

    // 1. SPORTSMAN CLASS
    static class Athlete {
        private int id;
        private String name;
        private int age;
        private String sport;
        private double rating;

        public Athlete(int id, String name, int age,
                       String sport, double rating) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.sport = sport;
            this.rating = rating;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getSport() { return sport; }
        public double getRating() { return rating; }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Athlete)) return false;

            Athlete a = (Athlete) obj;
            return id == a.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "ID: " + id +
                    ", Аты: " + name +
                    ", Жасы: " + age +
                    ", Спорт: " + sport +
                    ", Рейтинг: " + rating;
        }
    }

    // 2. TEAM CLASS
    static class Team {
        private int id;
        private String name;
        private String sport;

        public Team(int id, String name, String sport) {
            this.id = id;
            this.name = name;
            this.sport = sport;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Команда: " + name +
                    ", Спорт: " + sport;
        }
    }

    // 3. COACH CLASS
    static class Coach {
        private int id;
        private String name;
        private String specialization;

        public Coach(int id, String name, String specialization) {
            this.id = id;
            this.name = name;
            this.specialization = specialization;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Жаттықтырушы: " + name +
                    ", Мамандығы: " + specialization;
        }
    }

    // 4. COMPETITION CLASS
    static class Competition {
        private int id;
        private String name;
        private String location;

        public Competition(int id, String name, String location) {
            this.id = id;
            this.name = name;
            this.location = location;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Жарыс: " + name +
                    ", Орны: " + location;
        }
    }

    // MAIN METHOD
    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       SPORT CLUB SYSTEM");
        System.out.println("================================");


        // 1. ARRAYLIST
        System.out.println("\n--- 1. ARRAYLIST ---");

        List<Athlete> athletes = new ArrayList<>();

        athletes.add(new Athlete(1, "Айбын", 20, "Boxing", 95));
        athletes.add(new Athlete(2, "Абзал", 19, "Football", 85));
        athletes.add(new Athlete(3, "Али", 21, "Wrestling", 90));
        athletes.add(new Athlete(4, "Данияр", 20, "Swimming", 80));

        // For loop
        System.out.println("\nFor loop:");
        for (int i = 0; i < athletes.size(); i++) {
            System.out.println(athletes.get(i));
        }

        // For-each
        System.out.println("\nFor-each:");
        for (Athlete a : athletes) {
            System.out.println(a.getName());
        }

        // Iterator
        System.out.println("\nIterator:");
        Iterator<Athlete> iterator = athletes.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Get
        System.out.println("\nБірінші спортшы:");
        System.out.println(athletes.get(0));

        // Set - update
        athletes.set(1,
                new Athlete(2, "Абзал", 19, "Boxing", 92));

        System.out.println("\nӨзгертілген спортшы:");
        System.out.println(athletes.get(1));

        // Remove
        athletes.remove(3);

        System.out.println("\nСпортшылар саны: " + athletes.size());


        // 2. LINKEDLIST
        System.out.println("\n--- 2. LINKEDLIST ---");

        LinkedList<String> history = new LinkedList<>();

        history.addFirst("Клубқа тіркелді");
        history.addLast("Жаттығуға қатысты");
        history.addLast("Жарысқа қатысты");
        history.addFirst("Профиль құрылды");

        System.out.println("Тарих: " + history);
        System.out.println("Бірінші әрекет: " + history.getFirst());

        history.removeFirst();

        System.out.println("Жаңартылған тарих: " + history);


        // 3. HASHSET
        System.out.println("\n--- 3. HASHSET ---");

        Set<Athlete> uniqueAthletes = new HashSet<>();

        uniqueAthletes.add(
                new Athlete(1, "Айбын", 20, "Boxing", 95));

        uniqueAthletes.add(
                new Athlete(2, "Абзал", 19, "Football", 85));

        // Duplicate ID
        uniqueAthletes.add(
                new Athlete(1, "Айбын басқа", 22, "Boxing", 90));

        System.out.println("Бірегей спортшылар саны: "
                + uniqueAthletes.size());

        System.out.println("ID 1 бар ма: "
                + uniqueAthletes.contains(
                new Athlete(1, "Айбын", 20, "Boxing", 95)));

        uniqueAthletes.remove(
                new Athlete(2, "Абзал", 19, "Football", 85));

        System.out.println("Жойғаннан кейін: "
                + uniqueAthletes.size());


        // 4. HASHMAP
        System.out.println("\n--- 4. HASHMAP ---");

        Map<Integer, Athlete> athleteMap = new HashMap<>();

        for (Athlete a : athletes) {
            athleteMap.put(a.getId(), a);
        }

        // Put
        athleteMap.put(5,
                new Athlete(5, "Ернар", 22, "Boxing", 88));

        // Get
        System.out.println("ID 1: " + athleteMap.get(1));

        // Update existing key
        athleteMap.put(1,
                new Athlete(1, "Айбын", 20, "Boxing", 99));

        System.out.println("Жаңартылған ID 1: "
                + athleteMap.get(1));

        // ContainsKey
        System.out.println("ID 5 бар ма: "
                + athleteMap.containsKey(5));

        // Remove
        athleteMap.remove(5);

        // EntrySet
        System.out.println("\nБарлық спортшылар:");

        for (Map.Entry<Integer, Athlete> entry :
                athleteMap.entrySet()) {

            System.out.println("Кілт: " + entry.getKey()
                    + " | Мәні: " + entry.getValue());
        }


        // 5. SORTING
        System.out.println("\n--- 5. SORTING ---");

        athletes.sort(
                Comparator.comparingDouble(Athlete::getRating)
                        .reversed()
        );

        for (Athlete a : athletes) {
            System.out.println(a);
        }


        // 6. SEARCH
        System.out.println("\n--- 6. SEARCH ---");

        String searchName = "Айбын";
        boolean found = false;

        for (Athlete a : athletes) {
            if (a.getName().equals(searchName)) {
                System.out.println("Табылды: " + a);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Спортшы табылмады!");
        }


        // 7. FILTER
        System.out.println("\n--- 7. FILTER ---");

        for (Athlete a : athletes) {
            if (a.getRating() >= 90) {
                System.out.println("Жоғары рейтинг: " + a);
            }
        }


        // 8. TEAMS
        System.out.println("\n--- 8. TEAMS ---");

        List<Team> teams = new ArrayList<>();

        teams.add(new Team(1, "Almaty Tigers", "Boxing"));
        teams.add(new Team(2, "Almaty Stars", "Football"));

        for (Team t : teams) {
            System.out.println(t);
        }


        // 9. COACHES
        System.out.println("\n--- 9. COACHES ---");

        List<Coach> coaches = new ArrayList<>();

        coaches.add(new Coach(1, "Марат", "Boxing"));
        coaches.add(new Coach(2, "Арман", "Football"));

        for (Coach c : coaches) {
            System.out.println(c);
        }


        // 10. COMPETITIONS
        System.out.println("\n--- 10. COMPETITIONS ---");

        List<Competition> competitions = new ArrayList<>();

        competitions.add(
                new Competition(1, "Қазақстан чемпионаты", "Алматы"));

        competitions.add(
                new Competition(2, "Әлем кубогы", "Астана"));

        for (Competition c : competitions) {
            System.out.println(c);
        }


        System.out.println("\n================================");
        System.out.println("       PROGRAM FINISHED");
        System.out.println("================================");
    }
}
