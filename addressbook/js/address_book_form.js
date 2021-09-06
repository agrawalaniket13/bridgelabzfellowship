window.addEventListener('DOMContentLoaded', (event) => {
    const name = document.querySelector('#name');
    const textError = document.querySelector('.name-error');
    name.addEventListener('input', function () {
        let names = document.querySelector('#name').value.split(" ");
        if (name.value.length == 0) {
            textError.textContent = "";
            return;
        }
        try {
            (new Contact()).firstName = names[0];
            (new Contact()).lastName = names[1];
            textError.textContent = "";
        } catch (e) {
            textError.textContent = e;
        }
    });

    const phoneElement = document.querySelector('#phone');
    const phoneError = document.querySelector('.phone-error');
    phoneElement.addEventListener('input', function () {
        let phone = document.querySelector('#phone').value;
        try {
            (new Contact()).phone = phone;
            phoneError.textContent = "";
        } catch (e) {
            phoneError.textContent = e;
        }

    });

});

const resetForm = () => {
    setValue('#name','');
    setValue('#address','');
    setValue('#city','');
    setValue('#state','');
    setValue('#zip','');
    setValue('#phone','');
    setValue('#email','');
}

const unsetSelectedValues = (propertyValue) => {
    let allItems = document.querySelectorAll(propertyValue);
    allItems.forEach(item => {
        item.checked = false;
    });
}

const setTextValue = (id, value) => {
    const element = document.querySelector(id);
    element.textContent = value;
}

const setValue = (id, value) => {
    const element = document.querySelector(id);
    element.value = value;
}