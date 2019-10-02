
class Student {
    fullname : string;
    constructor(public firstname, public lastname) {
        this.fullname = firstname + " " + lastname;
    }
}

interface Person {
    firstname: string;
    lastname: string;
}

function greeter(person : Person) {
    return "Hello, " + person.firstname + " " + person.lastname;
}

var user = new Student("Jane", "User");

document.body.innerHTML = greeter(user);
