package com.example.application;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Flow")
@Menu(title = "Flow Components", order = 1)
@Route("flow-components")
public class FlowComponents extends VerticalLayout {

    public FlowComponents() {

        var heading = new H1("Vaadin Components");
        var nameField = new TextField("Name");
        var greetButton = new Button("Greet");

        greetButton.addClickListener(e -> {
            Notification.show("Hello, " + nameField.getValue());
        });

        add(
            heading,
            new HorizontalLayout(nameField, greetButton) {{ setDefaultVerticalComponentAlignment(Alignment.BASELINE);}}
        );

 }

}
