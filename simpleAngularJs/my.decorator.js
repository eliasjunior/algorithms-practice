function myDecorator() {
    console.log('Component')
    let vm = this;
}

angular
    .module("app")
    .component('myDecorator', {
        template: '<h1>Component title</h1>' +
            '<div><label><label/></div>' +
            '<input name="name" type="text" />',
        controller: myDecorator,
        controllerAs: 'vm'})