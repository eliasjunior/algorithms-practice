var Student = (function () {
    function Student(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.fullname = firstname + " " + lastname;
    }
    return Student;
})();
var user = new Student("Jane", "User");
document.body.innerHTML = greeter(user);
