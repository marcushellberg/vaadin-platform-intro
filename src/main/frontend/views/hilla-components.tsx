import {ViewConfig} from "@vaadin/hilla-file-router/types.js";

export const config: ViewConfig = {
    title: 'Hilla Components',
    menu: {
        order: 3
    }
};

export default function HillaComponents() {
    return (
        <div className="p-m">
            <h1>Hilla Components</h1>
        </div>
    );
};