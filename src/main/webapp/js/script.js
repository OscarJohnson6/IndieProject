// Adds on change event listener to select tag
const init = () => {
    document.getElementById('formSelector').addEventListener('change', event => {
        // Get value of the selected option
        let selectedValue = event.target.value;
        console.log(selectedValue)
        // Show the form that matches the selected option
        let forms = document.querySelectorAll('form');
        console.log(forms)
        forms.forEach(form => {
            if (form.id === selectedValue) {
                form.classList.remove('hidden');
            } else {
                form.classList.add('hidden');
            }
        });
    });
}

window.addEventListener('load', init);
