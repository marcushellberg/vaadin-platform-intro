package com.example.application;

import jakarta.annotation.security.PermitAll;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@PermitAll
@Route("secret")
@Menu(title = "Secret View", order = 8)
public class SecretView extends VerticalLayout {

    public SecretView() {
        add(new H1("This is a secret view"), new Paragraph("You need to be logged in to view me."));
    }
}
