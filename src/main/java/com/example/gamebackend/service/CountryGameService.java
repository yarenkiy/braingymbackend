package com.example.gamebackend.service;


import com.example.gamebackend.model.Country;
import com.example.gamebackend.model.Question;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.*;

@Service
public class CountryGameService {

    private Map<String, List<Country>> countriesByLanguage = new HashMap<>();
    private final Random random = new Random();

    @PostConstruct
    public void initializeCountries() {
        System.out.println("Ülke verileri yükleniyor...");
        countriesByLanguage.put("tr", getTurkishCountries());
        countriesByLanguage.put("en", getEnglishCountries());
        System.out.println("Toplam TR: " + countriesByLanguage.get("tr").size() + ", EN: " + countriesByLanguage.get("en").size() + " ülke yüklendi.");
    }

    private List<Country> getTurkishCountries() {
        List<Country> list = new ArrayList<>();

        // Türkiye ve çevre ülkeler
        list.add(new Country("Türkiye", "Ankara", Arrays.asList("İstanbul", "İzmir", "Antalya"), "🇹🇷", "TR"));
        list.add(new Country("Yunanistan", "Atina", Arrays.asList("Selanik", "Pire"), "🇬🇷", "GR"));
        list.add(new Country("Bulgaristan", "Sofya", Arrays.asList("Plovdiv", "Varna"), "🇧🇬", "BG"));
        list.add(new Country("Gürcistan", "Tiflis", Arrays.asList("Batum", "Kutaisi"), "🇬🇪", "GE"));
        list.add(new Country("İran", "Tahran", Arrays.asList("İsfahan", "Şiraz"), "🇮🇷", "IR"));
        list.add(new Country("Irak", "Bağdat", Arrays.asList("Basra", "Musul"), "🇮🇶", "IQ"));
        list.add(new Country("Suriye", "Şam", Arrays.asList("Halep", "Humus"), "🇸🇾", "SY"));

        // Avrupa ülkeleri
        list.add(new Country("Almanya", "Berlin", Arrays.asList("Münih", "Hamburg", "Frankfurt"), "🇩🇪", "D"));
        list.add(new Country("Fransa", "Paris", Arrays.asList("Marsilya", "Lyon", "Nice"), "🇫🇷", "F"));
        list.add(new Country("İtalya", "Roma", Arrays.asList("Milano", "Napoli", "Venedik"), "🇮🇹", "I"));
        list.add(new Country("İspanya", "Madrid", Arrays.asList("Barselona", "Sevilla", "Valencia"), "🇪🇸", "E"));
        list.add(new Country("İngiltere", "Londra", Arrays.asList("Manchester", "Liverpool", "Birmingham"), "🇬🇧", "GB"));
        list.add(new Country("Hollanda", "Amsterdam", Arrays.asList("Rotterdam", "Lahey"), "🇳🇱", "NL"));
        list.add(new Country("Belçika", "Brüksel", Arrays.asList("Anvers", "Gent"), "🇧🇪", "B"));
        list.add(new Country("Avusturya", "Viyana", Arrays.asList("Salzburg", "Graz"), "🇦🇹", "A"));
        list.add(new Country("İsviçre", "Bern", Arrays.asList("Zürih", "Cenevre"), "🇨🇭", "CH"));
        list.add(new Country("Portekiz", "Lizbon", Arrays.asList("Porto", "Braga"), "🇵🇹", "P"));
        list.add(new Country("Polonya", "Varşova", Arrays.asList("Krakow", "Gdansk"), "🇵🇱", "PL"));
        list.add(new Country("Çek Cumhuriyeti", "Prag", Arrays.asList("Brno", "Ostrava"), "🇨🇿", "CZ"));
        list.add(new Country("Macaristan", "Budapeşte", Arrays.asList("Debrecen", "Szeged"), "🇭🇺", "H"));
        list.add(new Country("Romanya", "Bükreş", Arrays.asList("Kluş", "Timişoara"), "🇷🇴", "RO"));
        list.add(new Country("İsveç", "Stockholm", Arrays.asList("Göteborg", "Malmö"), "🇸🇪", "S"));
        list.add(new Country("Norveç", "Oslo", Arrays.asList("Bergen", "Trondheim"), "🇳🇴", "N"));
        list.add(new Country("Danimarka", "Kopenhag", Arrays.asList("Aarhus", "Odense"), "🇩🇰", "DK"));
        list.add(new Country("Finlandiya", "Helsinki", Arrays.asList("Tampere", "Turku"), "🇫🇮", "FIN"));

        // Asya ülkeleri
        list.add(new Country("Japonya", "Tokyo", Arrays.asList("Osaka", "Kyoto", "Yokohama"), "🇯🇵", "J"));
        list.add(new Country("Çin", "Pekin", Arrays.asList("Şangay", "Guangzhou", "Şenzen"), "🇨🇳", "CN"));
        list.add(new Country("Güney Kore", "Seul", Arrays.asList("Busan", "Incheon"), "🇰🇷", "ROK"));
        list.add(new Country("Hindistan", "Yeni Delhi", Arrays.asList("Mumbai", "Kalküta", "Bangalore"), "🇮🇳", "IND"));
        list.add(new Country("Tayland", "Bangkok", Arrays.asList("Phuket", "Chiang Mai"), "🇹🇭", "T"));
        list.add(new Country("Endonezya", "Jakarta", Arrays.asList("Surabaya", "Bali"), "🇮🇩", "RI"));
        list.add(new Country("Malezya", "Kuala Lumpur", Arrays.asList("Penang", "Johor Bahru"), "🇲🇾", "MAL"));
        list.add(new Country("Singapur", "Singapur", Arrays.asList("Singapur"), "🇸🇬", "SGP"));
        list.add(new Country("Vietnam", "Hanoi", Arrays.asList("Ho Chi Minh", "Da Nang"), "🇻🇳", "VN"));
        list.add(new Country("Pakistan", "İslamabad", Arrays.asList("Karaçi", "Lahor"), "🇵🇰", "PK"));
        list.add(new Country("Bangladeş", "Dakka", Arrays.asList("Chittagong", "Khulna"), "🇧🇩", "BD"));

        // Amerika kıtası
        list.add(new Country("Amerika Birleşik Devletleri", "Washington D.C.", Arrays.asList("New York", "Los Angeles", "Chicago"), "🇺🇸", "USA"));
        list.add(new Country("Kanada", "Ottawa", Arrays.asList("Toronto", "Montreal", "Vancouver"), "🇨🇦", "CDN"));
        list.add(new Country("Meksika", "Mexico City", Arrays.asList("Guadalajara", "Monterrey"), "🇲🇽", "MEX"));
        list.add(new Country("Brezilya", "Brasília", Arrays.asList("Rio de Janeiro", "São Paulo"), "🇧🇷", "BR"));
        list.add(new Country("Arjantin", "Buenos Aires", Arrays.asList("Córdoba", "Rosario"), "🇦🇷", "RA"));
        list.add(new Country("Şili", "Santiago", Arrays.asList("Valparaíso", "Concepción"), "🇨🇱", "RCH"));
        list.add(new Country("Peru", "Lima", Arrays.asList("Cusco", "Arequipa"), "🇵🇪", "PE"));
        list.add(new Country("Kolombiya", "Bogota", Arrays.asList("Medellín", "Cali"), "🇨🇴", "CO"));

        // Okyanusya
        list.add(new Country("Avustralya", "Canberra", Arrays.asList("Sydney", "Melbourne", "Brisbane"), "🇦🇺", "AUS"));
        list.add(new Country("Yeni Zelanda", "Wellington", Arrays.asList("Auckland", "Christchurch"), "🇳🇿", "NZ"));

        // Afrika
        list.add(new Country("Güney Afrika", "Pretoria", Arrays.asList("Johannesburg", "Cape Town"), "🇿🇦", "ZA"));
        list.add(new Country("Mısır", "Kahire", Arrays.asList("İskenderiye", "Giza"), "🇪🇬", "ET"));
        list.add(new Country("Nijerya", "Abuja", Arrays.asList("Lagos", "Kano"), "🇳🇬", "WAN"));
        list.add(new Country("Kenya", "Nairobi", Arrays.asList("Mombasa", "Kisumu"), "🇰🇪", "EAK"));
        list.add(new Country("Fas", "Rabat", Arrays.asList("Kazablanka", "Marakeş"), "🇲🇦", "MA"));

        // Orta Doğu
        list.add(new Country("Suudi Arabistan", "Riyad", Arrays.asList("Cidde", "Mekke"), "🇸🇦", "KSA"));
        list.add(new Country("Birleşik Arap Emirlikleri", "Abu Dabi", Arrays.asList("Dubai", "Şarja"), "🇦🇪", "UAE"));
        list.add(new Country("Katar", "Doha", Arrays.asList("Al Wakrah", "Al Rayyan"), "🇶🇦", "Q"));
        list.add(new Country("İsrail", "Kudüs", Arrays.asList("Tel Aviv", "Hayfa"), "🇮🇱", "IL"));
        list.add(new Country("Ürdün", "Amman", Arrays.asList("Zarqa", "Irbid"), "🇯🇴", "JOR"));

        // Rusya ve komşuları
        list.add(new Country("Rusya", "Moskova", Arrays.asList("St. Petersburg", "Novosibirsk"), "🇷🇺", "RUS"));
        list.add(new Country("Ukrayna", "Kiev", Arrays.asList("Kharkiv", "Odessa"), "🇺🇦", "UA"));
        list.add(new Country("Kazakistan", "Astana", Arrays.asList("Almatı", "Şımkent"), "🇰🇿", "KZ"));

        return list;
    }

    private List<Country> getEnglishCountries() {
        List<Country> list = new ArrayList<>();

        // Turkey and neighbors
        list.add(new Country("Turkey", "Ankara", Arrays.asList("Istanbul", "Izmir", "Antalya"), "🇹🇷", "TR"));
        list.add(new Country("Greece", "Athens", Arrays.asList("Thessaloniki", "Piraeus"), "🇬🇷", "GR"));
        list.add(new Country("Bulgaria", "Sofia", Arrays.asList("Plovdiv", "Varna"), "🇧🇬", "BG"));
        list.add(new Country("Georgia", "Tbilisi", Arrays.asList("Batumi", "Kutaisi"), "🇬🇪", "GE"));
        list.add(new Country("Iran", "Tehran", Arrays.asList("Isfahan", "Shiraz"), "🇮🇷", "IR"));
        list.add(new Country("Iraq", "Baghdad", Arrays.asList("Basra", "Mosul"), "🇮🇶", "IQ"));
        list.add(new Country("Syria", "Damascus", Arrays.asList("Aleppo", "Homs"), "🇸🇾", "SY"));

        // European countries
        list.add(new Country("Germany", "Berlin", Arrays.asList("Munich", "Hamburg", "Frankfurt"), "🇩🇪", "D"));
        list.add(new Country("France", "Paris", Arrays.asList("Marseille", "Lyon", "Nice"), "🇫🇷", "F"));
        list.add(new Country("Italy", "Rome", Arrays.asList("Milan", "Naples", "Venice"), "🇮🇹", "I"));
        list.add(new Country("Spain", "Madrid", Arrays.asList("Barcelona", "Seville", "Valencia"), "🇪🇸", "E"));
        list.add(new Country("United Kingdom", "London", Arrays.asList("Manchester", "Liverpool", "Birmingham"), "🇬🇧", "GB"));
        list.add(new Country("Netherlands", "Amsterdam", Arrays.asList("Rotterdam", "The Hague"), "🇳🇱", "NL"));
        list.add(new Country("Belgium", "Brussels", Arrays.asList("Antwerp", "Ghent"), "🇧🇪", "B"));
        list.add(new Country("Austria", "Vienna", Arrays.asList("Salzburg", "Graz"), "🇦🇹", "A"));
        list.add(new Country("Switzerland", "Bern", Arrays.asList("Zurich", "Geneva"), "🇨🇭", "CH"));
        list.add(new Country("Portugal", "Lisbon", Arrays.asList("Porto", "Braga"), "🇵🇹", "P"));
        list.add(new Country("Poland", "Warsaw", Arrays.asList("Krakow", "Gdansk"), "🇵🇱", "PL"));
        list.add(new Country("Czech Republic", "Prague", Arrays.asList("Brno", "Ostrava"), "🇨🇿", "CZ"));
        list.add(new Country("Hungary", "Budapest", Arrays.asList("Debrecen", "Szeged"), "🇭🇺", "H"));
        list.add(new Country("Romania", "Bucharest", Arrays.asList("Cluj", "Timisoara"), "🇷🇴", "RO"));
        list.add(new Country("Sweden", "Stockholm", Arrays.asList("Gothenburg", "Malmö"), "🇸🇪", "S"));
        list.add(new Country("Norway", "Oslo", Arrays.asList("Bergen", "Trondheim"), "🇳🇴", "N"));
        list.add(new Country("Denmark", "Copenhagen", Arrays.asList("Aarhus", "Odense"), "🇩🇰", "DK"));
        list.add(new Country("Finland", "Helsinki", Arrays.asList("Tampere", "Turku"), "🇫🇮", "FIN"));

        // Asian countries
        list.add(new Country("Japan", "Tokyo", Arrays.asList("Osaka", "Kyoto", "Yokohama"), "🇯🇵", "J"));
        list.add(new Country("China", "Beijing", Arrays.asList("Shanghai", "Guangzhou", "Shenzhen"), "🇨🇳", "CN"));
        list.add(new Country("South Korea", "Seoul", Arrays.asList("Busan", "Incheon"), "🇰🇷", "ROK"));
        list.add(new Country("India", "New Delhi", Arrays.asList("Mumbai", "Kolkata", "Bangalore"), "🇮🇳", "IND"));
        list.add(new Country("Thailand", "Bangkok", Arrays.asList("Phuket", "Chiang Mai"), "🇹🇭", "T"));
        list.add(new Country("Indonesia", "Jakarta", Arrays.asList("Surabaya", "Bali"), "🇮🇩", "RI"));
        list.add(new Country("Malaysia", "Kuala Lumpur", Arrays.asList("Penang", "Johor Bahru"), "🇲🇾", "MAL"));
        list.add(new Country("Singapore", "Singapore", Arrays.asList("Singapore"), "🇸🇬", "SGP"));
        list.add(new Country("Vietnam", "Hanoi", Arrays.asList("Ho Chi Minh", "Da Nang"), "🇻🇳", "VN"));
        list.add(new Country("Pakistan", "Islamabad", Arrays.asList("Karachi", "Lahore"), "🇵🇰", "PK"));
        list.add(new Country("Bangladesh", "Dhaka", Arrays.asList("Chittagong", "Khulna"), "🇧🇩", "BD"));

        // Americas
        list.add(new Country("United States", "Washington D.C.", Arrays.asList("New York", "Los Angeles", "Chicago"), "🇺🇸", "USA"));
        list.add(new Country("Canada", "Ottawa", Arrays.asList("Toronto", "Montreal", "Vancouver"), "🇨🇦", "CDN"));
        list.add(new Country("Mexico", "Mexico City", Arrays.asList("Guadalajara", "Monterrey"), "🇲🇽", "MEX"));
        list.add(new Country("Brazil", "Brasília", Arrays.asList("Rio de Janeiro", "São Paulo"), "🇧🇷", "BR"));
        list.add(new Country("Argentina", "Buenos Aires", Arrays.asList("Córdoba", "Rosario"), "🇦🇷", "RA"));
        list.add(new Country("Chile", "Santiago", Arrays.asList("Valparaíso", "Concepción"), "🇨🇱", "RCH"));
        list.add(new Country("Peru", "Lima", Arrays.asList("Cusco", "Arequipa"), "🇵🇪", "PE"));
        list.add(new Country("Colombia", "Bogota", Arrays.asList("Medellín", "Cali"), "🇨🇴", "CO"));

        // Oceania
        list.add(new Country("Australia", "Canberra", Arrays.asList("Sydney", "Melbourne", "Brisbane"), "🇦🇺", "AUS"));
        list.add(new Country("New Zealand", "Wellington", Arrays.asList("Auckland", "Christchurch"), "🇳🇿", "NZ"));

        // Africa
        list.add(new Country("South Africa", "Pretoria", Arrays.asList("Johannesburg", "Cape Town"), "🇿🇦", "ZA"));
        list.add(new Country("Egypt", "Cairo", Arrays.asList("Alexandria", "Giza"), "🇪🇬", "ET"));
        list.add(new Country("Nigeria", "Abuja", Arrays.asList("Lagos", "Kano"), "🇳🇬", "WAN"));
        list.add(new Country("Kenya", "Nairobi", Arrays.asList("Mombasa", "Kisumu"), "🇰🇪", "EAK"));
        list.add(new Country("Morocco", "Rabat", Arrays.asList("Casablanca", "Marrakech"), "🇲🇦", "MA"));

        // Middle East
        list.add(new Country("Saudi Arabia", "Riyadh", Arrays.asList("Jeddah", "Mecca"), "🇸🇦", "KSA"));
        list.add(new Country("United Arab Emirates", "Abu Dhabi", Arrays.asList("Dubai", "Sharjah"), "🇦🇪", "UAE"));
        list.add(new Country("Qatar", "Doha", Arrays.asList("Al Wakrah", "Al Rayyan"), "🇶🇦", "Q"));
        list.add(new Country("Israel", "Jerusalem", Arrays.asList("Tel Aviv", "Haifa"), "🇮🇱", "IL"));
        list.add(new Country("Jordan", "Amman", Arrays.asList("Zarqa", "Irbid"), "🇯🇴", "JOR"));

        // Russia and neighbors
        list.add(new Country("Russia", "Moscow", Arrays.asList("St. Petersburg", "Novosibirsk"), "🇷🇺", "RUS"));
        list.add(new Country("Ukraine", "Kyiv", Arrays.asList("Kharkiv", "Odessa"), "🇺🇦", "UA"));
        list.add(new Country("Kazakhstan", "Astana", Arrays.asList("Almaty", "Shymkent"), "🇰🇿", "KZ"));

        return list;
    }

    public List<Question> getPlateCodeQuestions(int count, String language) {
        List<Country> countries = countriesByLanguage.getOrDefault(language, countriesByLanguage.get("tr"));
        List<Question> questions = new ArrayList<>();
        List<Country> shuffled = new ArrayList<>(countries);
        Collections.shuffle(shuffled);

        for (int i = 0; i < Math.min(count, shuffled.size()); i++) {
            Country correct = shuffled.get(i);
            List<String> options = generateStringOptions(correct.getName(), shuffled);

            Question q = new Question();
            q.setQuestion(correct.getPlateCode());
            q.setOptions(options);
            q.setCorrectAnswer(correct.getName());
            q.setType("plate");

            questions.add(q);
        }

        return questions;
    }

    public List<Question> generateCapitalQuestions(int count, String language) {
        List<Country> countries = countriesByLanguage.getOrDefault(language, countriesByLanguage.get("tr"));
        List<Question> questions = new ArrayList<>();
        List<Country> shuffled = new ArrayList<>(countries);
        Collections.shuffle(shuffled);

        for (int i = 0; i < Math.min(count, shuffled.size()); i++) {
            Country correct = shuffled.get(i);
            List<String> options = generateOptions(correct.getCapital(), shuffled.stream()
                    .map(Country::getCapital).toList());

            Question q = new Question();
            q.setQuestion(correct.getName());
            q.setOptions(options);
            q.setCorrectAnswer(correct.getCapital());
            q.setType("capital");

            questions.add(q);
        }

        return questions;
    }

    public List<Question> generateCityQuestions(int count, String language) {
        List<Country> countries = countriesByLanguage.getOrDefault(language, countriesByLanguage.get("tr"));
        List<Question> questions = new ArrayList<>();
        List<Country> shuffled = new ArrayList<>(countries);
        Collections.shuffle(shuffled);

        for (int i = 0; i < Math.min(count, shuffled.size()); i++) {
            Country country = shuffled.get(i);
            List<String> cities = country.getCities();

            if (!cities.isEmpty()) {
                Collections.shuffle(cities);
                String randomCity = cities.get(0);

                List<String> options = generateStringOptions(country.getName(), shuffled);

                Question q = new Question();
                q.setQuestion(randomCity);
                q.setOptions(options);
                q.setCorrectAnswer(country.getName());
                q.setType("city");

                questions.add(q);
            }
        }

        return questions;
    }

    private List<String> generateStringOptions(String correct, List<Country> allCountries) {
        List<String> options = new ArrayList<>();
        options.add(correct);

        List<String> others = allCountries.stream()
                .map(Country::getName)
                .filter(name -> !name.equals(correct))
                .toList();

        List<String> othersList = new ArrayList<>(others);
        Collections.shuffle(othersList);
        options.addAll(othersList.subList(0, Math.min(2, othersList.size())));

        Collections.shuffle(options);
        return options;
    }

    private List<String> generateOptions(String correct, List<String> allOptions) {
        List<String> options = new ArrayList<>();
        options.add(correct);

        List<String> others = allOptions.stream()
                .filter(opt -> !opt.equals(correct))
                .toList();

        List<String> othersList = new ArrayList<>(others);
        Collections.shuffle(othersList);
        options.addAll(othersList.subList(0, Math.min(2, othersList.size())));

        Collections.shuffle(options);
        return options;
    }
}