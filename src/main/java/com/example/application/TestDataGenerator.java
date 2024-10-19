package com.example.application;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class TestDataGenerator implements ApplicationRunner {

    private final RestClient restClient;
    private final ContactRepository contactRepository;

    public TestDataGenerator(ContactRepository contactRepository, RestClient.Builder clientBuilder) {
        this.contactRepository = contactRepository;
        restClient = clientBuilder.baseUrl("https://randomuser.me/api")
            .build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (contactRepository.count() > 0) {
            return;
        }

        record Name(String title, String first, String last) {

        }
        record Picture(String large, String medium, String thumbnail) {

        }
        record Contact(Name name, String email, Picture picture) {

        }
        record Response(List<Contact> results) {

        }

        var response = restClient.get()
            .uri(u -> u.path("/")
                .queryParam("inc", "name,email,picture")
                .queryParam("results", "100")
                .build())
            .retrieve()
            .body(Response.class);

        if (response != null) {
            response.results.forEach(contact -> {
                contactRepository.save(new com.example.application.Contact(contact.name.first, contact.name.last, contact.email, contact.picture.thumbnail,
                    LocalDate.now()
                        .minusDays((long) (Math.random() * 365))));
            });
        }
    }

}
