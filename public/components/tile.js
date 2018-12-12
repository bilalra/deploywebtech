import {
    LitElement,
    html
} from 'https://unpkg.com/@polymer/lit-element/lit-element.js?module';

class Tile extends LitElement {
    static get properties() {
        return {
            value: {type: Number}
        };
    }

    constructor() {
        super();
    }

    getBackgroundColor() {
        switch (this.value) {
            case 2:
                return "#FFF835";
            case 4:
                return "#AED100";
            case 8:
                return "#7DD100";
            case 16:
                return "#50D100";
            case 32:
                return "#00D1A0";
            case 64:
                return "#005AD1";
            case 128:
                return "#4C00D1";
            case 256:
                return "#B500D1";
            case 512:
                return "#D10099";
            case 1024:
                return "#D1005E";
            case 2048:
                return "#D10000";
            default:
                return "#707070";
        }
    }

    render() {
        if (this.value == 0) {
            return html`<style>.tile {
          display: inline-block;
          width: 2.5em;
          height: 2.5em;
          font-size: 28px;
          margin: 3px;
          text-align: center;
          color: ${this.getBackgroundColor()};
          background-color: ${this.getBackgroundColor()};
          border-radius: 8px;
        }</style>
        <span class='tile'>${this.value}</span>`;
        } else {
            return html`<style>.tile {
          display: inline-block;
          width: 2.5em;
          height: 2.5em;
          font-size: 28px;
          margin: 3px;
          text-align: center;
          background-color: ${this.getBackgroundColor()};
          border-radius: 8px;
        }</style>
        <span class='tile'>${this.value}</span>`;
        }
    }
}

customElements.define('tile-component', Tile);
