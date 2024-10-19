import {ViewConfig} from '@vaadin/hilla-file-router/types.js';
import {useSignal} from "@vaadin/hilla-react-signals";
import {useEffect} from "react";
import {DatePicker, Grid, GridColumn} from "@vaadin/react-components";
import {Notification} from "@vaadin/react-components/Notification.js";
import Contact from 'Frontend/generated/com/example/application/Contact';
import {ContactService} from "Frontend/generated/endpoints";

export const config: ViewConfig = {
  title: 'Copilot AI',
  menu: {
    order: 7
  }
};

export default function CopilotAi() {

  const contacts = useSignal<Contact[]>([]);

  async function getProducts() {
    contacts.value = await ContactService.findAll();
  }

  useEffect(() => {
    getProducts();
  }, []);

  return (
    <div className="p-m">
      <Grid items={contacts.value}>
        <GridColumn autoWidth>
          {({item}) => <img src={item.pictureUrl} alt={`${item.firstName} ${item.lastName}`}/>}
        </GridColumn>
        <GridColumn path="firstName" autoWidth/>
        <GridColumn path="lastName" autoWidth/>
        <GridColumn path="email" autoWidth/>
        <GridColumn path="lastContacted" autoWidth>
          {({item}) => (
            <DatePicker value={item.lastContacted} onChange={e =>
              Notification.show(`${item.name} updated: ${e.target.value}`)}/>
          )}
        </GridColumn>
      </Grid>
    </div>
  );
}
