package com.example.application;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Flow Contacts View")
@Route("flow-contacts")
@Menu(title = "Flow Data", order = 2)
public class FlowData extends VerticalLayout {

    public FlowData(ContactService service) {

        var grid = new Grid<>(Contact.class, false);

        grid.addComponentColumn(contact -> new Image(contact.getPictureUrl(), contact.getFirstName() + " " + contact.getLastName())).setAutoWidth(true);
        grid.addColumn(Contact::getFirstName).setHeader("First Name").setAutoWidth(true);
        grid.addColumn(Contact::getLastName).setHeader("Last Name").setAutoWidth(true);
        grid.addColumn(Contact::getEmail).setHeader("Email").setAutoWidth(true);
        grid.addComponentColumn(contact -> new DatePicker(contact.getLastContacted())).setHeader("Last Contacted").setAutoWidth(true);



        add(
            new H1("Contacts"),
            grid
        );
    }
}
