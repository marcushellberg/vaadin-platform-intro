import {EmailField} from '@vaadin/react-components/EmailField';
import {TextField} from '@vaadin/react-components/TextField';
import {ViewConfig} from "@vaadin/hilla-file-router/types.js";

export const config: ViewConfig = {
    title: 'Copilot Drag and Drop',
    menu: {
        order: 5
    }
};


export default function CopilotDragAndDrop() {
    return (
        <div className="flex flex-col p-m gap-m">
            <h1>Sign up</h1>
            <div className="flex gap-m w-full">
                <TextField label="First Name" placeholder="John" className="w-full"/>
                <TextField label="Last Name" placeholder="Doe" className="w-full"/>
            </div>
            <EmailField label="Email" placeholder="john@doe.com"/>
        </div>
    );
};