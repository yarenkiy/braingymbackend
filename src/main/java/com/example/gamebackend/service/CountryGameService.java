package com.example.gamebackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.gamebackend.model.Country;
import com.example.gamebackend.model.Question;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.annotation.PostConstruct;
import java.util.*;

@Service
public class CountryGameService {

    private List<Country> countries = new ArrayList<>();
    private final Random random = new Random();
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void initializeCountries() {
        System.out.println("Ülke verileri yükleniyor...");
        countries = getFallbackCountries();
        System.out.println("Toplam " + countries.size() + " ülke yüklendi.");
    }

    private List<Country> getFallbackCountries() {
        List<Country> list = new ArrayList<>();

        // Türkiye ve çevre ülkeler
        list.add(new Country("Türkiye", "Ankara", new ArrayList<>(), "🇹🇷", "TR"));
        list.add(new Country("Yunanistan", "Atina", new ArrayList<>(), "🇬🇷", "GR"));
        list.add(new Country("Bulgaristan", "Sofya", new ArrayList<>(), "🇧🇬", "BG"));
        list.add(new Country("Gürcistan", "Tiflis", new ArrayList<>(), "🇬🇪", "GE"));
        list.add(new Country("İran", "Tahran", new ArrayList<>(), "🇮🇷", "IR"));
        list.add(new Country("Irak", "Bağdat", new ArrayList<>(), "🇮🇶", "IQ"));
        list.add(new Country("Suriye", "Şam", new ArrayList<>(), "🇸🇾", "SY"));

        // Avrupa ülkeleri
        list.add(new Country("Almanya", "Berlin", new ArrayList<>(), "🇩🇪", "D"));
        list.add(new Country("Fransa", "Paris", new ArrayList<>(), "🇫🇷", "F"));
        list.add(new Country("İtalya", "Roma", new ArrayList<>(), "🇮🇹", "I"));
        list.add(new Country("İspanya", "Madrid", new ArrayList<>(), "🇪🇸", "E"));
        list.add(new Country("İngiltere", "Londra", new ArrayList<>(), "🇬🇧", "GB"));
        list.add(new Country("Hollanda", "Amsterdam", new ArrayList<>(), "🇳🇱", "NL"));
        list.add(new Country("Belçika", "Brüksel", new ArrayList<>(), "🇧🇪", "B"));
        list.add(new Country("Avusturya", "Viyana", new ArrayList<>(), "🇦🇹", "A"));
        list.add(new Country("İsviçre", "Bern", new ArrayList<>(), "🇨🇭", "CH"));
        list.add(new Country("Portekiz", "Lizbon", new ArrayList<>(), "🇵🇹", "P"));
        list.add(new Country("Polonya", "Varşova", new ArrayList<>(), "🇵🇱", "PL"));
        list.add(new Country("Çek Cumhuriyeti", "Prag", new ArrayList<>(), "🇨🇿", "CZ"));
        list.add(new Country("Macaristan", "Budapeşte", new ArrayList<>(), "🇭🇺", "H"));
        list.add(new Country("Romanya", "Bükreş", new ArrayList<>(), "🇷🇴", "RO"));
        list.add(new Country("İsveç", "Stockholm", new ArrayList<>(), "🇸🇪", "S"));
        list.add(new Country("Norveç", "Oslo", new ArrayList<>(), "🇳🇴", "N"));
        list.add(new Country("Danimarka", "Kopenhag", new ArrayList<>(), "🇩🇰", "DK"));
        list.add(new Country("Finlandiya", "Helsinki", new ArrayList<>(), "🇫🇮", "FIN"));

        // Asya ülkeleri
        list.add(new Country("Japonya", "Tokyo", new ArrayList<>(), "🇯🇵", "J"));
        list.add(new Country("Çin", "Pekin", new ArrayList<>(), "🇨🇳", "CN"));
        list.add(new Country("Güney Kore", "Seul", new ArrayList<>(), "🇰🇷", "ROK"));
        list.add(new Country("Hindistan", "Yeni Delhi", new ArrayList<>(), "🇮🇳", "IND"));
        list.add(new Country("Tayland", "Bangkok", new ArrayList<>(), "🇹🇭", "T"));
        list.add(new Country("Endonezya", "Jakarta", new ArrayList<>(), "🇮🇩", "RI"));
        list.add(new Country("Malezya", "Kuala Lumpur", new ArrayList<>(), "🇲🇾", "MAL"));
        list.add(new Country("Singapur", "Singapur", new ArrayList<>(), "🇸🇬", "SGP"));
        list.add(new Country("Vietnam", "Hanoi", new ArrayList<>(), "🇻🇳", "VN"));
        list.add(new Country("Pakistan", "İslamabad", new ArrayList<>(), "🇵🇰", "PK"));
        list.add(new Country("Bangladeş", "Dakka", new ArrayList<>(), "🇧🇩", "BD"));

        // Amerika kıtası
        list.add(new Country("Amerika Birleşik Devletleri", "Washington D.C.", new ArrayList<>(), "🇺🇸", "USA"));
        list.add(new Country("Kanada", "Ottawa", new ArrayList<>(), "🇨🇦", "CDN"));
        list.add(new Country("Meksika", "Mexico City", new ArrayList<>(), "🇲🇽", "MEX"));
        list.add(new Country("Brezilya", "Brasília", new ArrayList<>(), "🇧🇷", "BR"));
        list.add(new Country("Arjantin", "Buenos Aires", new ArrayList<>(), "🇦🇷", "RA"));
        list.add(new Country("Şili", "Santiago", new ArrayList<>(), "🇨🇱", "RCH"));
        list.add(new Country("Peru", "Lima", new ArrayList<>(), "🇵🇪", "PE"));
        list.add(new Country("Kolombiya", "Bogota", new ArrayList<>(), "🇨🇴", "CO"));

        // Okyanusya
        list.add(new Country("Avustralya", "Canberra", new ArrayList<>(), "🇦🇺", "AUS"));
        list.add(new Country("Yeni Zelanda", "Wellington", new ArrayList<>(), "🇳🇿", "NZ"));

        // Afrika
        list.add(new Country("Güney Afrika", "Pretoria", new ArrayList<>(), "🇿🇦", "ZA"));
        list.add(new Country("Mısır", "Kahire", new ArrayList<>(), "🇪🇬", "ET"));
        list.add(new Country("Nijerya", "Abuja", new ArrayList<>(), "🇳🇬", "WAN"));
        list.add(new Country("Kenya", "Nairobi", new ArrayList<>(), "🇰🇪", "EAK"));
        list.add(new Country("Fas", "Rabat", new ArrayList<>(), "🇲🇦", "MA"));

        // Orta Doğu
        list.add(new Country("Suudi Arabistan", "Riyad", new ArrayList<>(), "🇸🇦", "KSA"));
        list.add(new Country("Birleşik Arap Emirlikleri", "Abu Dabi", new ArrayList<>(), "🇦🇪", "UAE"));
        list.add(new Country("Katar", "Doha", new ArrayList<>(), "🇶🇦", "Q"));
        list.add(new Country("İsrail", "Kudüs", new ArrayList<>(), "🇮🇱", "IL"));
        list.add(new Country("Ürdün", "Amman", new ArrayList<>(), "🇯🇴", "JOR"));

        // Rusya ve komşuları
        list.add(new Country("Rusya", "Moskova", new ArrayList<>(), "🇷🇺", "RUS"));
        list.add(new Country("Ukrayna", "Kiev", new ArrayList<>(), "🇺🇦", "UA"));
        list.add(new Country("Kazakistan", "Astana", new ArrayList<>(), "🇰🇿", "KZ"));

        return list;
    }

    public List<Question> getPlateCodeQuestions(int count) {
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

    public List<Question> generateCapitalQuestions(int count) {
        List<Question> questions = new ArrayList<>();
        List<Country> shuffled = new ArrayList<>(countries);
        Collections.shuffle(shuffled);

        for (int i = 0; i < Math.min(count, shuffled.size()); i++) {
            Country correct = shuffled.get(i);
            List<String> options = generateOptions(correct.getCapital(), shuffled.stream()
                    .map(Country::getCapital).toList());

            Question q = new Question();
            q.setQuestion(correct.getName() + " ülkesinin başkenti nedir?");
            q.setOptions(options);
            q.setCorrectAnswer(correct.getCapital());
            q.setType("capital");

            questions.add(q);
        }

        return questions;
    }

    public List<Question> generateCityQuestions(int count) {
        List<Question> questions = new ArrayList<>();

        // Şehir-ülke eşleştirmeleri
        Map<String, String> cityCountryMap = new HashMap<>();
        cityCountryMap.put("İstanbul", "Türkiye");
        cityCountryMap.put("İzmir", "Türkiye");
        cityCountryMap.put("Antalya", "Türkiye");
        cityCountryMap.put("New York", "Amerika Birleşik Devletleri");
        cityCountryMap.put("Los Angeles", "Amerika Birleşik Devletleri");
        cityCountryMap.put("Chicago", "Amerika Birleşik Devletleri");
        cityCountryMap.put("Paris", "Fransa");
        cityCountryMap.put("Marsilya", "Fransa");
        cityCountryMap.put("Lyon", "Fransa");
        cityCountryMap.put("Berlin", "Almanya");
        cityCountryMap.put("Münih", "Almanya");
        cityCountryMap.put("Hamburg", "Almanya");
        cityCountryMap.put("Roma", "İtalya");
        cityCountryMap.put("Milano", "İtalya");
        cityCountryMap.put("Napoli", "İtalya");
        cityCountryMap.put("Londra", "İngiltere");
        cityCountryMap.put("Manchester", "İngiltere");
        cityCountryMap.put("Liverpool", "İngiltere");
        cityCountryMap.put("Madrid", "İspanya");
        cityCountryMap.put("Barcelona", "İspanya");
        cityCountryMap.put("Sevilla", "İspanya");
        cityCountryMap.put("Tokyo", "Japonya");
        cityCountryMap.put("Osaka", "Japonya");
        cityCountryMap.put("Kyoto", "Japonya");
        cityCountryMap.put("Moskova", "Rusya");
        cityCountryMap.put("St. Petersburg", "Rusya");
        cityCountryMap.put("Sydney", "Avustralya");
        cityCountryMap.put("Melbourne", "Avustralya");
        cityCountryMap.put("Rio de Janeiro", "Brezilya");
        cityCountryMap.put("Sao Paulo", "Brezilya");

        List<String> cities = new ArrayList<>(cityCountryMap.keySet());
        Collections.shuffle(cities);

        for (int i = 0; i < Math.min(count, cities.size()); i++) {
            String city = cities.get(i);
            String correctCountry = cityCountryMap.get(city);

            List<String> options = generateStringOptions(correctCountry, countries);

            Question q = new Question();
            q.setQuestion(city + " şehri hangi ülkededir?");
            q.setOptions(options);
            q.setCorrectAnswer(correctCountry);
            q.setType("city");

            questions.add(q);
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