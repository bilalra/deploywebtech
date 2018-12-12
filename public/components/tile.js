import {
    LitElement,
    html
} from 'https://unpkg.com/@polymer/lit-element/lit-element.js?module';

class Tile extends LitElement {
    static get properties() {
        return {
            value: {type: String}
        };
    }

    constructor() {
        super();
    }

    render() {
        return html`
                <style>
                .tile {
          display: inline-block;
          border-style: outset;
          border-width: 1px;
          border-color: black;
          width: 2.5em;
          height: 1.7em;
          font-size: 28px;
          margin: 3px;
          text-align: center;
          background-color: white;
        }
        </style>
        <span class='tile'>${this.value}</span>
        `;
    }
}

customElements.define('tile-component', Tile);
