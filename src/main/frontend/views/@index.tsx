import { ViewConfig } from '@vaadin/hilla-file-router/types.js';

export const config: ViewConfig = {
  title: 'Intro to Vaadin',
    menu: {
        order: 0
    }
};

export default function HelloHillaView() {

  return (
    <div className="p-m">
      <h1>Intro to Vaadin</h1>
    </div>
  );
}
