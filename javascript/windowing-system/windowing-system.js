// @ts-check

/**
 * Implement the classes etc. that are needed to solve the
 * exercise in this file. Do not forget to export the entities
 * you defined so they are available for the tests.
 */

class Size {
    constructor(width = 80, height = 60) {
        this._width = width;
        this._height = height;
    }

    get width() {
        return this._width;
    }

    get height() {
        return this._height;
    }

    resize(newWidth, newHeight) {
        this._width = newWidth;
        this._height = newHeight;
    }
}

class Position {
    constructor(x = 0, y = 0) {
        this._x = x;
        this._y = y;
    }

    get x () { return this._x; }
    get y () { return this._y; }

    move(newX, newY) {
        this._x = newX;
        this._y = newY;
    }
}

class ProgramWindow {
    constructor() {
        this._screenSize = new Size(800, 600);
        this._size = new Size();
        this._position = new Position();
    }

    get screenSize() { return this._screenSize; }
    get size() { return this._size; }
    get position() { return this._position; }

    move(newPosition) {
        const MIN_X = 0;
        const MIN_Y = 0;
        let x = newPosition.x; let y = newPosition.y;
        if (newPosition.x < 0) { x = MIN_X; }
        if (newPosition.y < 0) { y = MIN_Y; }
        if (x + this.size.width > this.screenSize.width) {
            x = this.screenSize.width - this.size.width;
        }
        if (y + this.size.height > this.screenSize.height) {
            y = this.screenSize.height - this.size.height;
        }
        this.position.move(x, y);
    }

    resize(newSize) {
        const MIN_WIDTH = 1;
        const MIN_HEIGHT = 1;
        let width = newSize.width, height = newSize.height;
        if (newSize.width < 1) { width = MIN_WIDTH; }
        if (newSize.height < 1) { height = MIN_HEIGHT; }
        if (width + this.position.x > this.screenSize.width) {
            width = this.screenSize.width - this.position.x;
        }
        if (height + this.position.y > this.screenSize.height) {
            height = this.screenSize.height - this.position.y;
        }
        this.size.resize(width, height);
    }
}

function changeWindow(programWindow) {
    const newWidth = 400; const newHeight = 300;
    const newX = 100; const newY = 150;
    programWindow.resize(new Size(newWidth, newHeight));
    programWindow.move(new Position(newX, newY));

    return programWindow;
}
/*
    algorithm
    1.  screenSize is set to width (x) 800 and height (y) 600
    2.  if new size is less than 1 then it needs to be set to 1
    3.  the new size plus the current position cannot exceed
*/


export { Size, Position, ProgramWindow, changeWindow }
