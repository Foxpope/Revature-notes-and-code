class MousePositionObservable {

    constructor() {
        this.subscriptions = [];
    }

    handleMouseMove = (e) => {
        this.subscriptions.forEach(sub => {
            sub(e.clientX, e.clientY)
        })
    }

    subscribe(callback) {

        this.subscriptions.push(callback);

        return () => {
            this.subscriptions = this.subscriptions.filter(cb => cb !== callback);
        }
    }

}

const mouseObservable = new MousePositionObservable();

mouseObservable.subscribe( (x,y) => {
    const board = document.querySelector('.mouse-position')

    board.innerHTML = `
        <div>
            <div>ClientX: ${x} </div>
            <div>ClientY: ${y} </div>
        </div>
    `

});