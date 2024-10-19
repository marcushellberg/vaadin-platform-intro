import {ViewConfig} from "@vaadin/hilla-file-router/types.js";
import {TextField} from "@vaadin/react-components/TextField";
import {Button} from "@vaadin/react-components";
import {Notification} from "@vaadin/react-components/Notification.js";
import {useSignal} from "@vaadin/hilla-react-signals";

export const config: ViewConfig = {
    title: 'Hilla Components',
    menu: {
        order: 3
    }
};

export default function HillaComponents() {
    const name = useSignal('');

    function greet() {
        Notification.show(`Hello, ${name.value}!`);
    }

    return (
        <div className="p-m">
            <h1>Vaadin Components</h1>

            <div className="flex gap-m items-baseline">
                <TextField label="Name" value={name.value} onChange={e => name.value = e.target.value}/>
                <Button onClick={greet}>Greet</Button>
            </div>
        </div>
    );
};