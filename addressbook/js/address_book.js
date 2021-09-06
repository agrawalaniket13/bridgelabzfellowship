class Contact {

    get id() { return this._id; }
    set id(id) {
        this._id = id;
    }

    get firstName() {
        return this._firstName;
    }
    set firstName(firstName) {
        let firstNameRegex = RegExp('^[A-Z][a-z]{3,}$')
        if (firstNameRegex.test(firstName))
            this._firstName = firstName;
        else
            throw 'First Name Invalid'
    }

    get address() { return this._address; }
    set address(address) {
        this._address = address;
    }

    get city() { return this._city; }
    set city(city) {
        this._city = city;
    }

    get state() { return this._state; }
    set state(state) {
        this._state = state;
    }

    get zip() { return this._zip; }
    set zip(zip) {
        this._zip = zip;
    }

    get phone() {
        return this._phone;
    }

    set phone(phone) {
        let phoneRegex1 = RegExp('^[1-9][0-9]{9}$');
        let phoneRegex2 = RegExp('^[0-9]{2}[1-9][0-9]{9}$');
        let phoneRegex3 = RegExp('^[+][0-9]{2}[1-9][0-9]{9}$');
        if (phoneRegex1.test(phone) || phoneRegex2.test(phone) || phoneRegex3.test(phone))
            this._phone = phone;
        else
            throw 'Phone Number Invalid'
    }

    get email() { return this._email; }
    set email(email) {
        this._email = email;
    }

    toString() {
        return "Id = " + this.id + ", FirstName = " + this.firstName + ", Address = " + this.address +
            ", City = " + this.city + ", State = " + this.state + ", Zip = " + this.zip + ", Phone = " + this.phone + ", Email = " + this.email;
    }
}