package com.example.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;

@Service
@AnonymousAllowed
@BrowserCallable
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow();
    }
}
